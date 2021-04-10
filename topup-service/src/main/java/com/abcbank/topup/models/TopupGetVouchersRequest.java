package com.abcbank.topup.models;

public class TopupGetVouchersRequest {
    private String phone;
    private String provider;
    private String type;

    public TopupGetVouchersRequest() {
    }

    public TopupGetVouchersRequest(String phone, String provider, String type) {
        this.phone = phone;
        this.provider = provider;
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
