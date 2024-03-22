package com.stepdefinations.UI;

import com.base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuPageStepDefination extends BaseTest {

  @Then("Verify navigated to Menu page")
  public void verify_navigated_to_menu_page() {
    pageObjectManager.getMenuPage().verifyUserIsOnMenuPage();
  }

  @When("Click on {string} Menu")
  public void click_on_menu(String menu) {
    pageObjectManager.getMenuPage().clickOnMenu(menu);
  }

  @When("Click on {string} Add to Cart button under {string} section")
  public void click_on_add_to_cart_button_for(String product, String type) {
    pageObjectManager.getMenuPage().clickOnAddToCartButton(type, product);
  }

  @When("Make a note of {string} Price under {string} section")
  public void make_a_note_of_pizz_amount_for(String product, String type) {
    // Convert to double and the format it for 2 decimals and to String
    productDetails.setProductPrice(String.valueOf(decimalFormat.format(Double
        .parseDouble(pageObjectManager.getMenuPage().getPriceOfGivenProduct(product, type)))));
  }

  @Then("Verify {string} added in the checkout section")
  public void verify_added_in_the_checkout_section(String product) {
    pageObjectManager.getMenuPage().verifyProductIsAddedInCart(product);
  }

  @Then("Verify {string} price in the checkout section")
  public void verify_Price_in_the_checkout_section(String product) {
    pageObjectManager.getMenuPage().verifyPriceOfProductAddedInCart(product, productDetails.getProductPrice());
  }

  @When("Click on checkout button")
  public void click_on_checkout_button() {
    pageObjectManager.getMenuPage().clickOnMiniCartCheckoutButon();
  }

}
