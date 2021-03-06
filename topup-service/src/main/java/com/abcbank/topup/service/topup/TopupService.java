package com.abcbank.topup.service.topup;

import com.abcbank.topup.controller.model.TopupPurchaseRequest;
import com.abcbank.topup.dto.VoucherDTO;
import com.abcbank.topup.service.ExternalUrl;
import com.abcbank.topup.store.VoucherStore;
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
    public VoucherDTO purchase(String username, TopupPurchaseRequest request) {
        VoucherDTO response = restTemplate.postForObject(externalUrl.getPurchaseVoucherUrl(), request, VoucherDTO.class);
        voucherStore.storeVoucherAsync(username, request, response);
        return response;
    }

    @Override
    public Collection<VoucherDTO> getVouchers(String username, String phoneNumber) {
        return voucherStore.getVouchers(username, phoneNumber);
    }
}
