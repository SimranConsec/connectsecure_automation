package com.connectsecure.test.ui.connectsecure;

import com.base.utils.Utilities;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.helper.ui.connectsecure.CreateCompanyHelper;
import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

public class TestCreateCompanyPage {

  LoginPageHelper loginPageHelper;
  CreateCompanyHelper createCompanyHelper;

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    createCompanyHelper = new CreateCompanyHelper();
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 2, enabled = true)
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

  @Test(priority = 3, enabled = true)
  public void testCreateCompany() throws InterruptedException {
    String nameOfCompany = Utilities.getEnvironmentProperties("nameOfCompany");
    String descriptionOfCompany = Utilities.getEnvironmentProperties("descriptionOfCompany");
    String city = Utilities.getEnvironmentProperties("city");
    String state = Utilities.getEnvironmentProperties("state");
    String country = Utilities.getEnvironmentProperties("country");
    String zipCode = Utilities.getEnvironmentProperties("zipCode");
    createCompanyHelper.clickOnLabelCompanies();
    createCompanyHelper.selectNewCompany();
    createCompanyHelper.enterComapnyName(nameOfCompany);
    createCompanyHelper.enterDescriptionForCompany(descriptionOfCompany);
    createCompanyHelper.enterCityOfCompany(city);
    createCompanyHelper.enterStateOfCompany(state);
    createCompanyHelper.enterCountryOfCompany(country);
    createCompanyHelper.enterZipcodeOfTheCompany(zipCode);
    createCompanyHelper.clickOnSaveButton();
    TimeUnit.SECONDS.sleep(5);
    Assert.assertTrue(createCompanyHelper.isCreatedCompanyNameDisplayed(nameOfCompany));
    LogPrinter.printLog("Company created successfully and checked also.");
  }
}
