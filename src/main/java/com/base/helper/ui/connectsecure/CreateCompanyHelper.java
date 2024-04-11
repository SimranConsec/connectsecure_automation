package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCompanyHelper {


  /**
   * Constructor.
   */
  public CreateCompanyHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * Launch the Web Application and navigate to the Company Label.
   *
   * @author apple
   */

  @FindBy(xpath = "//span[contains(text(),'Companies')]")
  private WebElement lblcompanies;

  @FindBy(xpath = "//span[contains(text(),'New Company')]")
  private WebElement optNewCompany;

  @FindBy(xpath = "//input[@id='name']")
  private WebElement txtboxCompanyname;

  @FindBy(xpath = "//textarea[@id='description']")
  private WebElement txtboxdescription;

  @FindBy(xpath = "//input[@id='adddress_city']")
  private WebElement txtboxcity;

  @FindBy(xpath = "//input[@id='adddress_state']")
  private WebElement txtboxState;

  @FindBy(xpath = "//input[@id='adddress_country']")
  private WebElement txtboxCountry;

  @FindBy(xpath = "//input[@id='adddress_zipcode']")
  private WebElement txtboxZipCode;

  @FindBy(xpath = "//button[@id='saveButton']")
  private WebElement btnSave;

  public void clickOnLabelCompanies() {
    WebDriverFactory.clickWebElement(lblcompanies);
  }

  public void selectNewCompany() {
    WebDriverFactory.clickWebElement(optNewCompany);
  }

  public void enterComapnyName(String nameOfCompany) {
    WebDriverFactory.sendKeys(txtboxCompanyname, nameOfCompany);
  }

  public void enterDescriptionForCompany(String descriptionOfCompany) {
    WebDriverFactory.sendKeys(txtboxdescription, descriptionOfCompany);
  }

  public void enterCityOfCompany(String city) {
    WebDriverFactory.sendKeys(txtboxcity, city);
  }

  public void enterStateOfCompany(String state) {
    WebDriverFactory.sendKeys(txtboxState, state);
    txtboxState.sendKeys(Keys.TAB);
  }

  public void enterCountryOfCompany(String country) {
    WebDriverFactory.sendKeys(txtboxCountry, country);
  }

  public void enterZipcodeOfTheCompany(String zipCode) {
    WebDriverFactory.sendKeys(txtboxZipCode, zipCode);
  }

  public void clickOnSaveButton() {
    WebDriverFactory.clickWebElement(btnSave);
  }

  public String getCreatedCompanyName(String companyName) {
    WebDriverFactory.waitForAnElementToBeVisible(
        "//div/span[contains(text(),'" + companyName + "')]", 10);
    return WebDriverFactory.getDriver()
        .findElement(By.xpath("//div/span[contains(text(),'" + companyName + "')]")).getText();
  }
}
