package com.abcbank.topup;

import com.abcbank.topup.api.models.TopupPurchaseRequest;
import com.abcbank.topup.api.models.TopupPurchaseResponse;
import org.junit.Assert;
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

	@Test
	void givenValidRequest_whenPurchase_thenReturnVoucherCode() throws URISyntaxException {
		URI uri = buildURI();
		TopupPurchaseRequest purchaseDetails = new TopupPurchaseRequest("transactionId", "9876543210", "Viettel", "ST90");
		HttpEntity<TopupPurchaseRequest> request = new HttpEntity<>(purchaseDetails);

		ResponseEntity<TopupPurchaseResponse> response = restTemplate.postForEntity(uri, request, TopupPurchaseResponse.class);
		TopupPurchaseResponse responseBody = response.getBody();

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull("body null", responseBody);
		Assert.assertNotNull("voucher code null", responseBody.getCode());
	}

	@Test
	void givenInvalidPhone_whenPurchase_thenReturnBadRequest() throws URISyntaxException  {
		URI uri = buildURI();
		TopupPurchaseRequest purchaseDetails = new TopupPurchaseRequest("transactionId", "abc", "Viettel", "ST90");
		HttpEntity<TopupPurchaseRequest> request = new HttpEntity<>(purchaseDetails);

		ResponseEntity<TopupPurchaseResponse> response = restTemplate.postForEntity(uri, request, TopupPurchaseResponse.class);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	private URI buildURI() throws URISyntaxException {
		final String baseUrl = "http://localhost:"+randomServerPort+"/topup/";
		return new URI(baseUrl);
	}
}
