package com.connectsecure.test.ui.connectsecure;

import com.base.utils.Utilities;
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

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    globalSettingHelper = new GlobalSettingHelper();

    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    loginPageHelper.loginIntoTheApplication(tenantName, loginName, password);
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 10, enabled = true)
  public void testTimezoneSetting() {
    String timeZoneIndex = Utilities.getEnvironmentProperties("timeZoneIndex");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkTimeZoneSetting();
    globalSettingHelper.clickOnSelectBarTimezone();
    globalSettingHelper.selectTheZonePreferred(timeZoneIndex);
    LogPrinter.printLog("TimeZone updated.");
  }

  @Test(priority = 11, enabled = true)
  public void testCustomDateFormatSetting() {
    String index = Utilities.getEnvironmentProperties("index");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkDateFormatSetting();
    globalSettingHelper.clickOnSelectDateFormatBar();
    globalSettingHelper.selectDateFormatAsPrefered(index);
    LogPrinter.printLog("Date format updated.");
  }

  @Test(priority = 12, enabled = true)
  public void testSessionTimeoutSetting() {
    String idleFor = Utilities.getEnvironmentProperties("idleFor");
    String waitFor = Utilities.getEnvironmentProperties("waitFor");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkSessionTimeoutSetting();
    globalSettingHelper.enterIdleForTimeLimit(idleFor);
    globalSettingHelper.enterWaitforTimeLimit(waitFor);
    LogPrinter.printLog("Session timeout is updated.");
  }

  @Test(priority = 13, enabled = true)
  public void testPortsPolicySetting() {
    String insecureId = Utilities.getEnvironmentProperties("insecureId");
    String deniedId = Utilities.getEnvironmentProperties("deniedId");
    String excludedId = Utilities.getEnvironmentProperties("excludedId");
    String allowedId = Utilities.getEnvironmentProperties("allowedId");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkPortsPolicySetting();
    globalSettingHelper.enterInsecurePortsId(insecureId);
    globalSettingHelper.enterExcludedPortsId(deniedId);
    globalSettingHelper.enterDeniedPortsId(excludedId);
    globalSettingHelper.enterAllowedPortsId(allowedId);
    LogPrinter.printLog("Ports policies are updated.");
  }

  @Test(priority = 14, enabled = true)
  public void testDeprecationDaysSetting() {
    String updateAssetDepDays = Utilities.getEnvironmentProperties("updateAssetDepDays");
    String updateAgentDepDays = Utilities.getEnvironmentProperties("updateAgentDepDays");
    String updateSuppressDays = Utilities.getEnvironmentProperties("updateSuppressDays");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkDeprecationDaysSetting();
    globalSettingHelper.enterAssetDeprecationDays(updateAssetDepDays);
    globalSettingHelper.enterAgentDeprecationDays(updateAgentDepDays);
    globalSettingHelper.enterMicrosoftSuppressDays(updateSuppressDays);
    LogPrinter.printLog("Deprecation days are updated,");
  }

  @Test(priority = 15, enabled = true)
  public void testWhiteLabelSetting() {
    String updatedTitle=Utilities.getEnvironmentProperties("updatedTitle");
    String updatedFooter =Utilities.getEnvironmentProperties("updatedFooter");
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
    String edrName = Utilities.getEnvironmentProperties("edrName");
    String year = Utilities.getEnvironmentProperties("year");
    String manufacture = Utilities.getEnvironmentProperties("manufacture");
    String description = Utilities.getEnvironmentProperties("description");
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
    String edrName=Utilities.getEnvironmentProperties("edrName");
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
    String complianceTypes = Utilities.getEnvironmentProperties("complianceTypes");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkComplianceScan();
    TimeUnit.SECONDS.sleep(5);
    globalSettingHelper.selectCheckBoxAsPreffered(complianceTypes);
    LogPrinter.printLog("All Settings done successfully.");
  }

  @Test(priority = 20, enabled = true)
  public void testBackupExcludeSetting() {
    String softwareName =Utilities.getEnvironmentProperties("softwareName");
    String year =Utilities.getEnvironmentProperties("year");
    String manufacture =Utilities.getEnvironmentProperties("manufacture");
    String description =Utilities.getEnvironmentProperties("description");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkBackupSoftwareSetting();
    globalSettingHelper.clickAddBackupSoftwareButton();
    globalSettingHelper.enterNameOfTheBackupApplication(softwareName);
    globalSettingHelper.enterYearOfSoftwareRelease(year);
    globalSettingHelper.enterSoftwareManufactureBy(manufacture);
    globalSettingHelper.enterSoftwareDescription(description);
    globalSettingHelper.clickSaveBackupButton();
    LogPrinter.printLog("Backup software is added successfully.");
  }

  @Test(priority = 21, enabled = true)
  public void testAddSoftwareToExcludeAndRemove() {
    String softwareName = Utilities.getEnvironmentProperties("softwareName");
    globalSettingHelper.enterSoftwareNameToAddInExclude(softwareName);
    globalSettingHelper.enterNameToRemoveExcludeSoftware(softwareName);
    LogPrinter.printLog("Backup applications settings are updated.");
  }

  @Test(priority = 22, enabled = true)
  public void testLwAgentScanSetting() {
    String timeLwIndex = Utilities.getEnvironmentProperties("timeLwIndex");
    globalSettingHelper.clickOnGlobalSettingLabel();
    globalSettingHelper.clickOnLinkAgentScan();
    globalSettingHelper.clickOnBoxSetTimeInterval();
    globalSettingHelper.selectTimeIntervalAsPreffered(timeLwIndex);
    globalSettingHelper.clickOnSetFromTimeBox();
  }
}
