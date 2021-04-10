package com.abcbank.topup.models;

public class TopupPurchaseRequest {

    private String paymentId;
    private String phoneNumber;
    private String provider;
    private String type;

    public TopupPurchaseRequest(String paymentId, String phoneNumber, String provider, String type) {
        this.paymentId = paymentId;
        this.phoneNumber = phoneNumber;
        this.provider = provider;
        this.type = type;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
