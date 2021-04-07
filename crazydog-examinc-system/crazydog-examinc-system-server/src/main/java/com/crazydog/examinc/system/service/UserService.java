package com.crazydog.examinc.system.service;


import com.crazydog.apiutils.bean.Result;
import com.crazydog.examinc.system.bean.user.TbUser;
import com.crazydog.examinc.system.bean.user.TbUser1;
import com.crazydog.examinc.system.bean.user.UserListRequest;
import com.crazydog.examinc.system.config.DataSourceConstants;
import com.crazydog.examinc.system.config.DbAnnotation;

/**
 * @description: 用户接口层
 * @author: cc
 * @since: 2020-08-19 14:01:18
 */
public interface UserService {


    /**
     * 根据用户id获取用户基本信息
     *
     * @param id
     * @return
     */
    TbUser queryUserInfoById(String id);

    /**
     * 根据用户id获取用户基本信息
     *
     * @param user_id
     * @return
     */
    TbUser1 queryUserInfoById1(String user_id);

    /**
     * 查询用户列表
     *
     * @param userListRequest
     * @return
     */
    Result<TbUser> queryUserList(UserListRequest userListRequest);

}
