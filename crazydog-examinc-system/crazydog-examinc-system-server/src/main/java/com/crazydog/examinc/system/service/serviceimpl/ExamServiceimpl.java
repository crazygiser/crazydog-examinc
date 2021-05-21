package com.crazydog.examinc.system.service.serviceimpl;

import com.crazydog.apiutils.bean.Result;
import com.crazydog.apiutils.bean.ResultCode;
import com.crazydog.apiutils.utils.ResultUtils;
import com.crazydog.examinc.system.bean.user.ExamRequest;
import com.crazydog.examinc.system.bean.user.TbExamKstj;
import com.crazydog.examinc.system.bean.user.TbUser;
import com.crazydog.examinc.system.mapper.ExamMapper;
import com.crazydog.examinc.system.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class ExamServiceimpl implements ExamService {

    @Resource
    private ExamMapper examMapper;

    @Override
    public Result<TbExamKstj> examCjtj(ExamRequest request) {
        if (request != null) {
            Map<String, Object> map = new HashMap<>();
            List<TbExamKstj> userList = examMapper.examCjtj(request);
            map.put("exam", userList);
            return ResultUtils.success(ResultCode.QUERY_SUCCESS, map);
        }
        return ResultUtils.error(ResultCode.QUERY_NO_DATA);
    }
}
