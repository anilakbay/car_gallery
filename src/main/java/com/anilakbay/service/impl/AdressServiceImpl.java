package com.anilakbay.service.impl;

import com.anilakbay.exception.BaseException;
import com.anilakbay.exception.ErrorMessage;
import com.anilakbay.service.IAdressService;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements IAdressService {

    public void test() {
        throw new BaseException(new ErrorMessage(null, null));
    }
}
