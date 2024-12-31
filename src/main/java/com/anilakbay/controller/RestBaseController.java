package com.anilakbay.controller;

public class RestBaseController {
    public <T> RootEntity ok(T payload) {
        return RootEntity.ok(payload);
    }

    public <T> RootEntity error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }
}
