package com.crazydog.examinc.system.config;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(dbAnnotation)")
    public void changeDataSource(JoinPoint point, DbAnnotation dbAnnotation) throws Throwable {
        String dsId = dbAnnotation.value();
//        if (!DynamicDataSourceContextHolder.containDataSourceKey(dsId)) {
//            System.out.println("数据源(" + dsId + ")不存在-" + point.getSignature());
//        } else {
//            DynamicDataSourceContextHolder.setDataSourceKey(dbAnnotation.value());
//            System.out.println("使用数据源(" + dsId + ")-" + point.getSignature());
//        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbAnnotation.value());
        System.out.println("使用数据源(" + dsId + ")-" + point.getSignature());
    }

    @After("@annotation(dbAnnotation)")
    public void restoreDataSource(JoinPoint point, DbAnnotation dbAnnotation) {
        System.out.println("恢复数据源-" + point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }
}
