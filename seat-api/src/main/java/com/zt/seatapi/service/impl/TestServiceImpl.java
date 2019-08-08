package com.zt.seatapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zt.seatapi.common.result.TestResult;
import com.zt.seatapi.dao.TestMapper;
import com.zt.seatapi.service.TestServiceI;
import com.zt.seatcommon.component.RedisComponent;
import com.zt.seatcommon.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestServiceI {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private RedisComponent redisComponent;

    @Override
    public TestResult get(Integer id) {
        TestResult result = testMapper.get(id);
        redisComponent.saveDataWithTime("test", JSON.toJSONString(result), Constant.userInfoInRedisTime);
        return result;
    }
}
