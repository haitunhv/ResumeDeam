package com.haitunhv.factory;

import com.haitunhv.dao.PersonDao;
import com.haitunhv.service.PersonService;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: gss
 * @Date: 2021/3/27 21:30
 */
public class GeneralFactory {
    private static Properties properties;
    static {
        try(InputStream is = GeneralFactory.class.getClassLoader().getResourceAsStream("factory.properties")){
            properties = new Properties();
            properties.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static <T> T get(String name){
        try{
            //类名
            String claName = properties.getProperty(name);
            Class cls = Class.forName(claName);
            return (T) cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    public static PersonService getService(){
//        return get("service");
//    }
//    public static PersonDao getDao(){
//        return  get("dao");
//    }
}
