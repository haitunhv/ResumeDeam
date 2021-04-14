package com.haitunhv.cfg;

import com.haitunhv.converter.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/4/13 22:28
 */
@ComponentScan("com.haitunhv.controller")
public class SpringMVCConfig implements WebMvcConfigurer {
    @Autowired
    private DateConverter dateConverter;
    /**
     * 处理静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver= new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return  resolver;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //设置返回的普通字符串的编码
        StringHttpMessageConverter StringConverter = new StringHttpMessageConverter();
        StringConverter.setDefaultCharset(StandardCharsets.UTF_8);
        converters.add(StringConverter);

        //设置返回的json数据的编码
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setDefaultCharset(StandardCharsets.UTF_8);
        converters.add(jsonConverter);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
    }
}
