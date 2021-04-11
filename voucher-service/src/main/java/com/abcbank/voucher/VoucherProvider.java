package com.abcbank.voucher;

public interface VoucherProvider {

    VoucherData getVoucher(String phoneNumber, String type);
}
