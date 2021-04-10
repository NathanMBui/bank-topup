package com.abcbank.topup.models;

public class TopupPurchaseResponse {

    private VoucherData voucher;

    public TopupPurchaseResponse() { }

    public TopupPurchaseResponse(VoucherData voucher) {
        this.voucher = voucher;
    }

    public VoucherData getVoucher() {
        return voucher;
    }

    public void setVoucher(VoucherData voucher) {
        this.voucher = voucher;
    }
}
