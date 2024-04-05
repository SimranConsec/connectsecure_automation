package com.connectsecure.test.ui.connectsecure;

import com.base.utils.Utilities;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.helper.ui.connectsecure.GeneralSettingHelper;
import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

public class TestGenralSettingsPage {
  LoginPageHelper loginPageHelper;
  GeneralSettingHelper generalSettingHelper;

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    generalSettingHelper = new GeneralSettingHelper();
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 6, enabled = true)
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
    LogPrinter.printLog("Logged in to the application successfully.");
  }

  @Test(priority = 7, enabled = true)
  public void testGeneralSetting() {
    String launguage = Utilities.getEnvironmentProperties("launguage");
    generalSettingHelper.clickOnLaungaugeImage();
    generalSettingHelper.clickOnLaunguageAsPreffered(launguage);
    LogPrinter.printLog("Launguage changed successfully.");
  }

  @Test(priority = 8, enabled = true)
  public void testToggleToDarkTheme() {
    generalSettingHelper.clickOnToggleButtonForDarkMode();
    LogPrinter.printLog("Toggled to dark-mode.");
  }
}
