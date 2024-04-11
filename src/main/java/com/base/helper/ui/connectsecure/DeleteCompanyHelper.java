package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteCompanyHelper {

  /**
   * Constructor.
   */
  public DeleteCompanyHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * first create company and then delete the created company to verify that whether company deleted
   * or not.
   */

  @FindBy(xpath = "//span[contains(text(),'Companies')]")
  private WebElement lblCompanies;

  @FindBy(xpath = "//span[contains(text(),'Delete Companies')]")
  private WebElement optDeleteCompanies;

  @FindBy(xpath = "//*[@id='id']")
  private WebElement clickOnSelectCompany;

  @FindBy(xpath = "//input[@placeholder='Select Company']")
  private WebElement txtboxSearchCompany;

  @FindBy(xpath = "//button[@id='saveButton']")
  private WebElement btnDelete;

  @FindBy(xpath = "//button[2]/span[2][@class='mdc-button__label'][contains(text(),'Delete')]")
  private WebElement btnConfirmDelete;

  public void clickOnLabelCompany() {
    WebDriverFactory.clickWebElement(lblCompanies);
  }

  public void clickOnDeleteCompanies() {
    WebDriverFactory.clickWebElement(optDeleteCompanies);
  }

  public void clickOnSelectCompanyToDelete() {
    WebDriverFactory.clickWebElement(clickOnSelectCompany);
  }

  public void enterCompanyNameToDelete(String companyName) {
    WebDriverFactory.sendKeys(txtboxSearchCompany, companyName, 5);
  }

  public void clickOnSearchedCompany(String companyName) {
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//span[contains(text(),'" + companyName + "')]")).click();
  }

  public void clickOnDeleteButton() {
    WebDriverFactory.clickWebElement(btnDelete);
  }

  public void clickOnDeleteButtonToConfirm() {
    WebDriverFactory.clickWebElement(btnConfirmDelete, 10);
    WebDriverFactory.waitForPageToLoad(10);
  }

  /**
   * Going back to the dashboard level to delete company. Steps include that go to search bar and
   * goto Global dashboard and then delete your company.
   */

  @FindBy(xpath = "//mat-select[@id='sSearchCompanyInput']")
  private WebElement boxSearchCompanyInput;

  @FindBy(xpath = "//input[@placeholder='Search Company']")
  private WebElement txtboxEnterCompanyInput;

  @FindBy(xpath = "//mat-option/span[contains(text(),'Global')]")
  private WebElement optGlobal;

  public void clickOnSearchCompanyInput(String companyInput) {
    WebDriverFactory.clickWebElement(boxSearchCompanyInput);
    WebDriverFactory.sendKeys(txtboxEnterCompanyInput, companyInput, 10);
    WebDriverFactory.clickWebElement(optGlobal, 10);
  }

  public boolean isNoMatchingFoundDisplayed() {
    return WebDriverFactory.getDriver()
        .findElement(By.xpath("//div[contains(text(),'No matching found')]")).isDisplayed();
  }
}
