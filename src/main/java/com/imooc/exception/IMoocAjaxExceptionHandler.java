package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Arsenal
 * created on 2019/2/20 2:30
 */
//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest req, Exception e) {

        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }

}
