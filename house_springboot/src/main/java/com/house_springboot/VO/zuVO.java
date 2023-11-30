package com.house_springboot.VO;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("zuVO")
public class zuVO {
        @ApiModelProperty(value = "zid", example = "3")
        private Integer zid;
        @ApiModelProperty(value = "name", example = "3333")
        private String name;
        @ApiModelProperty(value = "idcard", example = "3333")
        private String idcard;
        @ApiModelProperty(value = "phone", example = "3333")
        private String phone;
        @ApiModelProperty(value = "houseid", example = "3333")
        private String houseid;
        @ApiModelProperty(value = "address", example = "3333")
        private String address;
        @ApiModelProperty(value = "status", example = "3333")
        private String status;
}
