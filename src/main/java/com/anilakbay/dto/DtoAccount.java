package com.anilakbay.dto;

import com.anilakbay.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoAccount extends DtoBase {

    private String accountNo;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currencyType;
}