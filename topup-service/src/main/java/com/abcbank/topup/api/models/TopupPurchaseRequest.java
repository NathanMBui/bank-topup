package com.abcbank.topup.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
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
}
