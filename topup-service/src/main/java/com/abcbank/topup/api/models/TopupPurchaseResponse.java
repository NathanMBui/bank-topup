package com.abcbank.topup.api.models;

public class TopupPurchaseResponse {
    private String message;
    private String voucherCode;

    public TopupPurchaseResponse(){}

    public TopupPurchaseResponse(String message, String voucherCode) {
        this.message = message;
        this.voucherCode = voucherCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }
}
