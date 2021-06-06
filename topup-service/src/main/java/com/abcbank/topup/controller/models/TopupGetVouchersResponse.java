package com.abcbank.topup.api.models;

import lombok.Data;

import java.util.Collection;

@Data
public class TopupGetVouchersResponse {

    private String phoneNumber;
    private Collection<VoucherData> vouchers;
}
