package com.haitunhv.jk.pojo.po;

import com.haitunhv.jk.common.foreign.anno.ForeignField;
import lombok.Data;

@Data
public class PlateRegion {

    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 车牌
     */
    private String plate;
    /**
     * 拼音
     */
    private String pinyin;
    @ForeignField(PlateRegion.class)
    private Integer parentId;
}