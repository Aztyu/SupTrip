package com.suptrip.website.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        
        if(session != null && session.getAttribute("user") != null){
        	System.out.println("Connect�");
        	return true;
        }else{
        	response.sendRedirect(request.getContextPath() + "/");
        	System.out.println("d�connexion");
        	return false;
        }
    }

}
