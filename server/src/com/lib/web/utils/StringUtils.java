package com.lib.web.utils;

public class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    public static boolean notEmpty(String str){
        return !isEmpty(str);
    }
}
