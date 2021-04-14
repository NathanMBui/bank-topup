package com.abcbank.voucher;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VoucherIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    void givenValidRequest_whenPurchase_thenReturnVoucherCode() throws URISyntaxException {
        URI uri = buildURI();
        VoucherRequest requestData = new VoucherRequest("9876543210", "Viettel", "ST90");
        HttpEntity<VoucherRequest> request = new HttpEntity<>(requestData);

        ResponseEntity<VoucherResponse> response = restTemplate.postForEntity(uri, request, VoucherResponse.class);
        VoucherResponse responseBody = response.getBody();

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull("body null", responseBody);
        Assert.assertNotNull("voucher code null", responseBody.getCode());
    }

    @Test
    void givenInvalidRequest_whenPurchase_thenReturnVoucherCode() throws URISyntaxException {
        URI uri = buildURI();
        VoucherRequest requestData = new VoucherRequest("abc", "", "");
        HttpEntity<VoucherRequest> request = new HttpEntity<>(requestData);

        ResponseEntity<VoucherResponse> response = restTemplate.postForEntity(uri, request, VoucherResponse.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    private URI buildURI() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/vouchers/";
        return new URI(baseUrl);
    }
}
