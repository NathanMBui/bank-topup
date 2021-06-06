package com.abcbank.topup.api.models;

import lombok.Data;

@Data
public class VoucherData {
    private String code;
    private String type;
    private String provider;
    private String description;
}
