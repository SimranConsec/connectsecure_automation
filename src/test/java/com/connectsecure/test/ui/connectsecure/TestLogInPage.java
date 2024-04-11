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
    loginPageHelper = new LoginPageHelper();
    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    LoginPageHelper.loginIntoTheApplication(tenantName, loginName, password);
  }

  @AfterMethod
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 1, enabled = true)
  public void testUserIsAbleToLoginApplication() throws InterruptedException {
    LogPrinter.printLog("User is able to login into the application.");
  }
}
