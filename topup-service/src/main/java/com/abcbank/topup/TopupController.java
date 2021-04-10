package com.abcbank.topup;

import com.abcbank.topup.models.*;
import com.abcbank.topup.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopupController implements TopupApi {

    @Autowired
    private Validator validator;

    @PostMapping(path = "/topup", consumes = "application/json", produces = "application/json")
    @Override
    public TopupPurchaseResponse purchase(@RequestBody TopupPurchaseRequest request) {
        if (!validator.isPhoneNumberValid(request.getPhoneNumber()))
            throw new IllegalArgumentException("Invalid phone: " + request.getPhoneNumber());
        VoucherData voucher = new VoucherData();
        voucher.setCode("123");
        return new TopupPurchaseResponse(voucher);
    }

    @GetMapping(path = "/topup", produces = "application/json")
    @Override
    public TopupGetVouchersResponse getVouchers(TopupGetVouchersRequest request) {
        return new TopupGetVouchersResponse();
    }
}
