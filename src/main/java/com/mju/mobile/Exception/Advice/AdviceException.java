package com.mju.mobile.Exception.Advice;

import com.mju.mobile.Config.Constant.Constant;
import com.mju.mobile.Exception.Auth.AuthNotFoundException;
import com.mju.mobile.Model.Response.CommonResponse;
import com.mju.mobile.Service.Response.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class AdviceException {

    private final ResponseService responseService;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AuthNotFoundException.class)
    protected CommonResponse authNotFoundException() {
        return responseService.getFailResponse(Constant.ConstantAdviceException.code,Constant.ConstantAdviceException.message);
    }
}
