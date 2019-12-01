package com.sun.chau.constant;

import java.io.File;

public class DefaultPath {
    public static final String TRANSACTION_PATH = "api/transactions";
    public static final String PROMOTION_PATH = "api/promotions";
    public static final String CATEGORY_PATH = "api/categories";
    public static final String PRODUCT_PATH = "api/products";
    public static final String SIZE_PATH = "api/sizes";
    public static final String MATERIAL_PATH = "api/materials";
    public static final String IMAGE_PATH = "api/images";

    public static final String ACCOUNT_PUBLIC_PATH = "api-public/accounts";
    public static final String SHIPPER_PUBLIC_PATH = "api-public/shippers";
    public static final String CATEGORY_PUBLIC_PATH = "api-public/categories";
    public static final String MATERIAL_PUBLIC_PATH = "api-public/materials";
    public static final String PRODUCT_PUBLIC_PATH = "api-public/products";
    public static final String SIZE_PUBLIC_PATH = "api-public/sizes";
    public static final String TRANSACTION_PUBLIC_PATH = "api-public/transactions";

    public static final String USER = "/user";
    public static final String SHIPPER = "/shipper";
    public static final String SHOP = "/shop";

    // Used for access image from url.
    public static final String FILE_URL = "http://103.95.197.184:9090/images";

    public static final String PRODUCT_FILE_URL = FILE_URL + "/products/";
    public static final String SHOP_FILE_URL = FILE_URL + "/shops/";
    public static final String CATEGORY_FILE_URL = FILE_URL + "/categories/";
    public static final String IMAGE_FILE_URL = FILE_URL + "/image/";
    public static final String COMMON_FILE_URL = FILE_URL + "/common/";



    // Used for creating directory.
    public static final String ROOT_FOLDER = System.getProperty("user.home") + File.separator + "kirinonline" + File.separator + "images";

    public static final String PRODUCT_FOLDER = ROOT_FOLDER  + File.separator + "products";
    public static final String SHOP_FOLDER = ROOT_FOLDER  + File.separator + "shops";
    public static final String COVER_FOLDER = ROOT_FOLDER  + File.separator + "covers";
    public static final String IMAGE_FOLDER = ROOT_FOLDER  + File.separator + "image";
    public static final String CATEGORY_FOLDER = ROOT_FOLDER  + File.separator + "categories";
    public static final String COMMON_FOLDER = ROOT_FOLDER  + File.separator + "common";

}
