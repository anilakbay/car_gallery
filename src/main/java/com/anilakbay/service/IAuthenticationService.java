package com.anilakbay.service;

import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.AuthResponse;
import com.anilakbay.dto.DtoUser;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);
}
