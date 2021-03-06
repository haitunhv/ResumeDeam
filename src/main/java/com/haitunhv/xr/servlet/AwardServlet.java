package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Award;
import com.haitunhv.xr.until.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author: gss
 * @Date: 2021/3/1 22:18
 */
@WebServlet("/award/*")
public class AwardServlet extends BaseServlet<Award> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Award> awards = service.list();
        Award award = (awards != null && !awards.isEmpty()) ? awards.get(0):null;
        request.setAttribute("awards",awards);

        //转发
        forward(request,response,"admin/award.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");

        List<FileItem> items = upload.parseRequest(request);
        //非文件参数
        Map<String,Object> params = new HashMap<>();
        //文件参数
        Map<String,FileItem> fileParam = new HashMap<>();
        //存储到数据库的文件路径
        for (FileItem item : items) {
            String fieldName = item.getFieldName();
            if (item.isFormField()){
                //非文件参数
                params.put(fieldName,item.getString("UTF-8"));
            }else {
                //文件参数
                fileParam.put(fieldName,item);
            }
        }

        Award award = new Award();
        BeanUtils.populate(award,params);

        FileItem item = fileParam.get("imgFile");
        award.setImage(Uploads.uploadImg(item,request,award.getImage()));

        if (service.save(award)){
            redirect(request,response,"award/admin");
        }else {
            forwardError(request,response,"获奖成就保存失败");
        }
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");
        List<Integer> idArr = new ArrayList<>();
        for (String id : ids) {
            idArr.add(Integer.valueOf(id));
        }

        if (service.removeAll(idArr)) {
            redirect(request,response,"award/admin");
        } else {
            forwardError(request,response,"获奖成就删除失败");
        }
    }
}
