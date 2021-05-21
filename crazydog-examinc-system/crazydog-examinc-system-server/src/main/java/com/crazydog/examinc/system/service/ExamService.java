package com.crazydog.examinc.system.service;

import com.crazydog.apiutils.bean.Result;
import com.crazydog.examinc.system.bean.user.ExamRequest;
import com.crazydog.examinc.system.bean.user.TbExamKstj;

public interface ExamService {

    /**
     * 考试成绩统计
     *
     * @param request
     * @return
     */
    Result<TbExamKstj> examCjtj(ExamRequest request);

}
