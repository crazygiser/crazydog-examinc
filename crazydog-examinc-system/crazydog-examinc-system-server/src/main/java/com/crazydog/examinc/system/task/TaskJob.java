package com.crazydog.examinc.system.task;

import com.crazydog.apiutils.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskJob {

    /**
     * 按照标准时间来算，每隔 10s 执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        log.info("【job1】开始执行：{}", DateUtil.getTodayDateTime());
        System.out.println("【job1】开始执行：{" + DateUtil.getTodayDateTime() + "}");
    }

    /**
     * 从启动时间开始，间隔 15s 执行
     * 固定间隔时间
     */
    @Scheduled(fixedRate = 15000)
    public void job2() {
        log.info("【job2】开始执行：{}", DateUtil.getTodayDateTime());
        System.out.println("【job2】开始执行：{" + DateUtil.getTodayDateTime() + "}");
    }

    /**
     * 从启动时间开始，延迟 5s 后间隔 10s 执行
     * 固定等待时间
     */
    @Scheduled(fixedDelay = 10000, initialDelay = 5000)
    public void job3() {
        log.info("【job3】开始执行：{}", DateUtil.getTodayDateTime());
        System.out.println("【job3】开始执行：{" + DateUtil.getTodayDateTime() + "}");
    }
}
