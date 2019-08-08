package com.zt.seatapi.controller;


import com.zt.seatapi.common.result.TestResult;
import com.zt.seatapi.service.TestServiceI;
import com.zt.seatcommon.result.Result;
import com.zt.seatcommon.result.ResultEnum;
import com.zt.seatcommon.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestServiceI testServiceI;

    @GetMapping("/test")
    public Result test(Integer id){
        if (null == id)
            return ResultUtil.fail(ResultEnum.FAIL_MISSING_PARAMETER);
        TestResult result = testServiceI.get(id);
        return ResultUtil.success(result);
    }
}
