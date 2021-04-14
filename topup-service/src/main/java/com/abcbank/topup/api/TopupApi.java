package com.abcbank.topup.api;

import com.abcbank.topup.api.models.*;

import java.util.Collection;

public interface TopupApi {
    VoucherData purchase(String username, TopupPurchaseRequest request);
    Collection<VoucherData> getVouchers(String username, TopupGetVouchersRequest request);
}
