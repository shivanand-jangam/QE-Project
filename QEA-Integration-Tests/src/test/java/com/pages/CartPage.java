package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.DriverManager;

public class CartPage {
  private static Logger log = LoggerFactory.getLogger(CartPage.class);

  public CartPage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  private static String PRODUCT_TEXT_CART_PLACEHOLDER =
      "//div[@class='cart-item']/descendant::span[contains(text(),'%s')]";

  private static String PRODUCT_PRICETEXT_PLACEHOLDER =
      "//div[@class='cart-item']/descendant::span[@class='rupee']";

  @FindBy(xpath = "//div[@class='sub-hdng']//span[@class='sub-hdng--lft']")
  private WebElement subHeadingText;

  @FindBy(xpath = "//div[@class='sc-eTuwsz kiYUSk']//div[1]//span[@class='rupee']")
  private WebElement productSubToltalPriceText;

  @FindBy(xpath = "//button[@data-label='Place Order']")
  private WebElement placeOrderButton;

  @FindBy(xpath = "//input[@name='firstName']")
  private WebElement firstNameTextField;

  @FindBy(xpath = "//input[@name='lastName']")
  private WebElement lastNameTextField;

  @FindBy(xpath = "//input[@name='mobileNumber']")
  private WebElement mobileNumberTextField;

  @FindBy(xpath = "//input[@name='emailBox']")
  private WebElement emailBoxTextField;

  @FindBy(xpath = "//input[@name='addressBox']")
  private WebElement addressBoxTextField;

  @FindBy(xpath = "//input[@name='houseNumber']")
  private WebElement houseNumberTextField;

  @FindBy(xpath = "//input[@value='Save & Continue']")
  private WebElement saveContinueButton;

  public void verifyCartPage() {
    DriverManager.getCommonActions().waitForTimeOutInSec(5);
    Assert.assertTrue(DriverManager.getCommonActions().isElementDisplayed(subHeadingText),
        "User Is NOT Navigated to Cart Page. Please check the URL ");
    log.info("Verified that user is navigated to Cart Page");
    ExtentCucumberAdapter.addTestStepLog("Verified that user is navigated to Cart Page");
  }

  public void verifyProductOnCartPage(String product) {
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    DriverManager.getCommonActions()
        .scrollIntoCenterView(By.xpath(String.format(PRODUCT_TEXT_CART_PLACEHOLDER, product)));
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    Assert.assertTrue(
        DriverManager.getCommonActions()
            .isElementDisplayed(String.format(PRODUCT_TEXT_CART_PLACEHOLDER, product)),
        product + " : Product is not displayed in cart page");
    log.info("Verified that " + product + " is present into Cart Page");
    ExtentCucumberAdapter.addTestStepLog("Verified that " + product + " is present into Cart Page");
  }

  public void verifyPriceDetails(String product, String productPrice) {
    String actaulprice = DriverManager.getCommonActions()
        .getText(String.format(PRODUCT_PRICETEXT_PLACEHOLDER, product));
    Assert.assertEquals(actaulprice, productPrice,
        "price details of " + product + " NOT matching with expected price" + productPrice);
    log.info("price details of " + product + " matching with expected price" + productPrice);
    ExtentCucumberAdapter.addTestStepLog(
        "price details of " + product + " matching with expected price" + productPrice);
  }

  public void clickOnPlaceOrderButton() {
    placeOrderButton.click();
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    log.info("Clicked Place Order Button");
    ExtentCucumberAdapter.addTestStepLog("Clicked Place Order Button");
  }

  public void enterFirstNameTextField(String value) {
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    firstNameTextField.sendKeys(value);
    firstNameTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in First Name Text field as: " + value);
  }

  public void enterLastNameTextField(String value) {
    lastNameTextField.sendKeys(value);
    lastNameTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in Last Name Field as: " + value);
  }

  public void enterMobileNumberTextField(String value) {
    mobileNumberTextField.sendKeys(value);
    mobileNumberTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in Mobile Number Field as: " + value);
  }

  public void enterEmailBoxTextField(String value) {
    emailBoxTextField.sendKeys(value);
    emailBoxTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in EmailBox Field as: " + value);
  }

  public void enterAddressBoxTextField(String value) {
    addressBoxTextField.sendKeys(value);
    addressBoxTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in Address Field as: " + value);
  }

  public void enterHouseNumberTextField(String value) {
    houseNumberTextField.sendKeys(value);
    houseNumberTextField.sendKeys(Keys.TAB);
    log.info("Entered Text in HouseNumber Field as: " + value);
  }

  public void clickOnSaveContinueButton() {
    saveContinueButton.click();
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    log.info("Clicked Save Continue Button");
    ExtentCucumberAdapter.addTestStepLog("Clicked Save Continue Button");
  }

}
