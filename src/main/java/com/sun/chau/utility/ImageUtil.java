package com.sun.chau.utility;

import com.sun.chau.constant.DefaultParam;
import com.sun.chau.constant.DefaultPath;
import com.sun.chau.model.ImageModel;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;


public class ImageUtil {
    private static final String imagePattern = "([^,]+),([a-zA-Z]+)\\/([a-zA-Z]+),([0-9]+),([^\\\"]+)";

    private String imageString;

    public ImageUtil() {
    }

    public ImageUtil(String base64String) {
        this.imageString = base64String;
    }

    public static boolean createDirectory(String directory) {
        File file = new File(directory);
        return file.exists() || file.mkdir();
    }

    public static boolean createDirectories(String directory) {
        File file = new File(directory);
        return file.exists() || file.mkdirs();
    }

    public static void cleanDirectory(String directory) throws IOException {
        File file = new File(directory);
        FileUtils.cleanDirectory(file);
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public boolean isNoImageFound() {
        return StringUtility.isBlank(this.imageString);
    }

    public boolean isImageAlreadyExist() {
        return this.imageString.contains(DefaultPath.FILE_URL);
    }

    public boolean validate(String base64String) {
        Pattern pattern = Pattern.compile(imagePattern);
        return pattern.matcher(base64String).matches();
    }

    public ImageModel getImage() {
        if (!validate(this.imageString)) {
            return null;
        }

        try {
            String imageName = this.imageString.split(DefaultParam.IMAGE_SEPARATOR)[0];
            String imageFormat = this.imageString.split(DefaultParam.IMAGE_SEPARATOR)[1].split("/")[1];
            String fileType = this.imageString.split(DefaultParam.IMAGE_SEPARATOR)[1].split("/")[0];
            long imageSize = Long.parseLong(this.imageString.split(DefaultParam.IMAGE_SEPARATOR)[2]);
            String imageData = this.imageString.split(DefaultParam.IMAGE_SEPARATOR)[3];

            if (!"image".equals(fileType) || imageSize > DefaultParam.MAX_IMAGE_SIZE) {
                return null;
            }

            return new ImageModel(imageName, imageSize, imageFormat, imageData);
        } catch (Exception ex) {
            return null;
        }
    }
}