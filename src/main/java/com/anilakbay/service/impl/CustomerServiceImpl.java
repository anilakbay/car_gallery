package com.anilakbay.service.impl;

import com.anilakbay.dto.DtoCustomer;
import com.anilakbay.dto.DtoCustomerIU;
import com.anilakbay.exception.BaseException;
import com.anilakbay.exception.ErrorMessage;
import com.anilakbay.exception.MessageType;
import com.anilakbay.model.Account;
import com.anilakbay.model.Address;
import com.anilakbay.model.Customer;
import com.anilakbay.repository.AccountRepository;
import com.anilakbay.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
        if(!optAddress.isPresent()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId()));
        }

        Optional<Account> optionalAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if(!optAddress.isPresent()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId()));
        }

        Customer customer = new Customer();
        customer.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCustomerIU, customer);
        return customer;
    }

    @Override
    public DtoCustomer dtoCustomer(DtoCustomerIU dtoCustomerIU) {
        return null;
    }
}
