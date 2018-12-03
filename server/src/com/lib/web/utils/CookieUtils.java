package com.lib.web.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie getCookie(Cookie[] cookies, String cookieName) {
        if (StringUtils.isEmpty(cookieName)) {
            return null;
        }
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie;
                }

            }
        }
        return null;

    }
}
