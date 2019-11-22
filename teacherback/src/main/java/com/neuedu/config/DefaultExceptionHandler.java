package com.neuedu.config;

import com.neuedu.bus.Result;
import com.neuedu.util.PassToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    @PassToken
    public Result exceptionHandler(HttpServletRequest request, Exception ex){
        return new Result(0, ex.getMessage());

    }
}
