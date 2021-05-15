package com.haitunhv.jk.pojo.po;

import com.haitunhv.jk.common.foreign.anno.ForeignField;
import lombok.Data;

@Data
public class SysUserRole {
    /**
     * 角色id
     */
    @ForeignField(SysRole.class)
    private Short roleId;
    /**
     * 用户id
     */
    @ForeignField(SysUser.class)
    private Integer userId;
}