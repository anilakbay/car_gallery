package com.anilakbay.controller;

import com.anilakbay.dto.DtoAdress;
import com.anilakbay.dto.DtoAdressIU;

public interface IRestAddressController {

    public RootEntity<DtoAdress> saveAdress(DtoAdressIU dtoAdressIU);
}
