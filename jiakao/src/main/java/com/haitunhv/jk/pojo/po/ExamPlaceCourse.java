package com.haitunhv.jk.pojo.po;

import com.haitunhv.jk.common.foreign.anno.ForeignField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExamPlaceCourse {
    /**
     * 主键
     */
    private Integer id;

    private Date createTime;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 课程类型：0是课程合集，2是科目2，3是科目3
     */
    private Short type;

    private String intro;
    /**
     * 视频
     */
    private String video;
    /**
     * 封面
     */
    private String cover;
    /**
     * 考场
     */
    @ForeignField(ExamPlace.class)
    private Integer placeId;
}