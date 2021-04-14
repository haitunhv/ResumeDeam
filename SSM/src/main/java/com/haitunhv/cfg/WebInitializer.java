package com.haitunhv.cfg;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Author: haitunhv
 * @Date: 2021/4/13 22:23
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 父容器的配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    /**
     * 子容器的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    /**
     * 配置DispatcherServler的url-pattern
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //添加Filter
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("CharacterEncodingFilter",new CharacterEncodingFilter("UTF-8"));
        encodingFilter.addMappingForUrlPatterns(null,false,"/*");
    }
}
