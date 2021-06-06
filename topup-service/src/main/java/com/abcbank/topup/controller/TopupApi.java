package com.abcbank.topup.controller;

import com.abcbank.topup.controller.models.*;

import java.util.Collection;

public interface TopupApi {
    VoucherDTO purchase(String username, TopupPurchaseRequest request);
    Collection<VoucherDTO> getVouchers(String username, String phoneNumber);
}
