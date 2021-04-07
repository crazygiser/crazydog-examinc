package com.crazydog.apiutils.utils;

import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description: 密码验证
 * @author: cc
 * @since: 2021-02-23 17:38:15
 */
@Data
public class CheckPassword {
    // 包含大写字母
    private static boolean upperCase = false;
    // 包含小写字母
    private static boolean lowerCase = false;
    // 包含字母
    private static boolean letter = true;
    // 包含数字
    private static boolean digit = true;
    // 包含特殊字符
    private static boolean special = true;
    // 特殊字符集合
    private static Set<Character> specialCharSet = null;
    // 最小长度
    private static int minLength = 8;
    // 最大长度
    private static int maxLength = 16;

    /**
     * 密码符合规则，返回true
     */
    public static boolean check(String password) {
        // 8-16位字符组成,必须需要包括字母数字和特殊符号
        if (password == null || password.length() < minLength || password.length() > maxLength) {
            // 长度不符合
            return false;
        }

        specialCharSet = defaultSpecialCharSet();

        boolean containUpperCase = false;
        boolean containLowerCase = false;
        boolean containLetter = false;
        boolean containDigit = false;
        boolean containSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                containUpperCase = true;
                containLetter = true;
            } else if (Character.isLowerCase(ch)) {
                containLowerCase = true;
                containLetter = true;
            } else if (Character.isDigit(ch)) {
                containDigit = true;
            } else if (specialCharSet.contains(ch)) {
                containSpecial = true;
            } else {
                // 非法字符
                return false;
            }
        }

        if (upperCase && !containUpperCase) {
            return false;
        }
        if (lowerCase && !containLowerCase) {
            return false;
        }
        if (letter && !containLetter) {
            return false;
        }
        if (digit && !containDigit) {
            return false;
        }
        if (special && !containSpecial) {
            return false;
        }
        return true;
    }

    public static Set<Character> defaultSpecialCharSet() {
        Set<Character> specialChars = new LinkedHashSet<>();
        // 键盘上能找到的符号
        specialChars.add(Character.valueOf('~'));
        specialChars.add(Character.valueOf('`'));
        specialChars.add(Character.valueOf('!'));
        specialChars.add(Character.valueOf('@'));
        specialChars.add(Character.valueOf('#'));
        specialChars.add(Character.valueOf('$'));
        specialChars.add(Character.valueOf('%'));
        specialChars.add(Character.valueOf('^'));
        specialChars.add(Character.valueOf('&'));
        specialChars.add(Character.valueOf('*'));
        specialChars.add(Character.valueOf('('));
        specialChars.add(Character.valueOf(')'));
        specialChars.add(Character.valueOf('-'));
        specialChars.add(Character.valueOf('_'));
        specialChars.add(Character.valueOf('+'));
        specialChars.add(Character.valueOf('='));
        specialChars.add(Character.valueOf('{'));
        specialChars.add(Character.valueOf('['));
        specialChars.add(Character.valueOf('}'));
        specialChars.add(Character.valueOf(']'));
        specialChars.add(Character.valueOf('|'));
        specialChars.add(Character.valueOf('\\'));
        specialChars.add(Character.valueOf(':'));
        specialChars.add(Character.valueOf(';'));
        specialChars.add(Character.valueOf('"'));
        specialChars.add(Character.valueOf('\''));
        specialChars.add(Character.valueOf('<'));
        specialChars.add(Character.valueOf(','));
        specialChars.add(Character.valueOf('>'));
        specialChars.add(Character.valueOf('.'));
        specialChars.add(Character.valueOf('?'));
        specialChars.add(Character.valueOf('/'));
        return specialChars;
    }
}
