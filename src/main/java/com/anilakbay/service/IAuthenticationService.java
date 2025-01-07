package com.anilakbay.service;

import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.AuthResponse;
import com.anilakbay.dto.DtoUser;
import com.anilakbay.dto.RefreshTokenRequest;
import com.anilakbay.model.User;

public interface IAuthenticationService {

    public DtoUser register(User input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
