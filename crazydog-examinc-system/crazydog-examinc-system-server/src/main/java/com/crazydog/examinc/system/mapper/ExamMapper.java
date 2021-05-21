package com.crazydog.examinc.system.mapper;

import com.crazydog.examinc.system.bean.user.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ExamMapper {

    /**
     * 考试成绩统计
     *
     * @param request
     * @return
     */
    List<TbExamKstj> examCjtj(ExamRequest request);

}
