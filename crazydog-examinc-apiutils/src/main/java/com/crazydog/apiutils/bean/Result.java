package com.crazydog.apiutils.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 前后台交互信息
 * 设置消息码以及消息文本还有消息数据
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "返回的提示信息", hidden = false)
    private String message;

    @ApiModelProperty(value = "信息对应状态码", hidden = false)
    private Integer code;

    @ApiModelProperty(value = "返回的数据", hidden = false)
    private T data;
}
