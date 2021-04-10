package com.abcbank.topup.models;

import java.util.Collection;

public class TopupGetVouchersResponse {

    private Collection<String> vouchers;

    public Collection<String> getVouchers() {
        return vouchers;
    }

    public void setVouchers(Collection<String> vouchers) {
        this.vouchers = vouchers;
    }
}
