package com.crazydog.apiutils.bean;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @description: 缓存信息
 * @author: cc
 * @since: 2020-09-28 15:02:26
 */
public abstract class BaseCatchs {
    /**
     * 当前账号常量
     */
    public static final String USERID = "userid";

    public static final String LOGID = "logid";

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static String getUserid() {
        HttpSession session = getRequest().getSession();
        return (String) session.getAttribute(USERID);
    }

    public static void setAccount(String userid) {
        HttpSession session = getRequest().getSession();
        if (StringUtils.isNotBlank(userid)) {
            session.setAttribute(USERID, userid);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }

    public static String getLogid() {
        HttpSession session = getRequest().getSession();
        return (String) session.getAttribute(LOGID);
    }

    public static void setLogid(String logid) {
        HttpSession session = getRequest().getSession();
        if (StringUtils.isNotBlank(logid)) {
            session.setAttribute(LOGID, logid);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }
}
