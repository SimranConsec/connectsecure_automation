package com.connectsecure.test.ui.connectsecure;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.helper.ui.connectsecure.GenralSettingHelper;
import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

public class TestGenralSettingsPage {
  LoginPageHelper loginPageHelper;
  GenralSettingHelper genralSettingHelper;

  String tenantName = "ccnstest";
  String loginName = "venu@ccnstest.com";
  String password = "Hash@1234";
  String launguage = "English";

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    genralSettingHelper = new GenralSettingHelper();
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 6, enabled = true)
  public void testLogIn() throws InterruptedException {
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
  public void testGenralSetting() {
    genralSettingHelper.clickOnLaungaugeImage();
    genralSettingHelper.clickOnLaunguageAsPreffered(launguage);
    LogPrinter.printLog("Language changed successfully.");
  }

  @Test(priority = 8, enabled = true)
  public void testToggleToDarkTheme() {
    genralSettingHelper.clickOnToggleButtonForDarkMode();
    LogPrinter.printLog("Toggled to dark-mode.");
  }
}
