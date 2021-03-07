package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Project;
import com.haitunhv.xr.until.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/project/*")
public class ProjectServlet extends BaseServlet<Project> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{

    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{

    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
