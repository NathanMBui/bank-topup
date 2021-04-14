package com.abcbank.voucher;

public interface VoucherProvider {

    VoucherResponse getVoucher(String phoneNumber, String type);
}
