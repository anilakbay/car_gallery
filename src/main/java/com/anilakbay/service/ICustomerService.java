package com.anilakbay.service;

import com.anilakbay.dto.DtoCustomer;
import com.anilakbay.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer dtoCustomer(DtoCustomerIU dtoCustomerIU);
}
