package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.Alert;
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
   * Test delete company.
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

  public void enterCompanyNameToDelete(String deleteCompany) {
    WebDriverFactory.sendKeys(txtboxSearchCompany, deleteCompany, 5);
  }

  public void clickOnSearchedCompany(String deleteCompany) {
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//span[contains(text(),'" + deleteCompany + "')]")).click();
  }

  public void clickOnDeleteButton() {
    WebDriverFactory.clickWebElement(btnDelete);
  }

  public void clickOnDeleteButtonToConfirm() {
    WebDriverFactory.clickWebElement(btnConfirmDelete, 10);
  }

  /**
   * For checking that company deleted or not.
   */

  /*public void getPopUpMessage() {
    if (popup.isDisplayed()) {
      // Handle the popup or assert its content
      System.out.println("Popup appeared.");
    } else {
      System.out.println("Popup did not appear.");
    }
  }*/
}
