package com.anilakbay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAdress extends DtoBase {

    private String city;

    private String district;

    private String neighborhood;

    private String street;
}
