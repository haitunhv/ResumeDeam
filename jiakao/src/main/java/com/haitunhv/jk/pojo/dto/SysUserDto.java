package com.haitunhv.jk.pojo.dto;

import com.haitunhv.jk.pojo.po.SysResource;
import com.haitunhv.jk.pojo.po.SysRole;
import com.haitunhv.jk.pojo.po.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class SysUserDto {
    private SysUser user;
    private List<SysRole> roles;
    private List<SysResource> resources;
}
