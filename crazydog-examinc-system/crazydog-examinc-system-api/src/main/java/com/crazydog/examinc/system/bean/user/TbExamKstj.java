package com.crazydog.examinc.system.bean.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TbExamKstj implements Serializable {

    @ApiModelProperty(value = "受理区县", position = 1)
    private String bmdd;

    @ApiModelProperty(value = "理论科目正考约考人数", position = 2)
    private String llkmzkykrs;

    @ApiModelProperty(value = "理论科目正考实考人数", position = 3)
    private String llkmhgrs;

    @ApiModelProperty(value = "理论合格率", position = 4)
    private String llhgl;

    @ApiModelProperty(value = "理论科目78至79人数", position = 5)
    private String ll7879;

    @ApiModelProperty(value = "应用能力正考约考人数", position = 6)
    private String yynlzkykrs;

    @ApiModelProperty(value = "应用能力正考实考人数", position = 7)
    private String yynlzskrs;

    @ApiModelProperty(value = "应用能力合格人数", position = 8)
    private String yynlhgrs;

    @ApiModelProperty(value = "应用合格率", position = 9)
    private String yyhgl;

    @ApiModelProperty(value = "应用科目78至79人数", position = 10)
    private String yynl7879;

    @ApiModelProperty(value = "约考人数", position = 11)
    private String ykrs;

    @ApiModelProperty(value = "考试人数", position = 12)
    private String ksrs;

    @ApiModelProperty(value = "通过人数", position = 13)
    private String tgrs;

    @ApiModelProperty(value = "报名人数", position = 14)
    private String bmrs;

    @ApiModelProperty(value = "约正考人数", position = 15)
    private String yzkrs;

    @ApiModelProperty(value = "理论补考人数", position = 16)
    private String llbkrs;

    @ApiModelProperty(value = "实操补考人数", position = 17)
    private String scbkrs;

    @ApiModelProperty(value = "补考人数", position = 18)
    private String bkrs;

    @ApiModelProperty(value = "补考合格人数", position = 19)
    private String bkhgrs;

    @ApiModelProperty(value = "补考不合格人数", position = 20)
    private String bkbhgrs;
}

