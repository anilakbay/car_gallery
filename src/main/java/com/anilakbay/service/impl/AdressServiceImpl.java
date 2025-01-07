package com.anilakbay.service.impl;

import com.anilakbay.dto.DtoAdress;
import com.anilakbay.dto.DtoAdressIU;
import com.anilakbay.exception.BaseException;
import com.anilakbay.exception.ErrorMessage;
import com.anilakbay.model.Address;
import com.anilakbay.service.IAdressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdressServiceImpl implements IAdressService {

    @Autowired
    private AddressRepository addressRepository;

    private Address createAddress(DtoAdressIU dtoAdressIU) {
        Address address = new Address();
        address.setCreatedTime(new Date());

        BeanUtils.copyProperties(dtoAdressIU, address);

        return address;
    }

    @Override
    public DtoAdress saveAdress(DtoAdressIU dtoAdressIU) {
        DtoAdress dtoAdress = new DtoAdress();

        Address savedAddress = addressRepository.save(createAddress(dtoAdressIU));
        BeanUtils.copyProperties(savedAddress, dtoAdress);
        return dtoAdress;
    }
}
