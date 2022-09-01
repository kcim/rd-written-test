package com.rd.written.test;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder

public class Account {
    private String number;
    private BigDecimal balance;
    private LocalDate balanceDate;
}
