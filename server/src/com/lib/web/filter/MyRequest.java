package com.lib.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.time.OffsetDateTime;
import java.util.Map;

public class MyRequest extends HttpServletRequestWrapper {
    private boolean encoded = false;

    public MyRequest(HttpServletRequest request) {
        super(request);
    }


    @Override
    public String getParameter(String name) {
        String[] parameterValues = getParameterValues(name);
        if (parameterValues == null) {
            return null;
        }
        return parameterValues[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        return getParameterMap().get(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = super.getParameterMap();
        try {

            if (!encoded) {
                if ("GET".equalsIgnoreCase(super.getMethod())) {
                    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                        String[] allValue = entry.getValue();
                        for (int i = 0; i < allValue.length; i++) {
                            String characterEncoding = super.getCharacterEncoding();
                            if (characterEncoding == null) {
                                characterEncoding = "UTF-8";
                            }

                            allValue[i] = new String(allValue[i].getBytes("ISO-8859-1"), characterEncoding);

                        }
                    }
                    encoded = true;
                }
            }
            return parameterMap;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
