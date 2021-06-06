package com.abcbank.topup;

import com.abcbank.topup.controller.model.TopupPurchaseRequest;
import com.abcbank.topup.dto.VoucherDTO;
import com.abcbank.topup.entity.Voucher;
import com.abcbank.topup.repository.VoucherRepository;
import com.abcbank.topup.store.VoucherStore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VoucherStoreTest {

    @Autowired
    VoucherStore voucherStore;

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Test
    public void givenVoucherCode_whenStore_thenFoundExactCode() throws InterruptedException {
        String username = "ABC";
        String phone = "1234567890";
        String expectedCode = "123";
        TopupPurchaseRequest request = new TopupPurchaseRequest("paymentId", phone, "Viettel", "ABC");
        VoucherDTO data = new VoucherDTO();
        data.setCode(expectedCode);
        data.setProvider(request.getProvider());
        data.setType(request.getType());

        voucherStore.storeVoucherAsync(username, request, data);
        executor.getThreadPoolExecutor().awaitTermination(1, TimeUnit.SECONDS);
        Collection<VoucherDTO> vouchers = voucherStore.getVouchers(username, phone);
        Assert.assertFalse(vouchers.isEmpty());
        Voucher expectedVoucher = voucherRepository.findByCode(expectedCode);
        Assert.assertNotNull(expectedVoucher);
        Assert.assertEquals(expectedCode, expectedVoucher.getCode());
    }
}
