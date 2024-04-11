package com.connectsecure.test.ui.connectsecure;

import com.base.helper.ui.connectsecure.DeleteCompanyHelper;
import com.base.utils.Utilities;
import com.base.utils.timeutils.TimeUtil;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.helper.ui.connectsecure.CreateCompanyHelper;
import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

public class TestCompaniesPage {

  LoginPageHelper loginPageHelper;
  CreateCompanyHelper createCompanyHelper;
  DeleteCompanyHelper deleteCompanyHelper;


  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    createCompanyHelper = new CreateCompanyHelper();
    deleteCompanyHelper = new DeleteCompanyHelper();

    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    LoginPageHelper.loginIntoTheApplication(tenantName, loginName, password);
  }

  @AfterMethod
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 0, enabled = true)
  public void testCreateCompanyFeatureIsWorking() throws InterruptedException {
    String companyName = "AutoComp " + TimeUtil.getCurrentTime();
    String description = "This company " + TimeUtil.getCurrentTime();
    String city = Utilities.getEnvironmentProperties("city");
    String state = Utilities.getEnvironmentProperties("state");
    String country = Utilities.getEnvironmentProperties("country");
    String zipCode = Utilities.getEnvironmentProperties("zipCode");
    createCompanyHelper.clickOnLabelCompanies();
    createCompanyHelper.selectNewCompany();
    createCompanyHelper.enterComapnyName(companyName);
    createCompanyHelper.enterDescriptionForCompany(description);
    createCompanyHelper.enterCityOfCompany(city);
    createCompanyHelper.enterStateOfCompany(state);
    createCompanyHelper.enterCountryOfCompany(country);
    createCompanyHelper.enterZipcodeOfTheCompany(zipCode);
    createCompanyHelper.clickOnSaveButton();
    TimeUnit.SECONDS.sleep(5);
    String createdCompanyName = createCompanyHelper.getCreatedCompanyName(companyName);
    Assert.assertTrue(createdCompanyName.equalsIgnoreCase(companyName));
    LogPrinter.printLog(createdCompanyName + "created.");
    LogPrinter.printLog("Company created successfully and create company feature is working fine.");
  }

  /**
   * For deleting the created company.
   */
  @Test(priority = 0, enabled = true)
  public void testDeleteCompanyFeatureIsWorkingFine() throws InterruptedException {
    String companyName = "AutoComp " + TimeUtil.getCurrentTime();
    String description = TimeUtil.getCurrentTime();
    String city = Utilities.getEnvironmentProperties("city");
    String state = Utilities.getEnvironmentProperties("state");
    String country = Utilities.getEnvironmentProperties("country");
    String zipCode = Utilities.getEnvironmentProperties("zipCode");
    createCompanyHelper.clickOnLabelCompanies();
    createCompanyHelper.selectNewCompany();
    createCompanyHelper.enterComapnyName(companyName);
    createCompanyHelper.enterDescriptionForCompany(description);
    createCompanyHelper.enterCityOfCompany(city);
    createCompanyHelper.enterStateOfCompany(state);
    createCompanyHelper.enterCountryOfCompany(country);
    createCompanyHelper.enterZipcodeOfTheCompany(zipCode);
    createCompanyHelper.clickOnSaveButton();
    TimeUnit.SECONDS.sleep(5);
    String createdCompanyName = createCompanyHelper.getCreatedCompanyName(companyName);
    Assert.assertTrue(createdCompanyName.equalsIgnoreCase(companyName));
    LogPrinter.printLog(createdCompanyName + " created.");
    LogPrinter.printLog("Company created successfully and create company feature is working fine.");
    String companyInput = Utilities.getEnvironmentProperties("companyInput");
    deleteCompanyHelper.clickOnSearchCompanyInput(companyInput);
    deleteCompanyHelper.clickOnLabelCompany();
    deleteCompanyHelper.clickOnDeleteCompanies();
    deleteCompanyHelper.clickOnSelectCompanyToDelete();
    deleteCompanyHelper.enterCompanyNameToDelete(companyName);
    deleteCompanyHelper.clickOnSearchedCompany(companyName);
    deleteCompanyHelper.clickOnDeleteButton();
    deleteCompanyHelper.clickOnDeleteButtonToConfirm();
    TimeUnit.SECONDS.sleep(5);
    LogPrinter.printLog("Selected company deleted successfully.");
    deleteCompanyHelper.clickOnLabelCompany();
    deleteCompanyHelper.clickOnDeleteCompanies();
    deleteCompanyHelper.clickOnSelectCompanyToDelete();
    deleteCompanyHelper.enterCompanyNameToDelete(companyName);
    Assert.assertTrue(deleteCompanyHelper.isNoMatchingFoundDisplayed());
    LogPrinter.printLog("Verified that company deleted successfully.");
  }

  /**
   * For deleting the existing company.
   */
  @Test(priority = 0, enabled = true)
  public void testDeleteCompanyAndVerify() {
    String companyName = Utilities.getEnvironmentProperties("companyName");
    deleteCompanyHelper.clickOnLabelCompany();
    deleteCompanyHelper.clickOnDeleteCompanies();
    deleteCompanyHelper.clickOnSelectCompanyToDelete();
    deleteCompanyHelper.enterCompanyNameToDelete(companyName);
    deleteCompanyHelper.clickOnSearchedCompany(companyName);
    deleteCompanyHelper.clickOnDeleteButton();
    deleteCompanyHelper.clickOnDeleteButtonToConfirm();
    LogPrinter.printLog("Selected company deleted successfully.");
    deleteCompanyHelper.clickOnLabelCompany();
    deleteCompanyHelper.clickOnDeleteCompanies();
    deleteCompanyHelper.clickOnSelectCompanyToDelete();
    deleteCompanyHelper.enterCompanyNameToDelete(companyName);
    Assert.assertTrue(deleteCompanyHelper.isNoMatchingFoundDisplayed());
    LogPrinter.printLog("Verified that company deleted successfully.");
  }
}
