package com.haitunhv.xr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: gss
 * @Date: 2021/3/11 22:00
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //放行登录页
        String uri = request.getRequestURI();
        if (uri.contains("/asset/")){
            chain.doFilter(req, resp);
        }else if (uri.contains("/admin") || uri.contains("/remove") || uri.contains("/save")){
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                chain.doFilter(req, resp);
            }else {
                response.sendRedirect(request.getContextPath()+"/page/login.jsp");
            }
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
