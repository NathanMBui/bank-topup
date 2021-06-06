package com.abcbank.topup.stores;

import com.abcbank.topup.controller.models.TopupPurchaseRequest;
import com.abcbank.topup.controller.models.VoucherDTO;
import org.springframework.scheduling.annotation.Async;

import java.util.Collection;

public interface VoucherStore {
    @Async
    void storeVoucherAsync(String username, TopupPurchaseRequest request, VoucherDTO response);
    Collection<VoucherDTO> getVouchers(String username, String phoneNumber);
}
