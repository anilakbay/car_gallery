package com.anilakbay.controller;

import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.AuthResponse;
import com.anilakbay.dto.DtoUser;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest authRequest);
}
