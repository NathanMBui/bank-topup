package com.abcbank.topup.controller.models;

import lombok.Data;

import java.util.Collection;

@Data
public class TopupGetVouchersResponse {

    private String phoneNumber;
    private Collection<VoucherDTO> vouchers;
}
