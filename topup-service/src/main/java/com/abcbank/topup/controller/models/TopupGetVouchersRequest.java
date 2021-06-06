package com.abcbank.topup.controller.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class TopupGetVouchersRequest {

    @NotBlank(message = "phoneNumber is required")
    @Pattern(message = "phoneNumber is invalid",
            regexp =  "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")
    private String phoneNumber;
}
