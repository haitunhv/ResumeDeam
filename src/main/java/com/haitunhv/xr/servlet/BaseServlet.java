package com.haitunhv.xr.servlet;

import com.haitunhv.xr.service.BaseService;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: haitunhv
 * @Date: 2021/2/21 23:24
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet<T> extends HttpServlet {
    static {
        DateConverter dateConverter = new DateConverter(null);
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd"});
        ConvertUtils.register(dateConverter, Date.class);
    }
    protected BaseService<T> service = newService();
    protected BaseService<T> newService(){
        try {
            String className = getClass().getName()
                    .replace(".servlet.",".service.impl.")
                    .replace("Servlet","ServiceImpl");
            return (BaseService<T>) Class.forName(className).newInstance();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //设置编码
            request.setCharacterEncoding("UTF-8");

            //利用方法名调用方法
            String uri = request.getRequestURI();
            String[] cmps =uri.split("/");
            String methodName = cmps[cmps.length-1];
            Method method = getClass()
                    .getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        }catch (Exception e){
            e.printStackTrace();

            Throwable cause = e;
            while (cause.getCause() != null){
                cause = cause.getCause();
            }
            forwardError(request,response,cause.getClass().getName());
        }
    }

    /**
     * 转发
     * @param request
     * @param response
     * @param path
     * @throws ServletException
     * @throws IOException
     */
    protected void forward(HttpServletRequest request, HttpServletResponse response ,String path) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/page/"+path).forward(request,response);
    }

    /**
     * 错误转发
     * @param request
     * @param response
     * @param errorMsg
     * @throws ServletException
     * @throws IOException
     */
    protected void forwardError(HttpServletRequest request, HttpServletResponse response ,String errorMsg) throws ServletException, IOException{
        request.setAttribute("error",errorMsg);
        forward(request,response,"error.jsp");
    }

    /**
     * 重新向
     * @param request
     * @param response
     * @param path
     * @throws ServletException
     * @throws IOException
     */
    protected void redirect(HttpServletRequest request, HttpServletResponse response ,String path) throws ServletException, IOException{
        response.sendRedirect(request.getContextPath()+"/"+path);
    }
}
