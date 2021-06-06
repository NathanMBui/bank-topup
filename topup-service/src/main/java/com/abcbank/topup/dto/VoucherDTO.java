package com.abcbank.topup.dto;

import lombok.Data;

@Data
public class VoucherDTO {
    private String code;
    private String type;
    private String provider;
    private String description;
}
