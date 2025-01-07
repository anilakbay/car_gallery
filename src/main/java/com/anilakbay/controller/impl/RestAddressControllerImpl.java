package com.anilakbay.controller.impl;

import com.anilakbay.controller.IRestAddressController;
import com.anilakbay.controller.RestBaseController;
import com.anilakbay.controller.RootEntity;
import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.AuthResponse;
import com.anilakbay.dto.DtoAdress;
import com.anilakbay.dto.DtoAdressIU;
import com.anilakbay.service.IAdressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

    @Autowired
    private IAdressService adressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAdress> saveAdress(@Valid @RequestBody DtoAdressIU dtoAdressIU) {
        return ok(adressService.saveAdress(dtoAdressIU));
    }

    @Override
    public RootEntity<AuthResponse> authenticate() {
        return null;
    }

    @Override
    public RootEntity<AuthResponse> authenticate(AuthRequest input) {
        return null;
    }
}
