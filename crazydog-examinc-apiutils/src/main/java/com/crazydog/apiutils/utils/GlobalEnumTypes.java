package com.crazydog.apiutils.utils;

/**
 * @description: 枚举值
 * @author: cc
 * @since: 2020-09-17 11:18:42
 */
public enum GlobalEnumTypes {
    /**
     * 评价状态
     */
    CREDIT_TYPES_2701(2701, "自评中"),
    CREDIT_TYPES_2702(2702, "待建设单位评价"),
    CREDIT_TYPES_2703(2703, "待盟市评价"),
    CREDIT_TYPES_2704(2704, "待厅评价"),
    CREDIT_TYPES_2705(2705, "完成评价未公示"),
    CREDIT_TYPES_2706(2706, "已公示"),
    CREDIT_TYPES_2707(2707, "已上报"),


    /**
     * 评价流程状态
     */
    CREDIT_PROCESS_4301(4301, "未评价"),
    CREDIT_PROCESS_4302(4302, "未报盟市"),
    CREDIT_PROCESS_4303(4303, "未报厅"),
    CREDIT_PROCESS_4304(4304, "已报盟市"),
    CREDIT_PROCESS_4305(4305, "已报厅"),
    CREDIT_PROCESS_4306(4306, "退回建设单位"),
    CREDIT_PROCESS_4307(4307, "退回盟市"),
    CREDIT_PROCESS_4308(4308, "已完成"),
    CREDIT_PROCESS_4309(4309, "已评价"),
    CREDIT_PROCESS_4310(4310, "盟市审核通过"),
    CREDIT_PROCESS_4311(4311, "厅审核通过"),


    /**
     * 评价指标申诉状态
     */
    CREDIT_APPEAL_2401(2401, "未申诉"),
    CREDIT_APPEAL_2402(2402, "已申诉"),
    CREDIT_APPEAL_2403(2403, "未审核"),
    CREDIT_APPEAL_2404(2404, "未通过"),
    CREDIT_APPEAL_2405(2405, "已通过"),

    /**
     * 企业类型
     */
    CORP_TYPES_0511(0511, "公路施工单位"),
    CORP_TYPES_0512(0512, "公路监理单位"),
    CORP_TYPES_0513(0513, "公路勘察设计单位"),
    CORP_TYPES_0514(0514, "公路试验检测单位"),
    CORP_TYPES_0515(0515, "工地试验室"),
    CORP_TYPES_0516(0516, "建设单位");


    private int code;
    private String message;

    GlobalEnumTypes(int code, String message) {
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
