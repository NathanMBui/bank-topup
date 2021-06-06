package com.abcbank.topup.controller.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopupPurchaseResponse {
    private String message;
    private String voucherCode;
}
