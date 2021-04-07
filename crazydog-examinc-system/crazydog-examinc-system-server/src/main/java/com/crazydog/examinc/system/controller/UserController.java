package com.crazydog.examinc.system.controller;

import com.crazydog.apiutils.bean.Result;
import com.crazydog.apiutils.bean.ResultCode;
import com.crazydog.apiutils.utils.ResultUtils;
import com.crazydog.examinc.system.bean.user.TbUser;
import com.crazydog.examinc.system.bean.user.TbUser1;
import com.crazydog.examinc.system.bean.user.UserListRequest;
import com.crazydog.examinc.system.config.DataSourceConstants;
import com.crazydog.examinc.system.config.DbAnnotation;
import com.crazydog.examinc.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Slf4j
@Api(value = "用户服务", description = "用户服务")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据用户id获取用户基本信息", httpMethod = "GET", produces = "application/json", notes = "获取用户基本信息")
    @RequestMapping(value = "/queryUserInfoById", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "String", required = true, value = "用户id")
    @DbAnnotation(DataSourceConstants.DS_KEY_MASTER)
    public TbUser queryUserInfoById(@RequestParam(name = "id") String id) {
        TbUser result = userService.queryUserInfoById(id);
        return result;
    }

    @ApiOperation(value = "根据用户id获取用户基本信息1", httpMethod = "GET", produces = "application/json", notes = "获取用户基本信息")
    @RequestMapping(value = "/queryUserInfoById1", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "String", required = true, value = "用户id")
    @DbAnnotation(DataSourceConstants.DS_KEY_SLAVE)
    public TbUser1 queryUserInfoById1(@RequestParam(name = "user_id") String user_id) {
        TbUser1 result = userService.queryUserInfoById1(user_id);
        return result;
    }


    @ApiOperation("查询用户列表")
    @RequestMapping(value = "/queryUserList", method = RequestMethod.POST, produces = "application/json")
    public Result<TbUser> queryUserList(@RequestBody UserListRequest userListRequest) {
        try {
            return userService.queryUserList(userListRequest);
        } catch (Exception e) {
            log.error("查询异常:{}", e.getMessage(), e);
        }
        return ResultUtils.error(ResultCode.QUERY_FAIL);
    }

}
