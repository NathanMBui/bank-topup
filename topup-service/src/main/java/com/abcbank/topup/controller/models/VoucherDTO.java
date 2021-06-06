package com.abcbank.topup.controller.models;

import lombok.Data;

@Data
public class VoucherDTO {
    private String code;
    private String type;
    private String provider;
    private String description;
}
