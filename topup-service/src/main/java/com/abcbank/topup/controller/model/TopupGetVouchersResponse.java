package com.abcbank.topup.controller.model;

import com.abcbank.topup.dto.VoucherDTO;
import lombok.Data;

import java.util.Collection;

@Data
public class TopupGetVouchersResponse {

    private String phoneNumber;
    private Collection<VoucherDTO> vouchers;
}
