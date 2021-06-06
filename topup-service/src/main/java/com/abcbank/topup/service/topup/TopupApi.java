package com.abcbank.topup.service.topup;

import com.abcbank.topup.controller.model.*;
import com.abcbank.topup.dto.VoucherDTO;

import java.util.Collection;

public interface TopupApi {
    VoucherDTO purchase(String username, TopupPurchaseRequest request);
    Collection<VoucherDTO> getVouchers(String username, String phoneNumber);
}
