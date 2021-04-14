package com.abcbank.topup.stores;

import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.VoucherData;

import java.util.Collection;

public interface VoucherStore {
    void storeVoucher(String username, TopupPurchaseRequest request, VoucherData response);
    Collection<VoucherData> getVouchers(String username, String phoneNumber);
}
