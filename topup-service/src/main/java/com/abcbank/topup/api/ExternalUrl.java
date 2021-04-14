package com.abcbank.topup.api;


import org.springframework.stereotype.Service;

/**
 * TODO should load from config or sorts of...
 */
@Service
public class ExternalUrl {

    private String purchaseVoucherUrl = "http://localhost:8081/vouchers";

    public String getPurchaseVoucherUrl() {
        return purchaseVoucherUrl;
    }

    public void setPurchaseVoucherUrl(String purchaseVoucherUrl) {
        this.purchaseVoucherUrl = purchaseVoucherUrl;
    }
}
