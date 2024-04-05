package com.connectsecure.test.ui.connectsecure;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.utils.LogPrinter;
import com.base.utils.Utilities;
import com.base.utils.WebDriverFactory;

public class TestLogInPage {
  LoginPageHelper loginPageHelper;

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
  }

  @AfterMethod
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 1, enabled = true)
  public void testLogIn() throws InterruptedException {
    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    loginPageHelper.enterTenantName(tenantName);
    loginPageHelper.clickOnSignIn();
    TimeUnit.SECONDS.sleep(5);
    loginPageHelper.enterLoginName(loginName);
    loginPageHelper.clickOnNextButton();
    loginPageHelper.enterPassword(password);
    loginPageHelper.clickOnNext();
    TimeUnit.SECONDS.sleep(10);
    Assert.assertTrue(loginPageHelper.isConsecureLogoDisplayed());
    LogPrinter.printLog("Logo is displayed.");
    LogPrinter.printLog("Logged in to the application successfully.");
  }
}
