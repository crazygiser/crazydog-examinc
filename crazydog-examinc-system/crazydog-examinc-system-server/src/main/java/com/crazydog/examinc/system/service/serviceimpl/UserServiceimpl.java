package com.crazydog.examinc.system.service.serviceimpl;


import com.crazydog.apiutils.bean.Result;
import com.crazydog.apiutils.bean.ResultCode;
import com.crazydog.apiutils.utils.ResultUtils;
import com.crazydog.examinc.system.bean.user.TbUser;
import com.crazydog.examinc.system.bean.user.TbUser1;
import com.crazydog.examinc.system.bean.user.UserListRequest;
import com.crazydog.examinc.system.mapper.UserMapper;
import com.crazydog.examinc.system.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.*;

/**
* @description: 实现层
* @author: cc
* @since: 2021-04-07 16:18:08
*/
@Service
@Transactional
@Slf4j
public class UserServiceimpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public TbUser queryUserInfoById(String id) {
        return userMapper.queryUserByUserId(id);
    }

    @Override
    public TbUser1 queryUserInfoById1(String user_id) {
        return userMapper.queryUserByUserId1(user_id);
    }

    @Override
    public Result<TbUser> queryUserList(UserListRequest userListRequest) {
        if (userListRequest != null) {
            Map<String, Object> map = new HashMap<>();
            List<TbUser> userList = userMapper.queryUserList(userListRequest);
            int total = userMapper.queryUserListCount(userListRequest);
            map.put("userList", userList);
            map.put("total", total);
            return ResultUtils.success(ResultCode.QUERY_SUCCESS, map);
        }
        return ResultUtils.error(ResultCode.QUERY_NO_DATA);
    }

}
