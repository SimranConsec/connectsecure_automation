package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCompanyHelper {

  /**
   * Constructor.
   */
  public DeleteCompanyHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * Test delete company.
   * 
   * @author apple
   */

  @FindBy(xpath = "//span[contains(text(),'Companies')]")
  private WebElement lblcompanies;

  @FindBy(xpath = "//span[contains(text(),'Delete Companies')]")
  private WebElement optDeleteCompanies;

  @FindBy(xpath = "//*[@id='id']")
  private WebElement clickOnSelectCompany;

  @FindBy(xpath = "//input[@placeholder='Select Company']")
  private WebElement txtboxsearchcompany;

  @FindBy(xpath = "//button[@id='saveButton']")
  private WebElement btnDelete;

  @FindBy(xpath = "//button[2]/span[2][@class='mdc-button__label'][contains(text(),'Delete')]")
  private WebElement btnConfirmDelete;

  public void clickOnlabelCompany() {
    WebDriverFactory.clickWebElement(lblcompanies);
  }

  public void clickOnDeleteCompanies() {
    WebDriverFactory.clickWebElement(optDeleteCompanies);
  }

  public void clickOnSelectCompanytoDelete() {
    WebDriverFactory.clickWebElement(clickOnSelectCompany);
  }

  public void enterCompanyNameToDelete(String nameOfCompany) {
    WebDriverFactory.sendKeys(txtboxsearchcompany, nameOfCompany, 5);
  }

  public void clickOnSearchedCompany(String nameOfCompany) {
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//span[contains(text(),'" + nameOfCompany + "')]")).click();
  }

  public void clickOnDeleteButton() {
    WebDriverFactory.clickWebElement(btnDelete);
  }

  public void clickOnDeleteButtonToConfirm() {
    WebDriverFactory.clickWebElement(btnConfirmDelete, 10);
  }
}
