package com.anilakbay.controller;

import com.anilakbay.dto.DtoAccount;
import com.anilakbay.dto.DtoAccountIU;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
