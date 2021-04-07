package com.crazydog.examinc.system.bean.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(description = "用户列表信息查询请求参数")
public class UserListRequest implements Serializable {

    @ApiModelProperty(value = "用户名", position = 1)
    private String upcode;

    @ApiModelProperty(value = "分页数", position = 2)
    private int limit;

    @ApiModelProperty(value = "当前页", position = 3)
    private int current;
}
