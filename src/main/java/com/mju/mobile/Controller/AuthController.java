package com.mju.mobile.Controller;

import com.mju.mobile.Exception.Auth.AuthNotFoundException;
import com.mju.mobile.Model.Auth.Auth;
import com.mju.mobile.Model.Response.CommonResponse;
import com.mju.mobile.Repository.AuthRepository;
import com.mju.mobile.Request.Auth.LoginRequest;
import com.mju.mobile.Service.Response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthRepository authRepository;
    private final ResponseService responseService;

    @PostMapping("/login")
    public CommonResponse login(@RequestBody LoginRequest loginRequest) {
        Auth auth = authRepository.findById(loginRequest.getId()).orElseThrow(AuthNotFoundException::new);
        if(auth.getPassword().matches(loginRequest.getPassword())) {
            return responseService.singleResponse("success");
        } else {
            throw new RuntimeException();
        }
    }
}
