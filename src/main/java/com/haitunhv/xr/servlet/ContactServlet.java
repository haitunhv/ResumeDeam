package com.haitunhv.xr.servlet;

import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.bean.Contact;
import com.haitunhv.xr.bean.base.UploadParams;
import com.haitunhv.xr.bean.vo.ContactListParam;
import com.haitunhv.xr.service.ContactService;
import com.haitunhv.xr.service.UserService;
import com.haitunhv.xr.service.WebsiteService;
import com.haitunhv.xr.service.impl.UserServiceImpl;
import com.haitunhv.xr.service.impl.WebsiteServiceImpl;
import com.haitunhv.xr.until.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/contact/*")
public class ContactServlet extends BaseServlet<Contact> {
    private UserService userService = new UserServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception{

        request.setAttribute("user",userService.list().get(0));
        request.setAttribute("footer",websiteService.list().get(0).getFooter());
        forward(request,response,"front/contact.jsp");
    }
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ContactListParam param = new ContactListParam();
        request.setAttribute("contacts",((ContactService)service).list(param));
        forward(request,response,"admin/contact.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String code = (String) request.getSession().getAttribute("code");
        String captcha = request.getParameter("captcha");
        if (!captcha.equals(code)){
            forwardError(request,response,"验证码错误");
            return;
        }

        Contact contact = new Contact();
        BeanUtils.populate(contact,request.getParameterMap());
        if (service.save(contact)){
            redirect(request,response,"contact/front");
        }else {
            forwardError(request,response,"留言信息保存失败");
        }
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
