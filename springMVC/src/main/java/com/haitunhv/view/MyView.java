package com.haitunhv.view;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * @Author: gss
 * @Date: 2021/4/8 22:15
 */
public class MyView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) throws Exception{

        //查找文件是否存在
        String path = getServletContext().getRealPath("/") + getUrl();
        File file = new File(path);
        return file.exists();
    }
}
