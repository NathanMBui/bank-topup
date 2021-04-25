package com.abcbank.topup.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopupPurchaseResponse {
    private String message;
    private String voucherCode;
}
