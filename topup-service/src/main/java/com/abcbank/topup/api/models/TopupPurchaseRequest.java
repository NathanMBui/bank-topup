package com.abcbank.topup.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TopupPurchaseRequest {

    @NotBlank(message = "paymentId is required")
    private String paymentId;

    @NotBlank(message = "phoneNumber is required")
    @Pattern(message = "phoneNumber is invalid",
            regexp =  "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")
    private String phoneNumber;

    @NotBlank(message = "provider is required")
    private String provider;

    @NotBlank(message = "type is required")
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
