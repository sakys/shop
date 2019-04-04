package com.shop.exception;

import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import com.shop.constant.Constant;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException extends BaseController {

    @ExceptionHandler(value = ParamException.class)
    public ResultInfo handlerParamException(ParamException paramException) {
        String message = paramException.getMessage();
        if (null == message) {
            message = Constant.SUCCESS_MESSAGE;
        }
        int errorCode = paramException.getErrorCode();
        return failure(errorCode,message);
    }

}
