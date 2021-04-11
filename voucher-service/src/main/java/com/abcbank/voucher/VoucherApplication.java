package com.abcbank.voucher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VoucherApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoucherApplication.class);
    }

    @Bean
    public VoucherProviderManager voucherProviderManager() {
        return new VoucherProviderManager();
    }
}
