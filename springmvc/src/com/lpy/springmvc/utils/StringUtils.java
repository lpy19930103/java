package com.lpy.springmvc.utils;

public class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.length() < 1;
    }
}
