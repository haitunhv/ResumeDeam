package com.haitunhv.xr.until;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
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
}
