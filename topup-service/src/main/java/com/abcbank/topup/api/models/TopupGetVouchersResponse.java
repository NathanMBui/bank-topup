package com.abcbank.topup.api.models;

import java.util.Collection;

public class TopupGetVouchersResponse {

    private String phoneNumber;
    private Collection<VoucherData> vouchers;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<VoucherData> getVouchers() {
        return vouchers;
    }

    public void setVouchers(Collection<VoucherData> vouchers) {
        this.vouchers = vouchers;
    }
}
