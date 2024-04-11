package com.connectsecure.test.ui.connectsecure;

import com.base.utils.Utilities;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
  public void beforeMethod() throws InterruptedException {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    generalSettingHelper = new GeneralSettingHelper();

    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    loginPageHelper.loginIntoTheApplication(tenantName, loginName, password);
  }

  @AfterMethod
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 0, enabled = true)
  public void testGeneralSetting() throws InterruptedException {
    String language = Utilities.getEnvironmentProperties("language");
    generalSettingHelper.clickOnLaungaugeImage();
    generalSettingHelper.clickOnLaunguageAsPreffered(language);
    LogPrinter.printLog("language changed successfully.");
  }

  @Test(priority = 0, enabled = true)
  public void testToggleToDarkTheme() {
    generalSettingHelper.clickOnToggleButtonForDarkMode();
    LogPrinter.printLog("Toggled to dark-mode.");
  }
}
