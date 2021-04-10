package com.haitunhv.resolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: haitunhv
 * @Date: 2021/4/9 21:52
 */
@Component
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e);
        mv.setViewName("/WEB-INF/page/error/default.jsp");
        return mv;
    }
}
