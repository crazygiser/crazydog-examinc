package com.crazydog.apiutils.utils;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @description: 组织机构代码/统一社会信用代码校验工具类
 * @author: cc
 * @since: 2020-11-05 15:43:04
 * 1.isUniformSocialCreditCode方法用于判断统一社会信用代码是否有效
 * 2.isOrganizationCertificate方法用于判断组织机构代码是否有效
 */
public class RegexUtil {

    private static final String BASE_CODE_STRING = "0123456789ABCDEFGHJKLMNPQRTUWXY";
    private static final char[] BASE_CODE_ARRAY = BASE_CODE_STRING.toCharArray();
    private static final List<Character> BASE_CODES = new ArrayList<Character>();
    private static final String BASE_CODE_REGEX = "[" + BASE_CODE_STRING + "]{18}";
    private static final int[] WEIGHT = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};

    static {
        for (char c : BASE_CODE_ARRAY) {
            BASE_CODES.add(c);
        }
    }

    /**
     * 加权因子
     */
    private static int power[] = {3, 7, 9, 10, 5, 8, 4, 2};


    /**
     * 判断统一社会信用代码是否有效
     *
     * @param socialCreditCode
     * @return
     */
    public static boolean isUniformSocialCreditCode(String socialCreditCode) {
        if (StringUtils.isBlank(socialCreditCode) || !Pattern.matches(BASE_CODE_REGEX, socialCreditCode)) {
            return false;
        }
        char[] businessCodeArray = socialCreditCode.toCharArray();
        char check = businessCodeArray[17];
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            char key = businessCodeArray[i];
            sum += (BASE_CODES.indexOf(key) * WEIGHT[i]);
        }
        int value = 31 - sum % 31;
        return check == BASE_CODE_ARRAY[value % 31];
    }

    /**
     * 判断组织机构代码是否有效
     *
     * @param organizationCertificate
     * @return
     */
    public static boolean isOrganizationCertificate(String organizationCertificate) {
        String temp = organizationCertificate.toUpperCase();
        if (temp.contains("-")) {
            temp = temp.replace("-", "");
        }
        if (temp.length() != 9) {
            return false;
        }
        // 获取前面8位
        String pre8 = temp.substring(0, 8);
        char[] pre8chars = pre8.toCharArray();// 0~z;
        // 获取校验码
        String code = temp.substring(8, 9);
        boolean isCode = isCode(code, sum(pre8chars));
        return isCode;
    }

    /**
     * 求和
     *
     * @param bit
     * @return
     */
    private static int sum(char[] bit) {
        int sum = 0;
        for (int i = 0; i < bit.length; i++) {
            int intTemp = bit[i] > '9' ? (bit[i] - 'A' + 10) : Integer.parseInt(bit[i] + "");
            System.out.print(" " + intTemp);
            sum += intTemp * power[i];
        }
        return sum;
    }

    /**
     * 判断机构代码的校验码和计算出的校验码是否一致
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean isCode(String a, int b) {
        String codeTEmp = (11 - b % 11) == 10 ? "X" : (11 - b % 11) == 11 ? 0 + "" : (11 - b % 11) + "";
        return a.equals(codeTEmp);
    }

}
