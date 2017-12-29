package com.quimera.corptextiljt.zk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.zkoss.zk.au.http.AuDynaMediar;

public class CustomAuDynaMediar extends AuDynaMediar {

@Override
public void service(HttpServletRequest request, HttpServletResponse response, String pi) throws ServletException, IOException {
    super.service(new CustomHttpRequest(request), response, pi);
}

private static class CustomHttpRequest extends HttpServletRequestWrapper {

    public CustomHttpRequest(HttpServletRequest request) {
        super(request);
    }

    public StringBuffer getRequestURL() {
        HttpServletRequest request = (HttpServletRequest) super.getRequest();
        StringBuffer url = request.getRequestURL();

        int idx = url.indexOf(";jsessionid=" + request.getSession().getId());

        if (idx != -1) {
            url = url.delete(idx, url.length());
        }

        return url;
    }
}
}
