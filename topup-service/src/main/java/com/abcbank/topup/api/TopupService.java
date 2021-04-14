package com.abcbank.topup.api;

import com.abcbank.topup.api.models.TopupGetVouchersRequest;
import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.VoucherData;
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
    public VoucherData purchase(String username, TopupPurchaseRequest request) {
        VoucherData response = restTemplate.postForObject(externalUrl.getPurchaseVoucherUrl(), request, VoucherData.class);
        voucherStore.storeVoucher(username, request, response);
        return response;
    }

    @Override
    public Collection<VoucherData> getVouchers(String username, TopupGetVouchersRequest request) {
        return voucherStore.getVouchers(username, request.getPhoneNumber());
    }
}
