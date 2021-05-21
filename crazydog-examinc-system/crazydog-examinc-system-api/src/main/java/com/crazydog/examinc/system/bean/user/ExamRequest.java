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
@ApiModel(description = "考试成绩统计")
public class ExamRequest implements Serializable {

    @ApiModelProperty(value = "开始时间", position = 1)
    private String starttime;

    @ApiModelProperty(value = "结束时间", position = 2)
    private String endtime;

}
