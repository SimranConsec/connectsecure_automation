package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalSettingHelper {

  /**
   * Constructor.
   */
  public GlobalSettingHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * TimeZone Setting.
   *
   * @author apple
   */

  @FindBy(xpath = "//span[contains(text(),'Global Settings')]")
  private WebElement lblGlobalSettings;

  @FindBy(xpath = "//div[@id='timezone']")
  private WebElement lnkTimezoneSetting;

  @FindBy(xpath = "//mat-select[@id='Timezone']")
  private WebElement sltbarTimezone;

  @FindBy(xpath = "//*[@role='option']")
  private WebElement txtZone;

  @FindBy(xpath = "//button[1]/span[contains(text(),'Save')]")
  private WebElement btnSave;

  public void clickOnGlobalSettingLabel() {
    WebDriverFactory.clickWebElement(lblGlobalSettings, 30);
  }

  public void clickOnLinkTimeZoneSetting() {
    WebDriverFactory.clickWebElement(lnkTimezoneSetting);
  }

  public void clickOnSelectBarTimezone() {
    WebDriverFactory.clickWebElement(sltbarTimezone);
  }

  public void selectTheZonePreferred(String timeZoneIndex) {
    WebDriverFactory.getDriver().findElement(By.xpath("//*[@role='option'][" + timeZoneIndex + "]"))
        .click();
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  /**
   * Custom date format setting.
   */

  @FindBy(xpath = "//div[@id='dateformat']")
  private WebElement lnkCustomDateFormat;

  @FindBy(xpath = "//*[@placeholder='Choose Dateformat']")
  private WebElement sltbarDateFormat;

  public void clickOnLinkDateFormatSetting() {
    WebDriverFactory.clickWebElement(lnkCustomDateFormat);
  }

  public void clickOnSelectDateFormatBar() {
    WebDriverFactory.clickWebElement(sltbarDateFormat);

  }

  public void selectDateFormatAsPrefered(String index) {
    WebDriverFactory.getDriver().findElement(By.xpath("//*[@id='[object Object]'][" + index + "]"))
        .click();
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  /**
   * Session TimeOut Setting.
   */

  @FindBy(xpath = "//div[@id='sessiontimeout']")
  private WebElement lnkSessionTimeOut;

  @FindBy(xpath = "//input[@name='Idlefor']")
  private WebElement txtboxIdleFor;

  @FindBy(xpath = "//input[@name='Waitfor']")
  private WebElement txtboxWaitfor;

  public void clickOnLinkSessionTimeoutSetting() {
    WebDriverFactory.clickWebElement(lnkSessionTimeOut);
  }

  public void enterIdleForTimeLimit(String idleFor) {
    txtboxIdleFor.click();
    txtboxIdleFor.clear();
    WebDriverFactory.sendKeys(txtboxIdleFor, idleFor);
  }

  public void enterWaitforTimeLimit(String waitFor) {
    txtboxWaitfor.click();
    txtboxWaitfor.clear();
    WebDriverFactory.sendKeys(txtboxWaitfor, waitFor);
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  /**
   * Ports Policy Setting.
   */

  @FindBy(xpath = "//div[@id='port']")
  private WebElement lnkPortsPolicy;

  @FindBy(xpath = "//*[@placeholder='Insecure Ports']")
  private WebElement txtboxPortsInsecure;

  @FindBy(xpath = "//*[@placeholder='Denied Ports']")
  private WebElement txtboxPortsDenied;

  @FindBy(xpath = "//*[@placeholder='Excluded Ports']")
  private WebElement txtboxPortsExcluded;

  @FindBy(xpath = "//*[@placeholder='Allowed Ports']")
  private WebElement txtboxPortsAllowed;

  @FindBy(xpath = "//*[contains(text(),'cancel')]")
  private WebElement btnCancelPorts;

  public void clickOnLinkPortsPolicySetting() {
    WebDriverFactory.clickWebElement(lnkPortsPolicy);
  }

  // If There is any related ports then store it in a string and fetch using.
  // sendkeys else leave it null. if it is not null then update that.

  public void enterInsecurePortsId(String insecureId) {
    if (txtboxPortsInsecure == null) {
      WebDriverFactory.sendKeys(txtboxPortsInsecure, insecureId);
    } else {
      WebDriverFactory.clickWebElement(btnCancelPorts);
      WebDriverFactory.sendKeys(txtboxPortsInsecure, insecureId);
    }
  }

  public void enterDeniedPortsId(String deniedId) {
    if (txtboxPortsDenied == null) {
      WebDriverFactory.sendKeys(txtboxPortsDenied, deniedId);
    } else {
      WebDriverFactory.clickWebElement(btnCancelPorts);
      WebDriverFactory.sendKeys(txtboxPortsDenied, deniedId);
    }
  }

  public void enterExcludedPortsId(String excludedId) {
    if (txtboxPortsExcluded == null) {
      WebDriverFactory.sendKeys(txtboxPortsExcluded, excludedId);
    } else {
      WebDriverFactory.clickWebElement(btnCancelPorts);
      WebDriverFactory.sendKeys(txtboxPortsExcluded, excludedId);
    }
  }

  public void enterAllowedPortsId(String allowedId) {
    if (txtboxPortsAllowed == null) {
      WebDriverFactory.sendKeys(txtboxPortsAllowed, allowedId);
    } else {
      WebDriverFactory.clickWebElement(btnCancelPorts);
      WebDriverFactory.sendKeys(txtboxPortsAllowed, allowedId);
    }
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  /**
   * Deprecation days setting(You can still use this, but don't count on it, because we will.
   * probably replace it with something else (or remove it entirely) in future software releases."
   * update days as per need,if not needed then leave it as set previously.
   */

  @FindBy(xpath = "//div[@id='deprecation']")
  private WebElement lnkDeprecationdays;

  @FindBy(xpath = "//input[@id='_asset_deprecation_days']")
  private WebElement txtboxAssetDepcretionDays;

  @FindBy(xpath = "//input[@id='_agent_deprecation_days']")
  private WebElement txtboxAgentDeprecationDays;

  @FindBy(xpath = "//input[@id='_microsoft_suppress_days']")
  private WebElement txtboxSuppressDays;

  public void clickOnLinkDeprecationDaysSetting() {
    WebDriverFactory.clickWebElement(lnkDeprecationdays);
  }

  public void enterAssetDeprecationDays(String updateAssetDepDays) {
    txtboxAssetDepcretionDays.click();
    txtboxAssetDepcretionDays.clear();
    WebDriverFactory.sendKeys(txtboxAssetDepcretionDays, updateAssetDepDays);
  }

  public void enterAgentDeprecationDays(String updateAgentDepDays) {
    txtboxAgentDeprecationDays.click();
    txtboxAgentDeprecationDays.clear();
    WebDriverFactory.sendKeys(txtboxAgentDeprecationDays, updateAgentDepDays);
  }

  public void enterMicrosoftSuppressDays(String updateSuppressDays) {
    txtboxSuppressDays.click();
    txtboxSuppressDays.clear();
    WebDriverFactory.sendKeys(txtboxSuppressDays, updateSuppressDays);
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  /**
   * White Label Settings(For the Page Title and the Footer content).
   */

  @FindBy(xpath = "//div[@id='whitelabel']")
  private WebElement lnkWhiteLabel;

  @FindBy(xpath = "//span[contains(text(),'Edit')]")
  private WebElement btnEdit;

  @FindBy(xpath = "//input[@placeholder='Enter Page Title']")
  private WebElement txtboxPageTitle;

  @FindBy(xpath = "//input[@placeholder='Enter Footer Content']")
  private WebElement txtboxFooter;

  @FindBy(xpath = "//label[@for='logo_dark']")
  private WebElement lgDarkMode;

  @FindBy(xpath = "//label[@for='icon_dark']")
  private WebElement icDarkMode;

  @FindBy(xpath = "//label[@for='logo']")
  private WebElement lgLightMode;

  @FindBy(xpath = "//label[@for='icon']")
  private WebElement icLightMode;

  public void clickOnLinkWhiteLabelSetting() {
    WebDriverFactory.clickWebElement(lnkWhiteLabel);
  }

  public void clickButtonEdittoUpdate() {
    WebDriverFactory.clickWebElement(btnEdit);
  }

  public void enterPageTitle(String updatedTitle) {
    txtboxPageTitle.click();
    txtboxPageTitle.clear();
    WebDriverFactory.sendKeys(txtboxPageTitle, updatedTitle);
  }

  public void enterFooter(String updatedFooter) {
    txtboxFooter.click();
    txtboxFooter.clear();
    WebDriverFactory.sendKeys(txtboxFooter, updatedFooter);
  }

  public void clickImageToUpdateLogoinDarkMode() {
    if (lgDarkMode == null) {
      lgDarkMode.click();
      WebDriverFactory.waitForPageToLoad(5);
      // After the page loaded choose the image you want to upload and save.
    } else { // if want to update then follow the above steps else leave as it is.
      System.out.println("Logo is Updated.");
    }
  }

  public void clickImageToUpdateIconinDarkMode() {
    if (icDarkMode == null) {
      icDarkMode.click();
      WebDriverFactory.waitForPageToLoad(5);
      // After the page loaded choose the image you want to upload and save.
    } else { // if want to update then follow the above steps else leave as it is.
      System.out.println("Icon is Updated.");
    }
  }

  public void clickImageToUpdateLogoinLightMode() {
    if (lgLightMode == null) {
      lgLightMode.click();
      WebDriverFactory.waitForPageToLoad(5);
    } else { // if want to update then follow the above steps else leave as it is.
      System.out.println("Logo is Updated.");
    }
  }

  public void clickImageToUpdateIconinLightMode() {
    if (icLightMode == null) {
      icLightMode.click();
      WebDriverFactory.waitForPageToLoad(5);
      // After the page loaded choose the image you want to upload and save.
    } else {
      System.out.println("Icon is Updated.");
    }
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  /**
   * Edr Application Settings(List of the Antivirus application) using Avast Software for demo.
   */

  @FindBy(xpath = "//div[@id='edrapplication']")
  private WebElement lblEdrApplication;

  @FindBy(xpath = "//span/mat-icon[@class='mat-icon notranslate icon-size-5 mat-icon-no-color']")
  private WebElement btnAddEdrApplication;

  @FindBy(xpath = "//input[@placeholder='Enter name']")
  private WebElement txtboxEnterName;

  @FindBy(xpath = "//input[@placeholder='Enter year of release']")
  private WebElement txtboxReleaseYear;

  @FindBy(xpath = "//input[@placeholder='Enter manufacturer']")
  private WebElement txtboxManufacture;

  @FindBy(xpath = "//input[@placeholder='Enter description']")
  private WebElement txtboxDescription;

  @FindBy(xpath = "//input[@id='edrRegex-input']")
  private WebElement chkboxRegex;

  @FindBy(xpath = "//div/div[2]/button[2]/span[2][contains(text(),'Save')]")
  private WebElement btnSaveEdr;

  @FindBy(xpath = "//input[@name='globalSearch']")
  private WebElement txtboxSearchForAntivirusName;

  @FindBy(xpath = "//input[@name='exSearch']")
  private WebElement txtboxSerachForExcludingVirus;

  @FindBy(xpath = "//mat-icon[contains(text(),'arrow_forward')]")
  private WebElement btnArrow;

  @FindBy(xpath = "//span[contains(text(),'Yes')]")
  private WebElement btnYes;

  @FindBy(xpath = "//mat-icon[contains(text(),'cancel')]")
  private WebElement btnCancel;

  @FindBy(xpath = "//span[contains(text(),'No')]")
  private WebElement btnNo;

  public void clickOnEdrApplicationLabelSetting() {
    WebDriverFactory.clickWebElement(lblEdrApplication);
  }

  public void clickAddEdrApplicationButton() {
    WebDriverFactory.clickWebElement(btnAddEdrApplication);
  }

  public void enterNameOfTheAntiVirusApplication(String edrName) {
    WebDriverFactory.sendKeys(txtboxEnterName, edrName);
  }

  public void enterYearOfRelease(String year) {
    WebDriverFactory.sendKeys(txtboxReleaseYear, year);
  }

  public void enterManufactureBy(String manufacture) {
    WebDriverFactory.sendKeys(txtboxManufacture, manufacture);
  }

  public void enterDescription(String description) {
    WebDriverFactory.sendKeys(txtboxDescription, description);
  }

  public void clickCheckboxRegex() {
    chkboxRegex.click(); // If needed then enable otherwise don't call.
  }

  public void clickSaveEdrButton() {
    WebDriverFactory.clickWebElement(btnSaveEdr, 10);
  }

  public void enterNameToSearch(String edrName) {
    WebDriverFactory.sendKeys(txtboxSearchForAntivirusName, edrName);
  }

  public void clickOnArrowButton() { // For Excluding the application.
    WebDriverFactory.clickWebElement(btnArrow);
    WebDriverFactory.clickWebElement(btnYes, 5);
  }

  public void enterNameToExcludeVirus(String edrName) {
    WebDriverFactory.sendKeys(txtboxSerachForExcludingVirus, edrName);
  }

  public void clickOnArrowExclude() {
    WebDriverFactory.clickWebElement(btnCancel);
    WebDriverFactory.clickWebElement(btnYes, 10);
  }

  /**
   * Compliance Scan Setting.
   */

  @FindBy(xpath = "//div[@id='compliancescan']")
  private WebElement lnkComplianceScan;

  public void clickOnLinkComplianceScan() {
    WebDriverFactory.clickWebElement(lnkComplianceScan);
  }

  public void selectCheckBoxAsPreffered(String complianceTypes) {
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//label[contains(text(),'" + complianceTypes + "')]")).click();
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  /**
   * Backup software settings(List of the Antivirus application) using Avast Software for demo.
   */

  @FindBy(xpath = "//div[@id='backupSoftware']")
  private WebElement lblBackipsoftware;

  @FindBy(xpath = "//span/mat-icon[@class='mat-icon notranslate icon-size-5 mat-icon-no-color']")
  private WebElement btnAddBackupSoftware;

  @FindBy(xpath = "//div/div[2]/button[2]/span[2][contains(text(),'Save')]")
  private WebElement btnSaveSoftware;

  @FindBy(xpath = "//input[@name='globalSearch']")
  private WebElement txtboxSearchForSofwareName;

  @FindBy(xpath = "//input[@name='exSearch']")
  private WebElement txtboxSerachForExcludingSoftware;

  public void clickOnLinkBackupSoftwareSetting() {
    WebDriverFactory.clickWebElement(lblBackipsoftware);
  }

  public void clickAddBackupSoftwareButton() {
    WebDriverFactory.clickWebElement(btnAddBackupSoftware, 10);
  }

  public void enterNameOfTheBackupApplication(String softwareName) {
    WebDriverFactory.sendKeys(txtboxEnterName, softwareName);
  }

  public void enterYearOfSoftwareRelease(String year) {
    WebDriverFactory.sendKeys(txtboxReleaseYear, year);
  }

  public void enterSoftwareManufactureBy(String manufacture) {
    WebDriverFactory.sendKeys(txtboxManufacture, manufacture);
  }

  public void enterSoftwareDescription(String description) {
    WebDriverFactory.sendKeys(txtboxDescription, description);
  }

  public void clickboxRegex() {
    chkboxRegex.click(); // If needed then enable otherwise don't call.
  }

  public void clickSaveBackupButton() {
    WebDriverFactory.clickWebElement(btnSaveSoftware, 10);
  }

  public void enterSoftwareNameToAddInExclude(String softwareName) {
    WebDriverFactory.sendKeys(txtboxSearchForSofwareName, softwareName);
    WebDriverFactory.clickWebElement(btnArrow);
    WebDriverFactory.clickWebElement(btnYes, 5);
  }

  public void enterNameToRemoveExcludeSoftware(String softwareName) {
    WebDriverFactory.sendKeys(txtboxSerachForExcludingSoftware, softwareName);
    WebDriverFactory.clickWebElement(btnCancel);
    WebDriverFactory.clickWebElement(btnYes, 10);
  }

  @FindBy(xpath = "//div[contains(text(),'LW Agent Scan Interval')]")
  private WebElement lnkAgentScan;

  @FindBy(xpath = "//*[@placeholder='Choose Interval']")
  private WebElement boxTimeInterval;

  @FindBy(xpath = "//input[@name='form_time']")
  private WebElement boxSetFromTime;

  @FindBy(xpath = "//input[@name='to_time']")
  private WebElement boxSetToTime;

  public void clickOnLinkAgentScan() {
    WebDriverFactory.clickWebElement(lnkAgentScan);
  }

  public void clickOnBoxSetTimeInterval() {
    WebDriverFactory.clickWebElement(boxTimeInterval);
  }

  public void selectTimeIntervalAsPreffered(String timeIndex) {
    WebDriverFactory.getDriver().findElement(By.xpath("//*[@role='option'][" + timeIndex + "]"))
        .click(); // By default, the LWA will scan every 15 minutes if not changed.
  }

  public void clickOnSetFromTimeBox() {
    WebDriverFactory.clickWebElement(boxSetFromTime);
    WebDriverFactory.clickWebElement(btnSave);
  }
}
