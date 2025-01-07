package com.anilakbay.service;

import com.anilakbay.dto.DtoAdress;
import com.anilakbay.dto.DtoAdressIU;

public interface IAdressService {

    public DtoAdress saveAdress(DtoAdressIU dtoAdressIU);
}
