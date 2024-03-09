package com.stepdefinations;

import com.base.BaseTest;

import io.cucumber.java.en.Then;

public class UpdateUserStepDefinationDEmo extends BaseTest {

	@Then("I should booking user fistname as {string}")
	public void i_should_Booking_name_as(String expName) {
		restUtil.verifyExpectedMatchWithActual(expName,
				bookingUserDetails.firstname);
	}

	@Then("I should booking user lastname as {string}")
	public void i_should_Booking_lastname_as(String expjob) {
		restUtil.verifyExpectedMatchWithActual(expjob,
				bookingUserDetails.lastname);
	}

}
