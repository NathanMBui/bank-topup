package com.abcbank.topup;

import com.abcbank.topup.api.ExternalUrl;
import com.abcbank.topup.api.TopupApi;
import com.abcbank.topup.api.TopupService;
import com.abcbank.topup.stores.VoucherStore;
import com.abcbank.topup.stores.impls.VoucherStoreImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TopupApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopupApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public ExternalUrl externalUrl() {
		return new ExternalUrl();
	}

	@Bean
	public VoucherStore voucherStore() {
		return new VoucherStoreImpl();
	}

	@Bean
	public TopupApi topupApi() {
		return new TopupService();
	}
}
