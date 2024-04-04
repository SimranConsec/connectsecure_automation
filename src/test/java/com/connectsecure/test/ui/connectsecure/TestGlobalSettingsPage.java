package com.connectsecure.test.ui.connectsecure;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.helper.ui.connectsecure.GlobalSettingHelper;
import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

public class TestGlobalSettingsPage {
  LoginPageHelper loginPageHelper;
  GlobalSettingHelper globalSettingHelper;

  String tenantName = "ccnstest";
  String loginName = "venu@ccnstest.com";
  String password = "Hash@1234";
  String timeZoneIndex = "284";
  String index = "1";
  String idleFor = "60";
  String waitFor = "60";
  String updateAssetDepDays = "15";
  String updateAgentDepDays = "15";
  String updateSuppressDays = "90";
  String updatedTitle = "ConnectSecure :: Security and Vulnerability Manager";
  String updatedFooter = "ConnectSecure";
  String edrName = "hp wolf security";
  String year = "2024";
  String manufacture = "Bangalore";
  String description = "It is a Software Company";
  String insecureId = "8080";
  String deniedId = "443";
  String excludedId = "8080";
  String allowedId = "443";
  String complianceTypes = "NIST 800 53";
  String softwareName = "Veritas NetBackup";
  String timeIndex = "1";

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    globalSettingHelper = new GlobalSettingHelper();
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 9, enabled = true)
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

  @Test(priority = 10, enabled = true)
  public void testTimezoneSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkTimeZoneSetting();
    globalSettingHelper.clickOnSelectBarTimezone();
    globalSettingHelper.selectTheZonePreferred(timeZoneIndex);
    LogPrinter.printLog("TimeZone updated.");
  }

  @Test(priority = 11, enabled = true)
  public void testCustomDateFormatSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkDateFormatSetting();
    globalSettingHelper.clickOnSelectDateFormatBar();
    globalSettingHelper.selectDateFormatAsPrefered(index);
    LogPrinter.printLog("Date format updated.");
  }

  @Test(priority = 12, enabled = true)
  public void testSessionTimeoutSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkSessionTimeoutSetting();
    globalSettingHelper.enterIdleForTimeLimit(idleFor);
    globalSettingHelper.enterWaitforTimeLimit(waitFor);
    LogPrinter.printLog("Seesion timeout is updated.");
  }

  @Test(priority = 13, enabled = true)
  public void testPortsPolicySetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkPortsPolicySetting();
    globalSettingHelper.enterInsecurePortsId(insecureId);
    globalSettingHelper.enterExcludedPortsId(deniedId);
    globalSettingHelper.enterDeniedPortsId(excludedId);
    globalSettingHelper.enterAllowedPortsId(allowedId);
    LogPrinter.printLog("Ports policies are updated.");
  }

  @Test(priority = 14, enabled = true)
  public void testDepricationDaysSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkDeprecationDaysSetting();
    globalSettingHelper.enterAssetDeprecationDays(updateAssetDepDays);
    globalSettingHelper.enterAgentDeprecationDays(updateAgentDepDays);
    globalSettingHelper.enterMicrosoftSuppressDays(updateSuppressDays);
    LogPrinter.printLog("Deprication days are updated,");
  }

  @Test(priority = 15, enabled = true)
  public void testWhiteLabelSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkWhiteLabelSetting();
    globalSettingHelper.clickButtonEdittoUpdate();
    globalSettingHelper.enterPageTitle(updatedTitle);
    globalSettingHelper.enterFooter(updatedFooter);
    globalSettingHelper.clickImageToUpdateLogoinDarkMode();
    globalSettingHelper.clickImageToUpdateIconinDarkMode();
    globalSettingHelper.clickImageToUpdateLogoinLightMode();
    globalSettingHelper.clickImageToUpdateLogoinDarkMode();
    LogPrinter.printLog("White label settings are updated.");
  }

  @Test(priority = 16, enabled = true)
  public void testAddEdrApplicationSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnEdrApplicationLabelSetting();
    globalSettingHelper.clickAddEdrApplicationButton();
    globalSettingHelper.enterNameOfTheAntiVirusApplication(edrName);
    globalSettingHelper.enterYearOfRelease(year);
    globalSettingHelper.enterManufactureBy(manufacture);
    globalSettingHelper.enterDescription(description);
    globalSettingHelper.clickSaveEdrButton();
    LogPrinter.printLog("Edr added successfully.");
  }

  @Test(priority = 17, enabled = true)
  public void testEdrExcludeSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnEdrApplicationLabelSetting();
    globalSettingHelper.enterNameToSearch(edrName);
    globalSettingHelper.clickOnArrowButton();
    globalSettingHelper.enterNameToExcludeVirus(edrName);
    globalSettingHelper.clickOnArrowExclude();
    LogPrinter.printLog("Edr applications settings are updated.");
  }

  @Test(priority = 18, enabled = true)
  public void testComplianceScanSettings() throws InterruptedException {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkComplianceScan();
    TimeUnit.SECONDS.sleep(5);
    globalSettingHelper.selectCheckBoxAsPreffered(complianceTypes);
    LogPrinter.printLog("All Settings done successfully.");
  }

  @Test(priority = 19, enabled = true)
  public void testAddBackupSoftwareSetting() throws InterruptedException {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkBackupsoftwareSetting();
    globalSettingHelper.clickAddBackupSoftwareButton();
    TimeUnit.SECONDS.sleep(5);
    globalSettingHelper.enterSoftwareNameToAddInExclude(softwareName);
    globalSettingHelper.enterYearOfSoftwareRelease(year);
    globalSettingHelper.enterSoftwareManufactureBy(manufacture);
    globalSettingHelper.enterSoftwareDescription(description);
    globalSettingHelper.clickSaveBackupButton();
    LogPrinter.printLog("Backup software is addded successfully.");
  }

  @Test(priority = 20, enabled = true)
  public void testBackupExcludeSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkBackupsoftwareSetting();
    globalSettingHelper.clickAddBackupSoftwareButton();
    globalSettingHelper.enterNameOfTheBackupApplication(softwareName);
    globalSettingHelper.enterYearOfSoftwareRelease(year);
    globalSettingHelper.enterSoftwareManufactureBy(manufacture);
    globalSettingHelper.enterSoftwareDescription(description);
    globalSettingHelper.clickSaveBackupButton();
    LogPrinter.printLog("Backup spftware is added successfully.");
  }

  @Test(priority = 21, enabled = true)
  public void testAddSoftwareToExcludeAndRemove() {
    globalSettingHelper.enterSoftwareNameToAddInExclude(softwareName);
    globalSettingHelper.enterNameToRemoveExcludeSoftware(softwareName);
    LogPrinter.printLog("Backup applications settings are updated.");
  }

  @Test(priority = 22, enabled = true)
  public void testLwAgentScanSetting() {
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkAgentScan();
    globalSettingHelper.clickOnBoxSetTimeInterval();
    globalSettingHelper.selectTimeIntervalAsPreffered(timeIndex);
    globalSettingHelper.clickOnSetFromTimeBox();
  }
}
