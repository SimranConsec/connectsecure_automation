package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUserHelper {

  /**
   * Constructor.
   */
  public CreateNewUserHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * Create new user Setting.
   */

  @FindBy(xpath = "//span[contains(text(),'Users')]")
  private WebElement lblUsersSettings;

  @FindBy(xpath = "//span[contains(text(),'User Management')]")
  private WebElement lnkUserManagement;

  @FindBy(xpath = "//span[contains(text(),'Add')]")
  private WebElement btnAddUsers;

  @FindBy(xpath = "//input[@placeholder='First Name']")
  private WebElement txtboxEnterFirstName;

  @FindBy(xpath = "//input[@placeholder='Last Name']")
  private WebElement txtboxEnterLastName;

  @FindBy(xpath = "//input[@placeholder='Email']")
  private WebElement txtboxEnterEmail;

  @FindBy(xpath = "//input[@placeholder='Phone Number']")
  private WebElement txtboxEnterNumber;

  @FindBy(xpath = "//div[2]/mat-form-field/div/div/div/mat-select[@placeholder='choose roles']")
  private WebElement boxRoleSelect;

  @FindBy(xpath = "//span[contains(text(),'Company level access')]")
  private WebElement lblLevelAccess;

  @FindBy(xpath = "//div[4]/button/span[contains(text(),'Save')]")
  private WebElement btnSave;

  public void clickOnLabelUsers() {
    WebDriverFactory.clickWebElement(lblUsersSettings);
  }

  public void clickOnLinkUserManagement() {
    WebDriverFactory.clickWebElement(lnkUserManagement);
  }

  public void clickOnAddUserButton() {
    WebDriverFactory.clickWebElement(btnAddUsers);
  }

  public void enterUserDetails(String firstName, String lastName, String email, String number) {
    WebDriverFactory.sendKeys(txtboxEnterFirstName, firstName);
    WebDriverFactory.sendKeys(txtboxEnterLastName, lastName);
    WebDriverFactory.sendKeys(txtboxEnterEmail, email);
    WebDriverFactory.sendKeys(txtboxEnterNumber, number);
  }

  public void clickOnRoleSelectBox() {
    WebDriverFactory.clickWebElement(boxRoleSelect);
  }

  public void selectRoleAsPreferred(String role) {
    WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'" + role + "')]"))
        .click();
    WebDriverFactory.clickWebElement(lblLevelAccess);
  }

  /**
   * For Level access as allowed company.
   */

  @FindBy(xpath = "//label[contains(text(),'Allowed Companies')]")
  private WebElement chkboxAllowedCompanies;

  @FindBy(xpath = "//mat-option[@role='option']/span[contains(text(),'All Companies')]")
  private WebElement chkboxAllCompanies;

  @FindBy(xpath = "//mat-select[@id='IncCmp']")
  private WebElement boxChooseCompany;

  public void clickOnAllowedCompanies() {
    WebDriverFactory.clickWebElement(chkboxAllowedCompanies, 5);
  }

  public void selectAllowedCompany(String nameOfCompany) {
    WebDriverFactory.clickWebElement(boxChooseCompany);
    WebDriverFactory.clickWebElement(chkboxAllCompanies, 5);
    WebDriverFactory.getDriver()
        .findElement(
            By.xpath("//mat-option[@role='option']/span[contains(text(),'" + nameOfCompany + "')]"))
        .click();
  }

  public void clickOnButtonSave() {
    WebDriverFactory.clickWebElement(btnSave);
  }

  /**
   * For level access as denied companies.
   */
  @FindBy(xpath = "//label[contains(text(),'Denied Companies')]")
  private WebElement chkboxDeniedCompanies;

  public void clickOnCheckBoxDeniedCompanies() {
    WebDriverFactory.clickWebElement(chkboxDeniedCompanies, 5);
  }

  public void selectDeniedCompany(String nameOfCompany) {
    WebDriverFactory.clickWebElement(boxChooseCompany, 5);
    WebDriverFactory.getDriver().findElement(
            By.xpath("//mat-option[@role='option']/span[contains(text(),'" + nameOfCompany + "')]"))
        .click();
    WebDriverFactory.clickWebElement(btnSave, 5);
  }

  /**
   * For verifying that user created or not.
   */
  public String getFirstName(String firstName) {
    return WebDriverFactory.getDriver()
        .findElement(By.xpath("//span[contains(text(),'" + firstName + "')]")).getText();
  }

  /**
   * Verifying user action button. Action edit.
   */

  @FindBy(xpath = "//mat-toolbar/div/div/form/mat-form-field/div/div/div/input[@id='users']")
  private WebElement txtboxSearch;

  @FindBy(xpath = "//tr/td[8]/button[@id='btnusers']")
  private WebElement btnAction;

  @FindBy(xpath = "//span[@id='Edit User']")
  private WebElement btnEditUser;

  @FindBy(xpath = "//mat-select[@placeholder='choose roles']")
  private WebElement boxChooseRoles;

  @FindBy(xpath = "//mat-select[@id='IncCmp']")
  private WebElement boxSelectcompany;

  @FindBy(xpath = "//span[contains(text(),'Update')]")
  private WebElement btnUpdate;

  public void enterTextToSearchUserForTakingAction(String email) {
    WebDriverFactory.clickWebElement(txtboxSearch);
    WebDriverFactory.sendKeys(txtboxSearch, email);
  }

  public void clickOnActionEdit() {
    WebDriverFactory.clickWebElement(btnAction, 5);
    WebDriverFactory.clickWebElement(btnEditUser, 5);
  }


  public void enterDataToUpdate(String role1, String nameOfCompany, String companiesLevel) {
    WebDriverFactory.clickWebElement(boxChooseRoles);
    WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'" + role1 + "')]"))
        .click();
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//label[contains(text(),'" + companiesLevel + "')]")).click();
    WebDriverFactory.clickWebElement(boxSelectcompany);
    WebDriverFactory.getDriver().findElement(
            By.xpath("//mat-option[@role='option']/span[contains(text(),'" + nameOfCompany + "')]"))
        .click();
  }

  public void clickButtonUpdate() {
    WebDriverFactory.clickWebElement(btnUpdate, 10);
  }

  /**
   * Reset Mfa action.
   */

  @FindBy(xpath = "//span[@id='Reset MFA']")
  private WebElement btnResetMfa;

  @FindBy(xpath = "//span[contains(text(),'Yes')]")
  private WebElement btnYes;

  public void clickOnActionResetMfa() {
    WebDriverFactory.clickWebElement(btnAction);
    WebDriverFactory.clickWebElement(btnResetMfa);
  }

  public void clickOnButtonYesToConfirm() {

    WebDriverFactory.clickWebElement(btnYes);
  }
}