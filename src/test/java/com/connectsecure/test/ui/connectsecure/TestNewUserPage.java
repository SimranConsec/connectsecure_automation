package com.connectsecure.test.ui.connectsecure;

import com.base.utils.Utilities;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.CreateNewUserHelper;
import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

public class TestNewUserPage {

  LoginPageHelper loginPageHelper;
  CreateNewUserHelper createNewUserHelper;

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
    loginPageHelper = new LoginPageHelper();
    createNewUserHelper = new CreateNewUserHelper();
    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    loginPageHelper.loginIntoTheApplication(tenantName, loginName, password);
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  //For Allowed companies.
  @Test(priority = 0, enabled = true)
  public void testAddNewUserRecordForAllowedCompany() throws InterruptedException {
    String firstName = Utilities.getEnvironmentProperties("firstName");
    String lastName = Utilities.getEnvironmentProperties("lastName");
    String email = Utilities.getEnvironmentProperties("email");
    String number = Utilities.getEnvironmentProperties("number");
    String nameOfCompany = Utilities.getEnvironmentProperties("nameOfCompany");
    String role = Utilities.getEnvironmentProperties("role");
    createNewUserHelper.clickOnLabelUsers();
    createNewUserHelper.clickOnLinkUserManagement();
    createNewUserHelper.clickOnAddUserButton();
    createNewUserHelper.enterUserDetails(firstName, lastName, email, number);
    createNewUserHelper.clickOnRoleSelectBox();
    createNewUserHelper.selectRoleAsPreferred(role);
    createNewUserHelper.clickOnAllowedCompanies();
    createNewUserHelper.selectAllowedCompany(nameOfCompany);
    createNewUserHelper.clickOnButtonSave();
    TimeUnit.SECONDS.sleep(10);
    String name = createNewUserHelper.getFirstName(firstName);
    Assert.assertTrue(name.equals(firstName));
    System.out.println(name);
    LogPrinter.printLog(
        "User created successfully and an email sent to the respective mail for the verification with a code.");
  }

  @Test(priority = 0, enabled = true)
  public void testAddNewUserRecordForDeniedCompany() throws InterruptedException {
    String firstName = Utilities.getEnvironmentProperties("firstName");
    String lastName = Utilities.getEnvironmentProperties("lastName");
    String email = Utilities.getEnvironmentProperties("email");
    String number = Utilities.getEnvironmentProperties("number");
    String nameOfCompany = Utilities.getEnvironmentProperties("nameOfCompany");
    String role = Utilities.getEnvironmentProperties("role");
    createNewUserHelper.clickOnLabelUsers();
    createNewUserHelper.clickOnLinkUserManagement();
    createNewUserHelper.clickOnAddUserButton();
    createNewUserHelper.enterUserDetails(firstName, lastName, email, number);
    createNewUserHelper.clickOnRoleSelectBox();
    createNewUserHelper.selectRoleAsPreferred(role);
    createNewUserHelper.clickOnCheckBoxDeniedCompanies();
    createNewUserHelper.selectDeniedCompany(nameOfCompany);
    String name = createNewUserHelper.getFirstName(firstName);
    Assert.assertTrue(name.equals(firstName));
    System.out.println(name);
    LogPrinter.printLog(
        "User created successfully and an email sent to the respective mail for the verification with a code.");
  }

  @Test(priority = 0, enabled = true)
  public void testActionUserButton() {
    String email = Utilities.getEnvironmentProperties("email");
    String role1 = Utilities.getEnvironmentProperties("role1");
    String nameOfCompany = Utilities.getEnvironmentProperties("nameOfCompany");
    String companiesLevel = Utilities.getEnvironmentProperties("companiesLevel");
    createNewUserHelper.clickOnLabelUsers();
    createNewUserHelper.clickOnLinkUserManagement();
    createNewUserHelper.enterTextToSearchUserForTakingAction(email);
    createNewUserHelper.clickOnActionEdit();
    createNewUserHelper.enterDataToUpdate(role1, nameOfCompany, companiesLevel);
    createNewUserHelper.clickButtonUpdate();
    LogPrinter.printLog("Edited.");
  }

  @Test(priority = 0,enabled = true)
  public void testUserActionMfa(){
    String email= Utilities.getEnvironmentProperties("email");
    createNewUserHelper.clickOnLabelUsers();
    createNewUserHelper.clickOnLinkUserManagement();
    createNewUserHelper.enterTextToSearchUserForTakingAction(email);
    createNewUserHelper.clickOnActionResetMfa();
    createNewUserHelper.clickOnButtonYesToConfirm();
  }
}
