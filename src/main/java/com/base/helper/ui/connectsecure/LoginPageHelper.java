package com.base.helper.ui.connectsecure;

import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

  public void enterTenantName(String tenantName) {
    WebDriverFactory.waitForAnElementToBeVisible(txtboxTenantName, 30);
    WebDriverFactory.sendKeys(txtboxTenantName, tenantName);
  }

  public void clickOnSignIn() {
    WebDriverFactory.isElementClickable(boxSignIn, 5);
    WebDriverFactory.clickWebElement(boxSignIn, 7);
  }

  public void enterLoginName(String userName) {
    WebDriverFactory.waitForAnElementToBeVisible(txtboxLoginName, 30);
    WebDriverFactory.sendKeys(txtboxLoginName, userName);
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

  public boolean isConSecureLogoDisplayed() {
    WebDriverFactory.waitForPageToLoad(10);
    WebDriverFactory.isElementVisible(logoConSecure, 25);
    return logoConSecure.isDisplayed();
  }

  /**
   * Login to the application.
   *
   * @param tenantName - pass the tenant name
   * @param loginName  - pass the user name to login.
   * @param password   - pass the password to login
   * @author - simran.kumari
   */
  public static void loginIntoTheApplication(String tenantName, String loginName, String password) {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    LoginPageHelper loginPageHelper = new LoginPageHelper();
    loginPageHelper.enterTenantName(tenantName);
    loginPageHelper.clickOnSignIn();
    loginPageHelper.enterLoginName(loginName);
    loginPageHelper.clickOnNextButton();
    loginPageHelper.enterPassword(password);
    loginPageHelper.clickOnNext();
    Assert.assertTrue(loginPageHelper.isConSecureLogoDisplayed());
    LogPrinter.printLog("Logo is displayed.");
    LogPrinter.printLog("Logged in to the application successfully.");
  }
}
