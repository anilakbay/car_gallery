package com.anilakbay.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomer extends DtoBase {

    private String firstName;

    private String lastName;

    private String tckn;

    private Date birthOfDate;

    private DtoAdress address;

    private DtoAccount account;
}
