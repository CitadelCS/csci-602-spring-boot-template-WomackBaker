package edu.citadel.main;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {

    RestTemplate restTemplate = new RestTemplate();
    protected ResponseEntity<String> latestResponse;

    protected void executeGet(String url) {
        latestResponse = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }

    protected void executePost(String url, Object data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(data, headers);
        latestResponse = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }

}
