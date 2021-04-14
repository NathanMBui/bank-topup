package com.abcbank.topup.api;

import com.abcbank.topup.api.models.TopupGetVouchersRequest;
import com.abcbank.topup.api.models.TopupGetVouchersResponse;
import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.TopupPurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class TopupService implements TopupApi {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExternalUrl externalUrl;

    @Override
    public TopupPurchaseResponse purchase(String username, TopupPurchaseRequest request) {
        return restTemplate.postForObject(externalUrl.getPurchaseVoucherUrl(), request, TopupPurchaseResponse.class);
    }

    @Override
    public TopupGetVouchersResponse getVouchers(String username, TopupGetVouchersRequest request) {
        return null;
    }
}
