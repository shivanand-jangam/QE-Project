package com.stepdefinations;

import com.base.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIStepDefinations extends BaseTest {

	@Given("I have API endpoint {string}")
	public void i_have_the_api_endpoint(String endpoint) {
		restUtil.setEndpoint(endpoint);
	}

	@When("I provided the content type as {string}")
	public void i_provided_the_content_type_as(String type) {
		restUtil.setContentType("Content-Type", type);
	}

	@When("I make a {string} request")
	public void i_make_a_request(String requestType) {
		responseHolder = restUtil.hitAPIRequest(requestType);
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int statusCode) {
		restUtil.verifyStatusCodeAs(statusCode);
	}

}
