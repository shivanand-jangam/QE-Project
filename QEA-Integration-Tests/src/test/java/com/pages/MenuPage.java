package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.DriverManager;

public class MenuPage {

	private static Logger log = LoggerFactory.getLogger(MenuPage.class);

	public MenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	private static String MENU_PLACEHOLDER = "//div[@data-label='%s']/span";

	private static String PRODUCT_ADDTOCART_BTN_PLACEHOLER = "//div[@class='ref']/following-sibling::div/div[@data-label='%s']/descendant::div[@data-label='%s']/descendant::button[@data-label='addTocart']";
	private static String PRODUCT_PRICE_PLACEHOLDER = "###//div[@class='ref']/following-sibling::div/div[@data-label='%s']/descendant::div[@data-label='%s']/descendant::span[@class='rupee']";
	private static String MAKE_MY_PIZZA_MORE_YUMMY_POPUP = "//button[@data-label='Add button']/span";

	private static String CART_PRODUCT_NAMETEXT_PLACEHOLDER = "//div[@class='crt-itms']/descendant::span[text()='%s']";
	private static String CART_PRODUCT_PRICE_PLACEHOLDER = "//div[@class='crt-itms']/descendant::span[text()='%s']/ancestor::div[@class='crt-cnt']/following-sibling::div/descendant::span[@class='rupee']";

	@FindBy(xpath = "//div[@class='slct-lctn-cnt']")
	private WebElement menuPageAddressLink;

	@FindBy(xpath = "//button[@data-label='miniCartCheckout']")
	private WebElement miniCartCheckoutButton;

	public void verifyUserIsOnMenuPage() {
		DriverManager.getCommonActions().waitForTimeOutInSec(3);
		Assert.assertTrue(
				DriverManager.getCommonActions()
						.isElementDisplayed(menuPageAddressLink),
				"User Is NOT Navigated to Menu Page. Please check the URL ");
		log.info("Verified that user is navigated to Menu Page");
	}

	public void clickOnMenu(String menuName) {
		DriverManager.getCommonActions()
				.click(String.format(MENU_PLACEHOLDER, menuName));
		log.info("User Navigated to " + menuName + " Section");
	}

	public void clickOnAddToCartButton(String product, String type) {
		DriverManager.getCommonActions().click(
				String.format(PRODUCT_ADDTOCART_BTN_PLACEHOLER, product, type));
		log.info("Clicked on Add to Cart Button for : " + product);
		if (DriverManager.getCommonActions()
				.isElementDisplayed(MAKE_MY_PIZZA_MORE_YUMMY_POPUP)) {
			DriverManager.getCommonActions()
					.click(MAKE_MY_PIZZA_MORE_YUMMY_POPUP);
		}
	}

	public String getPriceOfGivenProduct(String product, String type) {
		return DriverManager.getCommonActions().getText(
				String.format(PRODUCT_PRICE_PLACEHOLDER, type, product));
	}

	public void verifyProductIsAddedInCart(String product) {
		DriverManager.getCommonActions().waitForTimeOutInSec(2);
		Assert.assertTrue(
				DriverManager.getCommonActions()
						.isElementDisplayed(String.format(
								CART_PRODUCT_NAMETEXT_PLACEHOLDER, product)),
				product + " : Product is not added in the cart. Please check the before steps..");
		log.info("Verified that Product " + product + " is added in the cart.");
	}

	public void verifyPriceOfProductAddedInCart(String product, String price) {
		DriverManager.getCommonActions().waitForTimeOutInSec(2);
		String actualPrice = DriverManager.getCommonActions().getText(
				String.format(CART_PRODUCT_PRICE_PLACEHOLDER, product));
		Assert.assertEquals(actualPrice.trim(), price.trim(),
				product + " : Product Actual Price" + actualPrice
						+ " is not matching with the expected Value: " + price);
		log.info("Verified that Product " + product + " Price is " + actualPrice
				+ " is matching with the expected Value " + price);
		ExtentCucumberAdapter.addTestStepLog("Verified that Product " + product + " Price is " + actualPrice
                + " is matching with the expected Value " + price);
	}

	public void clickOnMiniCartCheckoutButon() {
		DriverManager.getCommonActions().click(miniCartCheckoutButton);
		log.info("Clicked on Mini Cart Checkout Button");
	}

}
