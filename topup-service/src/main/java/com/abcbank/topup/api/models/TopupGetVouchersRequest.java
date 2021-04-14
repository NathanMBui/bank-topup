package com.abcbank.topup.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TopupGetVouchersRequest {

    @NotBlank(message = "phoneNumber is required")
    @Pattern(message = "phoneNumber is invalid",
            regexp =  "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")
    private String phoneNumber;

    public TopupGetVouchersRequest() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
