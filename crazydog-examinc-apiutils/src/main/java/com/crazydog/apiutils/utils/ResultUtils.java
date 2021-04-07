package com.crazydog.apiutils.utils;

import com.crazydog.apiutils.bean.Result;
import com.crazydog.apiutils.bean.ResultCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 常用响应返回结构方法工具类
 */
@SuppressWarnings("unchecked")
public class ResultUtils {
    public static Result success(ResultCode resultCode, Map<String, Object> map) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setData(map);

        return result;
    }

    public static Result error(ResultCode resultCode, Map<String, Object> map) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setData(map);

        return result;
    }

    public static Result success(ResultCode resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    public static Result error(ResultCode resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());

        return result;
    }

    public static Map errorMap(ResultCode resultEnum) {
        Map map = new HashMap();
        map.put("code", resultEnum.getCode());
        map.put("Message", resultEnum.getMessage());
        return map;
    }
}
