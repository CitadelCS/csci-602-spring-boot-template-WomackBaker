package edu.citadel.main;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefs extends SpringIntegrationTest{

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Info Test
    @When("^the client calls /info")
    public void the_client_issues_GET_info() throws Throwable{
        executeGet("http://localhost:5001/info");
    }

    @Then("^the client receives application name (.+)$")
    public void the_client_receives_application_name(String name) throws Throwable {
        JsonNode response = objectMapper.readTree(latestResponse.getBody());
        assertThat("application name is incorrect : "+
                latestResponse.getBody(), response.get("name").asText(), is(name));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_application_version(String version) throws Throwable {
        JsonNode response = objectMapper.readTree(latestResponse.getBody());
        assertThat("version is incorrect : "+
                latestResponse.getBody(), response.get("version").asText(), is(version));
    }

    @And("^the client receives server description \"(.+)\"$")
    public void the_client_receives_application_description(String description) throws Throwable {
        JsonNode response = objectMapper.readTree(latestResponse.getBody());
        assertThat("version is incorrect : "+
                latestResponse.getBody(), response.get("description").asText(), is(description));
    }

    // Health Test
    @When("^the client calls /health")
    public void the_client_issues_GET_health() throws Throwable{
        executeGet("http://localhost:5001/health");
    }

    @Then("^the client receives status (.+)$")
    public void the_client_receives_application_health(String status) throws Throwable {
        JsonNode response = objectMapper.readTree(latestResponse.getBody());
        assertThat("application status is incorrect : "+
                latestResponse.getBody(), response.get("status").asText(), is(status));
    }

    // Account ID Test
    private Map<String, String> accountPayload;

    @When("^the client creates an account with:$")
    public void the_client_creates_account(DataTable table) {
        accountPayload = table.asMap(String.class, String.class);
        executePost("http://localhost:5001/account", accountPayload);
    }

    @Then("^the response contains the account with status (\\d+)$")
    public void the_response_contains_account_status(int status) throws Throwable {
        assertThat("Status code mismatch", latestResponse.getStatusCode().value(), is(status));
    }
}
