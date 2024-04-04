package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageHelper {

  /**
   * Constructor.
   */
  public LoginPageHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * Logging to the page.
   */

  @FindBy(xpath = "//input[@id='company']")
  private WebElement txtboxTenantName;

  @FindBy(xpath = "//span[contains(text(),'Sign in')]")
  private WebElement boxSignIn;

  @FindBy(xpath = "//input[@id='loginName']")
  private WebElement txtboxLoginName;

  @FindBy(xpath = "//button[@id='submit-button']")
  private WebElement boxNext;

  @FindBy(xpath = "//input[@id='password']")
  private WebElement txtboxPassword;

  @FindBy(xpath = "//div[1]/img[1][@alt='Logo image']")
  private WebElement logoConSecure;

  public void enterTenantName(String tenantname) {
    WebDriverFactory.sendKeys(txtboxTenantName, tenantname);
  }

  public void clickOnSignIn() {
    WebDriverFactory.isElementClickable(boxSignIn, 5);
    WebDriverFactory.clickWebElement(boxSignIn, 7);
  }

  public void enterLoginName(String loginname) {
    WebDriverFactory.sendKeys(txtboxLoginName, loginname);
  }

  public void clickOnNextButton() {
    WebDriverFactory.clickWebElement(boxNext, 7);
  }

  public void enterPassword(String password) {
    WebDriverFactory.sendKeys(txtboxPassword, password);
  }

  public void clickOnNext() {
    WebDriverFactory.clickWebElement(boxNext, 10);
  }

  public boolean isConsecureLogoDisplayed() {
    return logoConSecure.isDisplayed();
  }
}
