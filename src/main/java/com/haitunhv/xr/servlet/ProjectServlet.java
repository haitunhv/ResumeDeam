package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.bean.Project;
import com.haitunhv.xr.bean.Project;
import com.haitunhv.xr.bean.base.UploadParams;
import com.haitunhv.xr.service.CompanyService;
import com.haitunhv.xr.service.impl.CompanyServiceImpl;
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

    private CompanyService companyService = new CompanyServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Project> project = service.list();
        List<Company> companies = companyService.list();
        Project projects = (project != null && !project.isEmpty()) ? project.get(0):null;
        request.setAttribute("projects",project);
        request.setAttribute("companies",companies);

        //转发
        forward(request,response,"admin/project.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        UploadParams uploadParams = Uploads.parseUploadRequest(request);
        Project project = new Project();
        BeanUtils.populate(project, uploadParams.getParams());

        FileItem item = uploadParams.getFileParams().get("imgFile");
        project.setImage(Uploads.uploadImg(item,request,project.getImage()));

        //对公司信息做特殊处理
        Company company = new Company();
        company.setId(Integer.valueOf(uploadParams.getParams().get("companyId").toString()));
        project.setCompany(company);
        if (service.save(project)) {
            redirect(request,response,"project/admin");
        } else {
            forwardError(request,response,"项目经验保存失败");
        }
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");
        List<Integer> idArr = new ArrayList<>();
        for (String id : ids) {
            idArr.add(Integer.valueOf(id));
        }

        if (service.removeAll(idArr)) {
            redirect(request,response,"project/admin");
        } else {
            forwardError(request,response,"项目经验删除失败");
        }
    }
}
