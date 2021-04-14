package com.abcbank.topup.api;

import com.abcbank.topup.api.models.*;
import com.abcbank.topup.stores.VoucherStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class TopupService implements TopupApi {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExternalUrl externalUrl;

    @Autowired
    private VoucherStore voucherStore;

    @Override
    public TopupPurchaseResponse purchase(String username, TopupPurchaseRequest request) {
        TopupPurchaseResponse response = restTemplate.postForObject(externalUrl.getPurchaseVoucherUrl(), request, TopupPurchaseResponse.class);
        voucherStore.storeVoucherAsync(username, request, response);
        return response;
    }

    @Override
    public TopupGetVouchersResponse getVouchers(String username, TopupGetVouchersRequest request) {
        Collection<VoucherData> vouchers = voucherStore.getVouchers(username, request.getPhoneNumber());
        TopupGetVouchersResponse response = new TopupGetVouchersResponse();
        response.setPhoneNumber(request.getPhoneNumber());
        response.setVouchers(vouchers);
        return response;
    }
}
