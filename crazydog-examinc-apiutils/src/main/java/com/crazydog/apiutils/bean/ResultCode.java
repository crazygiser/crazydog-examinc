package com.crazydog.apiutils.bean;

/**
 * 具体的消息码和消息
 */
public enum ResultCode {
    /**
     * 公共部分
     */
    ADD_KEY_REPEATS(0, "信息重复（名称重复）"),
    ADD_KEY_PROJECTS(0, "项目名称已存在"),
    SYSTEM_UNKNOW_EXCEPTION(0, "系统异常"),
    QUERY_FAIL(0, "查询失败"),
    QUERY_NO_DATA(0, "未查询到数据"),
    PARAMETER_ERROR(0, "参数错误"),
    ADD_SUCCESS(1, "成功新增信息"),
    UPDATE_SUCCESS(1, "成功更新信息"),
    CHECK_SUCCESS(1, "审核成功"),
    ADD_FAIL(0, "添加失败"),
    CHECK_FAIL(0, "审核失败"),
    PARAMETER_NOT_EXIST(0, "参数不能为空"),
    DELETE_FAIL(0, "删除失败"),
    UPDATE_FAIL(0, "更新失败"),
    NAME_EXIT(0, "名称存在"),
    ID_CODE(0, "身份证号已存在"),
    ID_CODE_ERROR(0, "身份证号格式有误"),

    /**
     * 登录认证模块
     */
    SUCCESS(1, "登录成功"),
    QUERY_SUCCESS(1, "查询成功"),
    START_OFF_SUCCESS(1, "启用禁用成功"),
    DELETE_SUCCESS(1, "删除成功"),
    START_SUCCESS(1, "启用成功"),
    DISABLED_SUCCESS(1, "禁用成功"),
    FAIL(0, "请求失败"),
    SYSTEM_EXCEPTION(0, "系统登录异常"),
    TOKEN_EXCEPTION(2, "验证用户失败，请重新登录"),
    NOT_LOGIN_EXCEPTION(2, "用户未登录，请登录用户"),
    USER_NOT_FOUND(0, "用户不存在"),
    CAPTCHA(0, "验证码错误"),
    USERNAME_NOT_BLANK(0, "用户名不能为空"),
    USERNAME_EXIST(0, "用户名已经存在"),
    USERTYPE_ERROR_WQY(0, "用户已禁用"),
    USERNAME_PHONE_ERROR(0, "用户名或手机号错误"),
    USERNAME_PASSWORD_EXCEPTION(0, "密码错误"),
    USERNAME_PASSWORD_RULE(0, "用户密码不符合规则，请确认后重新输入"),
    USERNAME_EXPIRATIONTIME(0, "账号已过期，无法登录"),
    USER_ROLE_NOT_FOUND(0, "用户尚未分配角色权限，请联系管理员进行角色权限分配"),
    ROLE_NOT_FOUND(0, "单位角色不存在，请联系管理员进行角色权限分配"),
    ADD_LOG_FAIL(0, "登录日志信息保存失败,请联系管理员进行解决"),
    USERNAME_NOT_CODE(0, "注册用户名必须为统一社会信用代码"),
    USERNAME_TYPES_NOT_BLANK(0, "用户名或用户类型或验证码不能为空"),

    /**
     * 招投标模块
     */
    DELETE_INVITE_SUCCESS(1, "撤销发布成功"),
    DELETE_INVITE_FAIL(0, "撤销发布失败"),
    PUBLISH_INVITE_SUCCESS(1, "发布成功"),
    PUBLISH_INVITE_FAIL(0, "发布失败"),

    /**
     * 企业业绩模块
     */
    ACHIEVEMENT_EXIST(0, "相同的企业业绩已经存在"),
    COMPANY_UNT_EXIST(0, "企业名称不存在"),
    PASSWORD_EMPTY(0, "密码为空"),
    AUTH_UNKNOWN(0, "注销失败"),
    AUTH_SUCCESS(1, "注销成功"),
    AUTH_PARAMETER_ERROR(0, "用户名或密码为空"),
    MODIFY_SUCCESS(1, "修改成功"),
    MODIFY_FAIL(0, "修改失败"),
    PARAMETER_EXISTING(0, "参数已经存在"),
    MESSAGE_CODE_ERROR(0, "短信验证码不正确"),
    MESSAGE_USERNAME_PHONE_NOT_BLANK(0, "用户名和手机号不能为空"),
    MESSAGE_PHONE_ERROR(0, "该用户未绑定手机号，请联系管理员绑定"),
    MESSAGE_USERNAME_PHONE_ERROR(0, "用户名与手机号不匹配"),
    MESSAGE_HAS_MONTHLY_REPORT_ERROR(0, "添加失败，该月报时间的进展已填报，不能重复添加"),

    NORM_TYPE_RNAME_EXIST(0, "指标版本已经存在"),
    NORM_EDITION_NOT_EXIST(0, "指标版本不存在"),

    EVALUATE_CYCLE_EXIST(0, "信用评价周期已经存在"),
    EVALUATE_CYCLE_NOT_EXIST(0, "信用评价周期不存在"),

    USERNAME_PASSWORD_ENABLE(0, "密码连续出现五次错误，已锁定账号，请联系管理员启用账号"),
    REQUEST_TIMEOUT(0, "请求超时"),

    BULIDNAME_EXIST(0, "建设单位名称已经存在");


    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
