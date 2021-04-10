package com.abcbank.topup;

import com.abcbank.topup.models.TopupGetVouchersRequest;
import com.abcbank.topup.models.TopupGetVouchersResponse;
import com.abcbank.topup.models.TopupPurchaseRequest;
import com.abcbank.topup.models.TopupPurchaseResponse;

public interface TopupApi {
    TopupPurchaseResponse purchase(TopupPurchaseRequest request);
    TopupGetVouchersResponse getVouchers(TopupGetVouchersRequest request);
}
