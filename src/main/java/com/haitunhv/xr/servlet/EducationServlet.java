package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Education;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gss
 * @Date: 2021/2/23 22:22
 */
@WebServlet("/education/*")
public class EducationServlet extends BaseServlet<Education> {


    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("educations", service.list());

        //转发
        forward(request,response,"admin/education.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Education education = new Education();
        BeanUtils.populate(education, request.getParameterMap());
        if (service.save(education)) {
            redirect(request,response,"education/admin");
        } else {
            forwardError(request,response,"教育信息保存失败");
        }
    }
//
//    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Integer id = Integer.valueOf(request.getParameter("id"));
//        if (educationService.remove(id)) {
//            response.sendRedirect(request.getContextPath() + "/education/admin");
//        } else {
//            request.setAttribute("error", "教育信息删除失败");
//            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
//        }
//    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");
        List<Integer> idArr = new ArrayList<>();
        for (String id : ids) {
            idArr.add(Integer.valueOf(id));
        }

        if (service.removeAll(idArr)) {
            redirect(request,response,"education/admin");
        } else {
            forwardError(request,response,"教育信息删除失败");
        }
    }
}
