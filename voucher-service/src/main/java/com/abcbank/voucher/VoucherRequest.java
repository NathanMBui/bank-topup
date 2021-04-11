package com.abcbank.voucher;

public class VoucherRequest {
    private String phone;
    private String provider;
    private String type;

    public VoucherRequest() {
    }

    public VoucherRequest(String phone, String provider, String type) {
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
