package com.crazydog.apiutils.poi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 报表属性的注解
 * @author: cc
 * @since: 2021-01-27 09:58:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAttribute {
    /**
     * 对应的列名称
     *
     * @return
     */
    String name() default "";

    /**
     * 列序号
     *
     * @return
     */
    int sort();

    /**
     * 字段类型对应的格式
     *
     * @return
     */
    String format() default "";

}
