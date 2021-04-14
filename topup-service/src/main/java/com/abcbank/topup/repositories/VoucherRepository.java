package com.abcbank.topup.repositories;

import com.abcbank.topup.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

    List<Voucher> findByUserIdAndPhone(long userId, String phone);
}
