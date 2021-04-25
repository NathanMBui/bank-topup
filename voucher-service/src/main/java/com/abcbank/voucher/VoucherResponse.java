package com.abcbank.voucher;

import lombok.Data;

@Data
public class VoucherResponse {
    private String code;
    private String type;
    private String provider;
    private String description;
}
