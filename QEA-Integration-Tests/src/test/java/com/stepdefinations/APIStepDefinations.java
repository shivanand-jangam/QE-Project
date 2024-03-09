package com.stepdefinations;

import com.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pojos.userdetails.Booking;
import com.pojos.userdetails.BookingDetails;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIStepDefinations extends BaseTest {

	@Given("I have endpoint as {string}")
	public void i_have_endpoint_as_and_want_create_user(String endpoint) {
		if (endpoint.contains("{id}")) {
			String endpointIs = endpoint.replace("{id}",
					String.valueOf(bookingDetails.bookingid));
			restUtil.setEndpoint(endpointIs);
		} else {
			restUtil.setEndpoint(endpoint);
		}
	}

	@When("I provided Content-Type as {string}")
	public void i_provide_as_contenttype(String string) {
		restUtil.setContentType("Content-Type", string);
	}

	@When("I have generated the token")
	public void i_have_generated_the_token() {
		restUtil.setToken();
	}

	@When("I hit {string} booking {string} request")
	public void i_hit_request(String condition, String requestType)
			throws JsonMappingException, JsonProcessingException {

		responseHolder = restUtil.hitAPIRequest(requestType);

		if (condition.equalsIgnoreCase("create")) {
			bookingDetails = mapper.readValue(
					responseHolder.getBody().asString(), BookingDetails.class);
		} else if (condition.equalsIgnoreCase("update")) {
			bookingUserDetails = mapper.readValue(
					responseHolder.getBody().asString(), Booking.class);
		}
	}

	@Then("I should get status code as {int}")
	public void the_response_status_code_should_be(int statusCode) {
		restUtil.verifyStatusCodeAs(statusCode);
	}

	@When("I provided in payloadbody firstname as {string} and lastname as {string}")
	public void i_provided_in_payloadbody_firstname_as_and_lastname_as_automation_tester(
			String firstname, String lastname) {
		String payload = "{\"firstname\":\"" + firstname + "\",\"lastname\":\""
				+ lastname
				+ "\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}";
		restUtil.setPayloadAs(payload);
	}

}
