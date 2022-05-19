package com.mju.mobile.Service;

import com.mju.mobile.Constant.Constant;
import com.mju.mobile.Model.Response.CommonResponse;
import com.mju.mobile.Model.Response.SingleResponse;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public <T> SingleResponse<T> singleResponse(T data) {
        SingleResponse<T> response = new SingleResponse<T>();
        response.setData(data);
        this.setSuccessResult(response);
        return response;
    }

    public CommonResponse getFailResponse(int code, String message) {
        CommonResponse response = new CommonResponse();
        response.setSuccess(Constant.ConstantResponseSrvice.failFlag);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    private void setSuccessResult(CommonResponse response) {
        response.setSuccess(Constant.ConstantResponseSrvice.successFlag);
        response.setCode(Constant.ConstantResponseSrvice.successCode);
        response.setMessage(Constant.ConstantResponseSrvice.successMessage);
    }
}
