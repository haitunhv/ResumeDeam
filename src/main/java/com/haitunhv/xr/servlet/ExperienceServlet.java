package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Award;
import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.bean.Education;
import com.haitunhv.xr.bean.Experience;
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


@WebServlet("/experience/*")
public class ExperienceServlet extends BaseServlet<Experience> {
    private CompanyService companyService = new CompanyServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Experience> experiences = service.list();
        List<Company> companies = companyService.list();
        Experience experience = (experiences != null && !experiences.isEmpty()) ? experiences.get(0):null;
        request.setAttribute("experiences",experiences);
        request.setAttribute("companies",companies);

        //转发
        forward(request,response,"admin/experience.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Experience experience = new Experience();
        BeanUtils.populate(experience, request.getParameterMap());

        //对公司信息做特殊处理
        Company company = new Company();
        company.setId(Integer.valueOf(request.getParameter("companyId")));
        experience.setCompany(company);
        if (service.save(experience)) {
            redirect(request,response,"experience/admin");
        } else {
            forwardError(request,response,"工作经验保存失败");
        }
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");
        List<Integer> idArr = new ArrayList<>();
        for (String id : ids) {
            idArr.add(Integer.valueOf(id));
        }

        if (service.removeAll(idArr)) {
            redirect(request,response,"experience/admin");
        } else {
            forwardError(request,response,"工作经验删除失败");
        }
    }
}
