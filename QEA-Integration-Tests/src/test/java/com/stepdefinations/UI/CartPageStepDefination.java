package com.stepdefinations.UI;

import com.aventstack.extentreports.model.Log;
import com.base.BaseTest;
import com.base.PageObjectManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStepDefination extends BaseTest {

	@Then("Verify navigated to cart page")
	public void verify_navigated_to_cart_page() {
		pageObjectManager.geCartPage().verifyCartPage();
	}

	@Then("Verify {string} is showing in the cart page")
	public void verify_is_showing_in_the_cart_page(String product) {
		pageObjectManager.geCartPage().verifyProductOnCartPage(product);

	}

	@Then("Verify price details of {sring} in cart page")
	public void verify_price_details_in_cart_page(String product) {
		pageObjectManager.geCartPage().verifyPriceDetails(product);
		
		

	}

	@When("Click on place order button")
	public void click_on_place_order_button() {
	}

	@When("Fill all following details")
	public void fill_all_following_details(DataTable dataTable) {

	}

	@When("Click on save to continue button")
	public void click_on_save_to_continue_button() {

	}
}
