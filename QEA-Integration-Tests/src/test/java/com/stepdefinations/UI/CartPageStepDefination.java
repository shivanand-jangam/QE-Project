package com.stepdefinations.UI;

import com.base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStepDefination extends BaseTest {

  @Then("Verify navigated to cart page")
  public void verify_navigated_to_cart_page() {
    pageObjectManager.getCartPage().verifyCartPage();
  }

  @Then("Verify {string} is showing in the cart page")
  public void verify_is_showing_in_the_cart_page(String product) {
    pageObjectManager.getCartPage().verifyProductOnCartPage(product);
  }

  @Then("Verify price details of {string} in cart page")
  public void verify_price_details_in_cart_page(String product) {
    pageObjectManager.getCartPage().verifyPriceDetails(product, productDetails.getProductPrice());
  }

  @When("Click on place order button")
  public void click_on_place_order_button() {
    pageObjectManager.getCartPage().clickOnPlaceOrderButton();
  }

  @When("Fill all following details")
  public void fill_all_following_details() {
    pageObjectManager.getCartPage().enterFirstNameTextField(dataFaker.name().fullName());
    pageObjectManager.getCartPage().enterLastNameTextField(dataFaker.name().lastName());
    pageObjectManager.getCartPage()
        .enterMobileNumberTextField("9730834941");
    pageObjectManager.getCartPage()
        .enterEmailBoxTextField("shivanand.jangam@gmail.com");
    pageObjectManager.getCartPage().enterAddressBoxTextField(dataFaker.address().cityName());
    pageObjectManager.getCartPage().enterHouseNumberTextField(dataFaker.address().buildingNumber());

  }

  @When("Click on save to continue button")
  public void click_on_save_to_continue_button() {
    pageObjectManager.getCartPage().clickOnSaveContinueButton();
  }
}
