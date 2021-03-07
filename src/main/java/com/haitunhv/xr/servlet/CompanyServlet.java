package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Award;
import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.bean.base.UploadParams;
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


@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet<Company> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Company> companies = service.list();
        Company company = (companies != null && !companies.isEmpty()) ? companies.get(0):null;
        request.setAttribute("companyArr",companies);

        //转发
        forward(request,response,"admin/company.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        UploadParams uploadParams = Uploads.parseUploadRequest(request);

        Company company = new Company();
        BeanUtils.populate(company,uploadParams.getParams());

        FileItem item = uploadParams.getFileParams().get("logoFile");
        company.setLogo(Uploads.uploadImg(item,request,company.getLogo()));

        if (service.save(company)){
            redirect(request,response,"company/admin");
        }else {
            forwardError(request,response,"公司保存失败");
        }
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");
        List<Integer> idArr = new ArrayList<>();
        for (String id : ids) {
            idArr.add(Integer.valueOf(id));
        }

        if (service.removeAll(idArr)) {
            redirect(request,response,"company/admin");
        } else {
            forwardError(request,response,"公司删除失败");
        }
    }
}
