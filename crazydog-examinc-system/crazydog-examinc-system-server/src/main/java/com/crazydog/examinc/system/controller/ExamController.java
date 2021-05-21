package com.crazydog.examinc.system.controller;

import com.crazydog.apiutils.bean.Result;
import com.crazydog.apiutils.bean.ResultCode;
import com.crazydog.apiutils.utils.ResultUtils;
import com.crazydog.examinc.system.bean.user.*;
import com.crazydog.examinc.system.config.DataSourceConstants;
import com.crazydog.examinc.system.config.DbAnnotation;
import com.crazydog.examinc.system.service.ExamService;
import com.crazydog.examinc.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/exam")
@Slf4j
@Api(value = "考试统计业务", description = "考试统计业务")
public class ExamController {

    @Autowired
    private ExamService examCjtj;


    @ApiOperation("考试成绩信息统计")
    @RequestMapping(value = "/examCjtj", method = RequestMethod.POST, produces = "application/json")
    public Result<TbExamKstj> examCjtj(@RequestBody ExamRequest request) {
        try {
            return examCjtj.examCjtj(request);
        } catch (Exception e) {
            log.error("查询异常:{}", e.getMessage(), e);
        }
        return ResultUtils.error(ResultCode.QUERY_FAIL);
    }

}
