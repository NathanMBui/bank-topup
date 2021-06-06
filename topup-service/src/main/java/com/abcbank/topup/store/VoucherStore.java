package com.abcbank.topup.store;

import com.abcbank.topup.controller.model.TopupPurchaseRequest;
import com.abcbank.topup.dto.VoucherDTO;
import org.springframework.scheduling.annotation.Async;

import java.util.Collection;

public interface VoucherStore {
    @Async
    void storeVoucherAsync(String username, TopupPurchaseRequest request, VoucherDTO response);
    Collection<VoucherDTO> getVouchers(String username, String phoneNumber);
}
