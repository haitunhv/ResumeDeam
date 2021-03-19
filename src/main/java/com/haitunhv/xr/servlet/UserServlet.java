package com.haitunhv.xr.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.haitunhv.xr.bean.User;
import com.haitunhv.xr.bean.base.UploadParams;
import com.haitunhv.xr.service.AwardService;
import com.haitunhv.xr.service.SkillServer;
import com.haitunhv.xr.service.UserService;
import com.haitunhv.xr.service.WebsiteService;
import com.haitunhv.xr.service.impl.AwardServiceImpl;
import com.haitunhv.xr.service.impl.SkillServerImpl;
import com.haitunhv.xr.service.impl.WebsiteServiceImpl;
import com.haitunhv.xr.until.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@WebServlet("/user/*")
public class UserServlet extends BaseServlet<User> {
    private SkillServer skillServer = new SkillServerImpl();
    private AwardService awardService = new AwardServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String[] cmps = uri.split("/");
        String methodName = "/" + cmps[cmps.length - 1];
        if (methodName.equals(request.getContextPath())){
            try {
                front(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            super.doGet(request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setAttribute("user",service.list().get(0));
        forward(request,response,"admin/user.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        UploadParams params = Uploads.parseUploadRequest(request);
        //请求参数转User
        User user = new User();
        BeanUtils.populate(user,params.getParams());

        //从session中获取密码
        User LoginUser = (User) request.getSession().getAttribute("user");
        user.setPassword(LoginUser.getPassword());
        FileItem item = params.getFileParams().get("photoFile");
        user.setEmail(LoginUser.getEmail());
        user.setPhoto(Uploads.uploadImg(item,request,user.getPhoto()));
        if (service.save(user)){
            request.getSession().setAttribute("user",user);
            redirect(request,response,"user/admin");
        }else {
            forwardError(request,response,"用户信息保存失败");
        }

    }

    /**
     * 退出
     * @param request
     * @param response
     * @throws Exception
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //清除session
        request.getSession().removeAttribute("user");
        redirect(request,response,"page/login.jsp");
    }
    public void password(HttpServletRequest request, HttpServletResponse response) throws Exception {
        forward(request,response,"admin/password.jsp");
    }
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oldPassword = request.getParameter("oldPassword");
        //与session比较
        User user = (User) request.getSession().getAttribute("user");
        if(!oldPassword.equals(user.getPassword())){
            forwardError(request,response,"旧密码不正确");
            return;
        }
        //保存新密码
        String newPassword = request.getParameter("newPassword");
        user.setPassword(newPassword);
        if (service.save(user)){
            redirect(request,response,"page/login.jsp");
        }else {
            forwardError(request,response,"保存密码失败");
        }
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //验证验证码
        String captcha = request.getParameter("captcha").toLowerCase();

        //从session中取出验证码
        String code = (String) request.getSession().getAttribute("code");
        response.setContentType("text/json;charset=UTF-8");
        Map<String,Object> result = new HashMap<>();
        if (!captcha.equals(code)){
//            forwardError(request,response,"验证码不正确");
            result.put("success",false);
            result.put("msg","验证码不正确");
        }else {
            //验证用户名密码
            User user = new User();
            BeanUtils.populate(user,request.getParameterMap());
            user = ((UserService) service).get(user);
            if (user != null){
                request.getSession().setAttribute("user",user);
                result.put("success",true);
                //登录成功
//            redirect(request,response,"user/admin");
            }else {
                //登录失败
                result.put("success",false);
                result.put("msg","邮箱或密码错误");
//            forwardError(request,response,"邮箱或密码错误");
            }
        }

        Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
        cookie.setMaxAge(3600*24*7);
        response.addCookie(cookie);

        response.getWriter().write(new ObjectMapper().writeValueAsString(result));

    }

    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //创建Katpcha对象
        DefaultKaptcha dk = new DefaultKaptcha();
        //验证码配置
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("kaptcha.properties")){
            Properties properties = new Properties();
            properties.load(is);

            Config config = new Config(properties);
            dk.setConfig(config);
            //生成验证码字符串
            String code = dk.createText();
            //存储到session
            HttpSession session = request.getSession();
            session.setAttribute("code",code.toLowerCase());

            //生成验证码图片
            BufferedImage image = dk.createImage(code);

            //设置返回数据格式
            response.setContentType("image/jpeg");
            //将图片数据写回到客户端
            ImageIO.write(image,"jpg",response.getOutputStream());
        }
    }
    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //用户信息
        User user = service.list().get(0);
        request.setAttribute("user",user);
        //个人特质
        request.setAttribute("trait",user.getTrait().split(","));
        //兴趣爱好
        request.setAttribute("interests",user.getInterests().split(","));

        //专业技能
        request.setAttribute("skills",skillServer.list());
        //获奖成就
        request.setAttribute("awards",awardService.list());
        //网站底部信息
        request.setAttribute("footer",websiteService.list().get(0));
        forward(request,response,"front/user.jsp");
    }
}
