package com.haitunhv.servlet;

import com.haitunhv.factory.GeneralFactory;
import com.haitunhv.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: haitunhv
 * @Date: 2021/3/27 21:21
 */
public class PersonServlet {
//    private PersonService service = GeneralFactory.get("personService");
    private PersonService service;

    public void setService(PersonService service) {
        this.service = service;
    }

    public void remove(){
        service.remove(1);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        PersonServlet servlet = ctx.getBean("personServlet",PersonServlet.class);
        servlet.remove();
    }
}
