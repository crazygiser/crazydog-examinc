package com.crazydog.examinc.system.bean.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel("用户列表信息查询响应参数")
public class UserListResponse implements Serializable {

    @ApiModelProperty(value = "用户编码", position = 1)
    private String ucode;

    @ApiModelProperty(value = "用户名称", position = 2)
    private String upcode;

    @ApiModelProperty(value = "登录密码", position = 3)
    private String upwd;

    @ApiModelProperty(value = "用户真实姓名", position = 4)
    private String uname;

    @ApiModelProperty(value = "身份证", position = 5)
    private String idcard;

    @ApiModelProperty(value = "联系电话", position = 6)
    private String utel;
}
