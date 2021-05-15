package com.haitunhv.jk.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("考场")
public class ExamPlaceVo {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    @ApiModelProperty("经度")
    private BigDecimal longitude;
}