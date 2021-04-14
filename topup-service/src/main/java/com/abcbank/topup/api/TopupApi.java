package com.abcbank.topup.api;

import com.abcbank.topup.api.models.TopupGetVouchersRequest;
import com.abcbank.topup.api.models.TopupGetVouchersResponse;
import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.TopupPurchaseResponse;

public interface TopupApi {
    TopupPurchaseResponse purchase(String username, TopupPurchaseRequest request);
    TopupGetVouchersResponse getVouchers(String username, TopupGetVouchersRequest request);
}
