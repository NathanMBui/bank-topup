package com.abcbank.topup.stores;

import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.VoucherData;
import org.springframework.scheduling.annotation.Async;

import java.util.Collection;

public interface VoucherStore {
    @Async
    void storeVoucherAsync(String username, TopupPurchaseRequest request, VoucherData response);
    Collection<VoucherData> getVouchers(String username, String phoneNumber);
}
