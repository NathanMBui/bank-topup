package com.abcbank.topup;

import com.abcbank.topup.controller.models.TopupPurchaseRequest;
import com.abcbank.topup.controller.models.TopupPurchaseResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopupControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	void givenInvalidPhone_whenPurchase_thenReturnBadRequest() throws URISyntaxException  {
		URI uri = buildURI();

		// Request Header
		HttpHeaders headers = new HttpHeaders();
		List<String> authorizations = postLogin();
		headers.put("Authorization", authorizations);

		TopupPurchaseRequest purchaseDetails = new TopupPurchaseRequest("transactionId", "abc", "Viettel", "ST90");
		HttpEntity<TopupPurchaseRequest> request = new HttpEntity<>(purchaseDetails, headers);

		ResponseEntity<TopupPurchaseResponse> response = restTemplate.postForEntity(uri, request, TopupPurchaseResponse.class);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	/**
	 *
	 * @return Authorization token
	 */
	private List<String> postLogin() {

		// Request Header
		HttpHeaders headers = new HttpHeaders();

		// Request Body
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<>();
		parametersMap.add("username", "admin");
		parametersMap.add("password", "admin");

		// Request Entity
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);

		// POST Login
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + randomServerPort + "/login", //
				HttpMethod.POST, requestEntity, String.class);

		HttpHeaders responseHeaders = response.getHeaders();

		List<String> list = responseHeaders.get("Authorization");
		Assert.assertNotNull(list);
		Assert.assertFalse(list.isEmpty());
		return list;
	}

	private URI buildURI() throws URISyntaxException {
		final String baseUrl = "http://localhost:"+randomServerPort+"/topup/";
		return new URI(baseUrl);
	}
}
