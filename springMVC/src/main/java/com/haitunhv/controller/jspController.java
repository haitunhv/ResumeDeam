package com.haitunhv.controller;

import com.haitunhv.domain.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: haitunhv
 * @Date: 2021/4/8 20:51
 */
@Controller
public class jspController {
    @RequestMapping("jsp1")
    public ModelAndView jsp1(){
        ModelAndView mc = new ModelAndView();

        Car car = new Car();
        car.setName("BMW");
        mc.addObject(car);

        mc.setViewName("/page/jsp.jsp");

        return mc;
    }
}
