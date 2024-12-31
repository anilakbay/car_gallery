package com.anilakbay.controller.impl;

import com.anilakbay.controller.IRestAuthenticationController;
import com.anilakbay.controller.RestBaseController;
import com.anilakbay.controller.RootEntity;
import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.DtoUser;
import com.anilakbay.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }
}
