package com.sun.chau.service.Impl;

import com.sun.chau.constant.DefaultParam;
import com.sun.chau.constant.DefaultPath;
import com.sun.chau.model.ImageModel;
import com.sun.chau.service.FileService;
import com.sun.chau.service.ImageService;
import com.sun.chau.service.ProductService;
import com.sun.chau.utility.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String target, String target_id, String imageString, String productFolder) {
        ImageUtil imageUtil = new ImageUtil(imageString);

        if (imageUtil.isNoImageFound() || imageUtil.isImageAlreadyExist()) {
            return imageUtil.getImageString();
        }
        try {
            ImageModel image = imageUtil.getImage();
            String imageDir;
            String targetImageUrl;

            switch (target) {
                case "product":
                    imageDir = DefaultPath.PRODUCT_FOLDER + File.separator + target_id + File.separator + productFolder;
                    targetImageUrl = DefaultPath.PRODUCT_FILE_URL + target_id + "/" + productFolder + "/";
                    break;
                case "shop":
                    imageDir = DefaultPath.SHOP_FOLDER + File.separator + target_id;
                    targetImageUrl = DefaultPath.SHOP_FILE_URL + target_id + "/";
                    break;
                default:
                    imageDir = DefaultPath.COMMON_FOLDER + File.separator + target_id;
                    targetImageUrl = DefaultPath.COMMON_FILE_URL + target_id + "/";
            }

            // Create directory for image if not exist
            if (!ImageUtil.createDirectories(imageDir)) {
                return DefaultParam.DEFAULT_IMAGE; // Can not create directory
            } else {
                ImageUtil.cleanDirectory(imageDir);
            }

            //Decode image
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imageBytes = decoder.decodeBuffer(image.getBase64String());

            // Save image to directory
            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage bi = ImageIO.read(bis);
            File outputFile = new File(imageDir + File.separator + image.generateNameByNanoTime());
            ImageIO.write(bi, image.getFormat(), outputFile);
            return targetImageUrl + image.getName();

        } catch (IOException | NullPointerException | UnsupportedOperationException | ArrayIndexOutOfBoundsException iOE) {
            return DefaultParam.DEFAULT_IMAGE;
        }
    }
}
