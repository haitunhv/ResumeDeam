package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Skill;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gss
 * @Date: 2021/2/28 20:20
 */
@WebServlet("/skill/*")
public class SkillServlet extends BaseServlet<Skill> {
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("skills", service.list());

        //转发
        forward(request,response,"admin/skill.jsp");
    }
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Skill skill = new Skill();
        BeanUtils.populate(skill, request.getParameterMap());
        if (service.save(skill)) {

            redirect(request,response,"skill/admin");
        } else {
            forwardError(request,response,"专业技能保存失败");
        }
    }


    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");
        List<Integer> idArr = new ArrayList<>();
        for (String id : ids) {
            idArr.add(Integer.valueOf(id));
        }

        if (service.removeAll(idArr)) {
            redirect(request,response,"skill/admin");
        } else {
            forwardError(request,response,"专业技能删除失败");
        }
    }
}
