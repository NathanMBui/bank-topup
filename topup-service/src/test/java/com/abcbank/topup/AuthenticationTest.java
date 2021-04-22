package com.abcbank.topup;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    // POST Login
    // @return "Authorization string".
    @Test
    public void postLogin() {

        // Request Header
        HttpHeaders headers = new HttpHeaders();

        // Request Body
        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<>();
        parametersMap.add("username", "admin");
        parametersMap.add("password", "admin");

        // Request Entity
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // POST Login
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + randomServerPort + "/login", //
                HttpMethod.POST, requestEntity, String.class);

        HttpHeaders responseHeaders = response.getHeaders();

        List<String> list = responseHeaders.get("Authorization");
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
    }

//    private static void callRESTApi(String restUrl, String authorizationString) {
//        // HttpHeaders
//        HttpHeaders headers = new HttpHeaders();
//
//        //
//        // Authorization string (JWT)
//        //
//        headers.set("Authorization", authorizationString);
//        //
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//        // Request to return JSON format
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        // HttpEntity<String>: To get result as String.
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        // RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Send request with GET method, and Headers.
//        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
//                HttpMethod.GET, entity, String.class);
//
//        String result = response.getBody();
//
//        System.out.println(result);
//    }
}
