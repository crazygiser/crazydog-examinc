package com.crazydog.examinc.system.mapper;

import com.crazydog.examinc.system.bean.user.TbUser;
import com.crazydog.examinc.system.bean.user.TbUser1;
import com.crazydog.examinc.system.bean.user.UserListRequest;
import com.crazydog.examinc.system.config.DataSourceConstants;
import com.crazydog.examinc.system.config.DbAnnotation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:
* @author: cc
* @since: 2021-04-07 16:18:29
*/
@Mapper
public interface UserMapper {
    /**
     * 根据用户ID查询用户信息
     *
     * @param upcode
     * @return
     */
    TbUser queryUserByUserId(@Param("upcode") String upcode);

    /**
     * 根据用户ID查询用户信息
     *
     * @param user_id
     * @return
     */

    TbUser1 queryUserByUserId1(@Param("user_id") String user_id);


    /**
     * 查询用户列表信息
     *
     * @param userListRequest
     * @return
     */
    List<TbUser> queryUserList(UserListRequest userListRequest);

    /**
     * 查询用户列表信息个数
     *
     * @param userListRequest
     * @return
     */
    int queryUserListCount(UserListRequest userListRequest);


}
