package com.sun.chau.utility;

import java.util.Objects;

public class StringUtility {

    public static boolean isBlank(String s){
        return Objects.isNull(s) || s.equals("");
    }
}
