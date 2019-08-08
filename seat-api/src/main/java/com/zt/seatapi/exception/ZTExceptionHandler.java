package com.zt.seatapi.exception;

import com.zt.seatcommon.exception.ZTException;
import com.zt.seatcommon.result.Result;
import com.zt.seatcommon.result.ResultEnum;
import com.zt.seatcommon.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ZTExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(ZTException.class)
    public Result handleRRException(ResultEnum resultEnum,ZTException e){
        logger.error(e.getMessage(), e);
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(e);
        return result;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e,ResultEnum resultEnum){
        logger.error(e.getMessage(), e);
        return ResultUtil.error(resultEnum);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e,ResultEnum resultEnum){
        logger.error(e.getMessage(), e);
        return ResultUtil.error(resultEnum);
    }
}
