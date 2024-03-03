package com.stepdefinations;

import org.testng.Assert;

import com.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pojos.userdetails.ListOfUsers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserDetailsStepDefinations extends BaseTest {

	public ListOfUsers listOfUsers;
	String actualValue;

	@When("I make a {string} request for user details")
	public void i_make_a_request(String requestType)
			throws JsonMappingException, JsonProcessingException {

		responseHolder = restUtil.hitAPIRequest(requestType);

		listOfUsers = mapper.readValue(responseHolder.getBody().asString(),
				ListOfUsers.class);
	}

	@Then("Verify id as {int}")
	public void verify_id_as(int id) {

		for (int i = 0; i < listOfUsers.data.size(); i++) {
			if (listOfUsers.data.get(i).id == id) {
				restUtil.verifyExpectedMatchWithActual(id,
						listOfUsers.data.get(i).id);
				return;
			}
		}
		Assert.fail("Given Id: " + id + " Is not present in the reponse");
	}

	@Then("Verify email as {string}")
	public void verify_email_as(String email) {

		for (int i = 0; i < listOfUsers.data.size(); i++) {
			if (listOfUsers.data.get(i).email.equals(email)) {
				restUtil.verifyExpectedMatchWithActual(email,
						listOfUsers.data.get(i).email);
				return;
			}
		}
		Assert.fail("Given email: " + email + " Is not present in the reponse");
	}

	@Then("Verify first_name as {string}")
	public void verify_first_name_as(String fname) {
		for (int i = 0; i < listOfUsers.data.size(); i++) {
			if (listOfUsers.data.get(i).first_name.equals(fname)) {
				restUtil.verifyExpectedMatchWithActual(fname,
						listOfUsers.data.get(i).first_name);
				return;
			}
		}
		Assert.fail("Given fname: " + fname + " Is not present in the reponse");
	}

	@Then("Verify last_name as {string}")
	public void verify_last_name_as(String lname) {
		for (int i = 0; i < listOfUsers.data.size(); i++) {
			if (listOfUsers.data.get(i).last_name.equals(lname)) {
				restUtil.verifyExpectedMatchWithActual(lname,
						listOfUsers.data.get(i).last_name);
				return;
			}
		}
		Assert.fail(
				"Given last_name: " + lname + " Is not present in the reponse");
	}

	@Then("Verify avatar as {string}")
	public void verify_avatar_as(String avatarLink) {
		for (int i = 0; i < listOfUsers.data.size(); i++) {
			if (listOfUsers.data.get(i).avatar.equals(avatarLink)) {
				restUtil.verifyExpectedMatchWithActual(avatarLink,
						listOfUsers.data.get(i).avatar);
				return;
			}
		}
		Assert.fail("Given avatarLink: " + avatarLink
				+ " Is not present in the reponse");
	}

}
