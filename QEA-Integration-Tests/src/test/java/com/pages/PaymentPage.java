package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.base.DriverManager;

public class PaymentPage {

  private static Logger log = LoggerFactory.getLogger(PaymentPage.class);

  public PaymentPage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  @FindBy(xpath = "//span[text()='Payment Method']")
  private WebElement orderOnlineButton;

  @FindBy(xpath = "//span[@data-label='Sub Total']/following-sibling::span/span")
  private WebElement subTotalText;

  public void verifyUserIsOnPaymentPage() {
    DriverManager.getCommonActions().waitForTimeOutInSec(5);
    Assert.assertTrue(DriverManager.getCommonActions().isElementDisplayed(orderOnlineButton),
        "User Is NOT Navigated to Payment Page. Please check the URL ");
    log.info("Verified that user is navigated to Payment Page");
  }

  public void verifySubTotalText(String expected) {
    DriverManager.getCommonActions().waitForTimeOutInSec(2);
    Assert.assertEquals(subTotalText.getText(), expected, "Expected Subtotal : " + expected
        + " Is not matching with the actual value: " + subTotalText.getText());
    log.info("Verified Expected Subtotal : " + expected + " Is matching with the actual value: "
        + subTotalText.getText());
  }
}
