package com.haitunhv.xr.util;

import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.bean.Experience;
import com.haitunhv.xr.bean.Project;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: haitunhv
 * @Date: 2021/3/6 16:01
 */
public class TplTest {
    private static final Class[] CLASSES = {Company.class, Project.class, Experience.class};
    private static final Map<String,String> TPL_DIR = new HashMap<>();
    private static final  String BASE_DIR = "";
    static {
        TPL_DIR.put("Dao",BASE_DIR+"dao");
        TPL_DIR.put("DaoImpl",BASE_DIR+"dao/impl");
        TPL_DIR.put("Service",BASE_DIR+"service");
        TPL_DIR.put("ServiceImpl",BASE_DIR+"service/impl");
        TPL_DIR.put("Servlet",BASE_DIR+"servlet");

    }

    public static void main(String[] args) throws Exception {
        for (Map.Entry<String,String> entry : TPL_DIR.entrySet()){
            //后缀
            String suffix = entry.getKey();
            String dir = entry.getValue();
            //获取tpl文件的路径
            String tpl = "tpl/" + suffix+".tpl";
            String tplFilePath = TplTest.class.getClassLoader().getResource(tpl).getFile();
            //模板文件内容
            String text = FileUtils.readFileToString(new File(tplFilePath),"UTF-8");
            //根据类名替换文件内容
            for (Class aClass : CLASSES) {
                String className = aClass.getSimpleName();
                String newText = text.replace("#0#",className);
                String fileName = className + suffix + ".java";
                String filepath = BASE_DIR +"/"+ dir + "/"+fileName;
                //写文件
                File file = new File(filepath);
                //判断文件是否已经存在
                if (file.exists()){
                    System.out.println("已存在："+ file);
                    continue ;
                }
                FileUtils.writeStringToFile(file,newText,"UTF-8");
                System.out.println("新生成："+file);
            }
        }
    }
}
