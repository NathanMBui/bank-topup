package com.abcbank.topup;

import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.VoucherData;
import com.abcbank.topup.entities.Voucher;
import com.abcbank.topup.repositories.VoucherRepository;
import com.abcbank.topup.stores.VoucherStore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VoucherStoreTest {

    @Autowired
    VoucherStore voucherStore;

    @Autowired
    VoucherRepository voucherRepository;

    @Test
    public void givenVoucherCode_whenStore_thenFoundExactCode() {
        String username = "ABC";
        String phone = "1234567890";
        String expectedCode = "123";
        TopupPurchaseRequest request = new TopupPurchaseRequest("paymentId", phone, "Viettel", "ABC");
        VoucherData data = new VoucherData();
        data.setCode(expectedCode);
        data.setProvider(request.getProvider());
        data.setType(request.getType());

        voucherStore.storeVoucher(username, request, data);

        Collection<VoucherData> vouchers = voucherStore.getVouchers(username, phone);
        Assert.assertFalse(vouchers.isEmpty());
        Voucher expectedVoucher = voucherRepository.findByCode(expectedCode);
        Assert.assertNotNull(expectedVoucher);
        Assert.assertEquals(expectedCode, expectedVoucher.getCode());
    }
}
