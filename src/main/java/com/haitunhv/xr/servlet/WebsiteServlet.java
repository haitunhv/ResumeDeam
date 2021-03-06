package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Website;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: gss
 * @Date: 2021/2/21 23:21
 */
@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet<Website> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Website> websites = service.list();
        Website website = (websites != null && !websites.isEmpty()) ? websites.get(0):null;
        request.setAttribute("website",website);
        //转发
        forward(request,response,"admin/website.jsp");

    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Website website = new Website();
        BeanUtils.populate(website,request.getParameterMap());
        if (service.save(website)){
            redirect(request,response,"website/admin");
        }else {
            forwardError(request,response,"网站信息保存失败");
        }
    }
}
