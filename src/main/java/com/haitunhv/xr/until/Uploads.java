package com.haitunhv.xr.until;

import com.haitunhv.xr.bean.base.UploadParams;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: haitunhv
 * @Date: 2021/3/3 22:18
 */
public class Uploads {
    private static final String BASE_DIR = "upload";
    private static final String IMG_DIR = "img";

    /**
     * 图片上传
     * @param item 图片参数
     * @param request 请求
     * @return 图片路径
     * @throws Exception
     */
    public static String uploadImg(FileItem item, HttpServletRequest request,String oldImage) throws Exception{
        //空字符串存null
        if (oldImage != null && oldImage.length() == 0){
            oldImage = null;
        }


        if(item == null) return oldImage;
        InputStream is = item.getInputStream();
        if (is.available() == 0) return oldImage;

        ServletContext ctx = request.getServletContext();
        //图片在硬盘上的存放路径
        String filename = UUID.randomUUID()+"."+ FilenameUtils.getExtension(item.getName());
        String imageUrl = BASE_DIR+ "/"+ IMG_DIR+"/"+filename;
        String filepath = ctx.getRealPath(imageUrl);
        FileUtils.copyInputStreamToFile(item.getInputStream(),new File(filepath));
        // 删除旧的文件
        if (oldImage != null) {
            // 如果oldImage是空串，那么就会把整个web项目的文件夹给删掉
            FileUtils.deleteQuietly(new File(ctx.getRealPath(oldImage)));
        }
        return imageUrl;


    }

    /**
     * 文件上传参数
     * @param request
     * @return
     * @throws Exception
     */
    public static UploadParams parseUploadRequest(HttpServletRequest request) throws Exception{
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
        UploadParams uploadParams = new UploadParams();
        uploadParams.setFileParams(fileParam);
        uploadParams.setParams(params);
        return uploadParams;
    }
}
