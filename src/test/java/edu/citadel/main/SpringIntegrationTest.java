package edu.citadel.main;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringIntegrationTest {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();
    protected ResponseEntity<String> latestResponse;

    private String getBaseUrl() {
        return "http://localhost:" + port;
    }

    protected void executeGet(String endpoint) {
        String url = getBaseUrl() + endpoint;
        latestResponse = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }

    protected void executePost(String endpoint, Object data) {
        String url = getBaseUrl() + endpoint;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(data, headers);
        latestResponse = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }
}
