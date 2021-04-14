package com.abcbank.topup.stores.impls;

import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.VoucherData;
import com.abcbank.topup.entities.User;
import com.abcbank.topup.entities.Voucher;
import com.abcbank.topup.repositories.UserRepository;
import com.abcbank.topup.repositories.VoucherRepository;
import com.abcbank.topup.stores.VoucherStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xxxStore is a helper class to decouple database from business logic
 */
@Service
public class VoucherStoreImpl implements VoucherStore {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public void storeVoucher(String username, TopupPurchaseRequest request, VoucherData voucherData) {
        User user = findUser(username);
        Voucher voucher = new Voucher();
        voucher.setCode(voucherData.getCode());
        voucher.setType(voucherData.getType());
        voucher.setPhone(request.getPhoneNumber());
        voucher.setProvider(voucherData.getProvider());
        voucher.setDescription(voucherData.getDescription());
        voucher.setUser(user);
        voucherRepository.save(voucher);
    }

    @Override
    public Collection<VoucherData> getVouchers(String username, String phoneNumber) {
        User user = findUser(username);
        List<Voucher> vouchers = voucherRepository.findByUserIdAndPhone(user.getId(), phoneNumber);
        return vouchers.stream().map((it) -> {
            VoucherData data = new VoucherData();
            data.setCode(it.getCode());
            data.setType(it.getType());
            data.setProvider(it.getProvider());
            data.setDescription(it.getDescription());
            return data;
        }).collect(Collectors.toList());
    }

    private User findUser(String username) {
        User user = userRepository.findByName(username); //TODO should get from cache
        if (user == null) { //FIXME just for demo
            user = new User();
            user.setName(username);
            userRepository.save(user);
        }
        return user;
    }
}
