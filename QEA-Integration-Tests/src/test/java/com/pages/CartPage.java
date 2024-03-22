package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.base.DriverManager;

public class CartPage {
	private static Logger log = LoggerFactory.getLogger(CartPage.class);
	public CartPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	private static String PRODUCT_TEXT_CART_PLACEHOLDER = "//div[@data-label='itemsList']//div[@class='sc-chPdSV bTvQjn']//span[contains(text(),'%s')]";

	private static String PRODUCT_PRICETEXT_PLACEHOLDER = "//div[@data-label='itemsList']//div[@class='sc-chPdSV bTvQjn']//span[text()='%s']/following-sibling::div[@class='incr-price']//span[@class='rupee']";
	//
	// private static String
	// PRODUCT_SUBTOTAL_PRICE_PLACEHOLDER="//div[@class='sc-eTuwsz
	// kiYUSk']//div[1]//span[@class='rupee']";
	@FindBy(xpath = "//div[@class='sub-hdng']//span[@class='sub-hdng--lft']")
	private WebElement subHeadingText;

	@FindBy(xpath = "//div[@class='sc-eTuwsz kiYUSk']//div[1]//span[@class='rupee']")
	private WebElement productSubToltalPriceText;

	public void verifyCartPage() {
		DriverManager.getCommonActions().waitForTimeOutInSec(5);
		Assert.assertTrue(
				DriverManager.getCommonActions()
						.isElementDisplayed(subHeadingText),
				"User Is NOT Navigated to Cart Page. Please check the URL ");
		log.info("Verified that user is navigated to Cart Page");
	}
	public void verifyProductOnCartPage(String product) {
		Assert.assertTrue(
				DriverManager.getCommonActions().isElementDisplayed(
						String.format(PRODUCT_TEXT_CART_PLACEHOLDER, product)),
				product + " : Product is not displayed in cart page");
		log.info("Verified that " + product + " is present into Cart Page");
	}

	public void verifyPriceDetails(String product, String productPrice) {
		// DriverManager.getCommonActions().isElementDisplayed(String.format(PRODUCT_PRICETEXT_PLACEHOLDER,
		// product));
		String actaulprice = DriverManager.getCommonActions()
				.getText(String.format(PRODUCT_PRICETEXT_PLACEHOLDER, product));
		Assert.assertEquals(actaulprice, productPrice);
		log.info("price details of " + product + " matching with expected price"
				+ productPrice);

	}

}
