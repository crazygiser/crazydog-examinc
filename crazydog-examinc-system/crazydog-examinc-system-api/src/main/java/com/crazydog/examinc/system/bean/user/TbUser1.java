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
public class TbUser1 implements Serializable {

    @ApiModelProperty(value = "用户ID", position = 1)
    private String user_id;

    @ApiModelProperty(value = "部门id", position = 2)
    private String dept_id;

    @ApiModelProperty(value = "用户名称", position = 3)
    private String user_name;

    @ApiModelProperty(value = "角色名称", position = 4)
    private String nick_name;


}

