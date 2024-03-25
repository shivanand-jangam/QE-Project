package com.stepdefinations.UI;

import com.base.BaseTest;
import com.base.DriverManager;
import com.base.PageObjectManager;

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
	

	@When("Make a note of one {string} Price under {string} section")
	public void make_a_note_of_pizz_amount_for(String product, String type) {
			//productDetails.setProductPrice(pageObjectManager.getMenuPage().getPriceOfSingleProduct(product, type));
			
				productDetails.setProductPrice(String.valueOf(decimalFormat
				.format(Double.parseDouble(pageObjectManager.getMenuPage()
						.getPriceOfSingleProduct(product, type)))));
	}
	@When("Add {string} more quantity of {string} under {string} section")
	public void add_more_quantity_of_under_section(String extraQua, String product, String type) {
		
		pageObjectManager.getMenuPage().increaseQuantityofProduct(extraQua, type, product);
	}

	@Then("Verify {string} added in the checkout section")
	public void verify_added_in_the_checkout_section(String product) {
		pageObjectManager.getMenuPage().verifyProductIsAddedInCart(product);
	}

	@Then("Verify total {string} {string} product price in the checkout section")
	public void verify_Price_in_the_checkout_section(String totalquantity, String product) {
		      System.out.println("total price : "+productDetails.getProductPrice());
		         String ProductPrice = productDetails.getProductPrice();
		        double oneProductPrice = Double.parseDouble(ProductPrice);
		        double totalProducts = Double.parseDouble(totalquantity);
		         Double totalProductsprice=oneProductPrice*totalProducts;
		         
		         String totalExpectedProductPrice =(String.valueOf(decimalFormat
		 				.format(totalProductsprice)));
		         
		         System.out.println("Total expected Product price : "+totalExpectedProductPrice);
		        
		     
				pageObjectManager.getMenuPage().verifytotalPriceOfProductAddedInCart(product,
						totalExpectedProductPrice);
	}
	@Then("Verify {string} and total quantity of {string} added in the checkout section")
	public void verify_and_total_quantity_added_in_the_checkout_section(String product, String totalproduct) {
	   pageObjectManager.getMenuPage().verifyquantityOfProductIntoMiniCart(product, totalproduct);
	}

	@When("Click on checkout button")
	public void click_on_checkout_button() {
		pageObjectManager.getMenuPage().clickOnMiniCartCheckoutButon();
	}

}
