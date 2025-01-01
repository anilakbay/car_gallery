package com.anilakbay.controller;

import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class RestBaseController {
    public <T> RootEntity ok(T payload) {
        return RootEntity.ok(payload);
    }

    public <T> RootEntity error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }

    public abstract RootEntity<AuthResponse> authenticate();

    @PostMapping("/authenticate")
    public abstract RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input);
}
