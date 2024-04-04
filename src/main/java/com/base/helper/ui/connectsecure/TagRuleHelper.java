package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TagRuleHelper {

  /**
   * Constructor.
   */
  public TagRuleHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * Tag rules Settings.
   */

  @FindBy(xpath = "//span[contains(text(),'Tags')]")
  private WebElement lblTagSettings;

  @FindBy(xpath = "//button[@id='addbtnTag Rules']")
  private WebElement btnAddTagRules;

  @FindBy(xpath = "//input[@name='name']")
  private WebElement txtboxname;

  @FindBy(xpath = "//input[@name='Score']")
  private WebElement txtboxRiskScore;

  @FindBy(xpath = "//*[@name='Collection']")
  private WebElement txtboxCollection;

  @FindBy(xpath = "//textarea[@name='Description']")
  private WebElement txtboxDescription;

  @FindBy(xpath = "//*[@placeholder='Select a field']")
  private WebElement boxSelectField;

  @FindBy(xpath = "//input[@placeholder='Enter Value']")
  private WebElement txtboxEnterValue;

  @FindBy(xpath = "//input[@name='Tagname']")
  private WebElement txtboxTagName;

  @FindBy(xpath = "//input[@name='Value']")
  private WebElement txtboxTagValue;

  @FindBy(xpath = "//button[contains(text(),'Add')]")
  private WebElement btnAdd;

  @FindBy(xpath = "//div[6]/button/span[contains(text(),'Save')]")
  private WebElement btnSave;

  @FindBy(xpath = "//span[@id='Delete']")
  private WebElement btnActionDelete;

  @FindBy(xpath = "//span[contains(text(),'Yes')]")
  private WebElement btnYes;

  @FindBy(xpath = "//span[@id='Edit']")
  private WebElement btnActionEdit;

  @FindBy(xpath = "//mat-toolbar/div[2]/div/form/mat-form-field")
  private WebElement txtboxSearch;

  @FindBy(xpath = "//span[contains(text(),'DemoTag')]")
  private WebElement txtCreatedTag;

  public void clickOnLabelTags() {
    WebDriverFactory.clickWebElement(lblTagSettings);
  }

  public void clickOnButtonAddTagRules() {
    WebDriverFactory.clickWebElement(btnAddTagRules);
  }

  public void enterTagRuleName(String ruleName) {
    WebDriverFactory.sendKeys(txtboxname, ruleName);
  }

  public void enterTagRiskScore(String riskScore) {
    WebDriverFactory.sendKeys(txtboxRiskScore, riskScore);
  }

  public void clickOnCollectionBox() {
    WebDriverFactory.clickWebElement(txtboxCollection);
  }

  public void selectCollectionType(String collectionTypes) {
    WebDriverFactory.getDriver()
        .findElement(
            By.xpath("//*[@role='option']/span[contains(text(),'" + collectionTypes + "')]"))
        .click();
  }

  public void enterTagDescription(String tagDescription) {
    WebDriverFactory.sendKeys(txtboxDescription, tagDescription);
  }

  /*public void clickOnRulesField(String fieldvalue) {
    WebDriverFactory.clickWebElement(boxSelectField);
    WebDriverFactory.selectElementByVisibleText();
    WebDriverFactory.getDriver().findElement(By.xpath("//option[contains(text(),'Starts With ')]"))
        .click();
    WebDriverFactory.sendKeys(txtboxEnterValue, fieldvalue);
  }*/

  public void enterTagDetails(String tagName, String tagValue) {
    WebDriverFactory.sendKeys(txtboxTagName, tagName);
    WebDriverFactory.sendKeys(txtboxTagValue, tagValue);
    WebDriverFactory.clickWebElement(btnAdd, 5);
  }

  public void clickOnSaveButton() {
    WebDriverFactory.clickWebElement(btnSave);
  }

  public boolean isCreatedTagNameDisplayed(String ruleName) {
    WebDriverFactory.sendKeys(txtboxSearch, ruleName, 5);
    return WebDriverFactory.isElementVisible(txtCreatedTag, 5);
  }

  /**
   * Tag action checking.
   */
  public void clickOnTagActionDeleteButton(String tagIndex) {
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//tr[" + tagIndex + "]/td[5]/button[@id='btntags']")).click();
    WebDriverFactory.clickWebElement(btnActionDelete);
    WebDriverFactory.clickWebElement(btnYes, 5);
  }

  public void clickOnTagActionEditButton(String tagIndex1) {
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//tr[" + tagIndex1 + "]/td[5]/button[@id='btntags']")).click();
    WebDriverFactory.clickWebElement(btnActionEdit);
  }

  public void enterUpdateForTagRule(String updateName) {
    txtboxname.click();
    txtboxname.clear();
    WebDriverFactory.sendKeys(txtboxname, updateName);
    WebDriverFactory.clickWebElement(btnSave, 10);
  }
}
