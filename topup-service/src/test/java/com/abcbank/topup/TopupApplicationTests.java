package com.abcbank.topup;

import com.abcbank.topup.models.TopupPurchaseRequest;
import com.abcbank.topup.models.TopupPurchaseResponse;
import com.abcbank.topup.validators.Validator;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopupApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Autowired
	Validator validator;

	@Test
	void given_validRequest_when_purchase_then_returnVoucherCode() throws URISyntaxException {
		URI uri = buildURI();
		TopupPurchaseRequest purchaseDetails = new TopupPurchaseRequest("transactionId", "9876543210", "Viettel", "ST90");
		HttpEntity<TopupPurchaseRequest> request = new HttpEntity<>(purchaseDetails);

		ResponseEntity<TopupPurchaseResponse> response = restTemplate.postForEntity(uri, request, TopupPurchaseResponse.class);
		TopupPurchaseResponse responseBody = response.getBody();

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull("body null", responseBody);
		Assert.assertEquals("123", responseBody.getVoucher().getCode());
	}

	@Test
	void given_invalidPhone_when_purchase_then_returnError() throws URISyntaxException  {
		URI uri = buildURI();
		TopupPurchaseRequest purchaseDetails = new TopupPurchaseRequest("transactionId", "abc", "Viettel", "ST90");
		HttpEntity<TopupPurchaseRequest> request = new HttpEntity<>(purchaseDetails);

		ResponseEntity<TopupPurchaseResponse> response = restTemplate.postForEntity(uri, request, TopupPurchaseResponse.class);
		int statusCode = response.getStatusCodeValue();
		Assert.assertEquals(500, statusCode);
	}

	private URI buildURI() throws URISyntaxException {
		final String baseUrl = "http://localhost:"+randomServerPort+"/topup/";
		return new URI(baseUrl);
	}

	@Test()
	public void testPhoneValidating() {
		Assert.assertFalse(validator.isPhoneNumberValid("abc123"));
		Assert.assertFalse(validator.isPhoneNumberValid("123445abc"));
		Assert.assertFalse(validator.isPhoneNumberValid("98765"));
		Assert.assertTrue(validator.isPhoneNumberValid("9876541230"));
	}
}
