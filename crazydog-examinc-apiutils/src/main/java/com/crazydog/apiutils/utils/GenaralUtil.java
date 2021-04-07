package com.crazydog.apiutils.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 一些常用的转换函数等
 */
public class GenaralUtil {


    /**
     * 排序 生成参数字符串
     *
     * @param params
     * @return 模式为key=value&key=value
     */
    public static String generateParamStrByMap(Map<String, String> params) {
        // 塞入列表
        List<String> paramList = new ArrayList<String>();
        for (String key : params.keySet()) {
            String val = params.get(key);
            paramList.add(key + "=" + val);
        }
        // 防护
        if (paramList.size() == 0) {
            return null;
        }
        // 对列表进行排序
        Collections.sort(paramList);
        // 以&符分割拼装成字符串
        StringBuilder sb = new StringBuilder();
        sb.append(paramList.get(0));
        for (int i = 1; i < paramList.size(); i++) {
            sb.append("&").append(paramList.get(i));
        }
        return sb.toString();
    }
}
