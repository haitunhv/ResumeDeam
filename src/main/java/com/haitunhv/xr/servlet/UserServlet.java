package com.haitunhv.xr.servlet;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.haitunhv.xr.bean.User;
import com.haitunhv.xr.bean.base.UploadParams;
import com.haitunhv.xr.service.UserService;
import com.haitunhv.xr.until.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.*;


@WebServlet("/user/*")
public class UserServlet extends BaseServlet<User> {

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
            redirect(request,response,"user/admin");
        }else {
            forwardError(request,response,"用户信息保存失败");
        }

    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //验证验证码
        String captcha = request.getParameter("captcha").toLowerCase();

        //从session中取出验证码
        String code = (String) request.getSession().getAttribute("code");
        if (!captcha.equals(code)){
            forwardError(request,response,"验证码不正确");
            return;
        }

        //验证用户名密码
        User user = new User();
        BeanUtils.populate(user,request.getParameterMap());
        user = ((UserService) service).get(user);
        if (user != null){
            request.getSession().setAttribute("user",user);
            //登录成功
            redirect(request,response,"user/admin");
        }else {
            //登录失败
            forwardError(request,response,"邮箱或密码错误");
        }
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
}
