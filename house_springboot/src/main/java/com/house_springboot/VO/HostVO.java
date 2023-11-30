package com.house_springboot.VO;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
@Data
@ApiOperation("Houselist")
public class HostVO {
        @ApiModelProperty(value = "id", example = "3")
        private Integer id;
        @ApiModelProperty(value = "houseid", example = "3333")
        private String houseid;
        @ApiModelProperty(value = "address", example = "3333")
        private String address;
        @ApiModelProperty(value = "area", example = "3")
        private double area;
        @ApiModelProperty(value = "price", example = "3")
        private double price;
        @ApiModelProperty(value = "status", example = "3333")
        private String status;
}
