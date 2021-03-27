package com.haitunhv.xr.bean.base;

import org.apache.commons.fileupload.FileItem;

import java.util.Map;

/**
 * @Author: haitunhv
 * @Date: 2021/3/7 21:03
 */
public class UploadParams {
    private Map<String,Object> params;
    private Map<String, FileItem> fileParams;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, FileItem> getFileParams() {
        return fileParams;
    }

    public void setFileParams(Map<String, FileItem> fileParams) {
        this.fileParams = fileParams;
    }
}
