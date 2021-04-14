package com.abcbank.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoucherController {

    @Autowired
    public VoucherProviderManager providerManager;

    private final Random random = new Random();

    @PostMapping(value = "/vouchers")
    public ResponseEntity<VoucherResponse> requestVoucher(@Valid @RequestBody VoucherRequest request) throws InterruptedException {
        Thread.sleep(random.nextInt(6000)); //latency
        String providerName = request.getProvider();
        VoucherProvider provider = providerManager.getProvider(providerName);
        if (provider == null) {
            return ResponseEntity.badRequest().build();
        }
        VoucherResponse voucherResponse = provider.getVoucher(request.getPhoneNumber(), request.getType());
        return ResponseEntity.ok(voucherResponse);
    }
}
