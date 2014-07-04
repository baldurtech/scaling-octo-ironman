package com.baldurtech.scaling.octo.ironman;

import javax.servlet.http.HttpServletRequest;

public class RequestForm {
    private final HttpServletRequest request;

    public RequestForm(HttpServletRequest request) {
        this.request = request;
    }

    public String getString(String param) {
        return request.getParameter(param);
    }

    public Boolean isGetMethod() {
        return "GET".equals(request.getMethod());
    }

    public Boolean isPostMethod() {
        return "POST".equals(request.getMethod());
    }
}
