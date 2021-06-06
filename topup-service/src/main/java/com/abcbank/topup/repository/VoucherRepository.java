package com.abcbank.topup.repository;

import com.abcbank.topup.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

    List<Voucher> findByUserIdAndPhone(long userId, String phone);
    Voucher findByCode(String code);
}
