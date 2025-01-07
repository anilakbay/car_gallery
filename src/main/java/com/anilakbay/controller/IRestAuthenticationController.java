package com.anilakbay.controller;

import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.AuthResponse;
import com.anilakbay.dto.DtoUser;
import com.anilakbay.dto.RefreshTokenRequest;
import com.anilakbay.model.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(User input);

    public RootEntity<AuthResponse> authenticate(AuthRequest authRequest);

    public RootEntity<AuthResponse> refreshToken(AuthRequest authRequest);

    @PostMapping("/refreshToken")
    RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input);
}
