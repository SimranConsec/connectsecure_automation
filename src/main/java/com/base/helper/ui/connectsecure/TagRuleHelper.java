package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

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

  @FindBy(xpath = "//input[@id='tags_filter_sub']")
  private WebElement txtboxSearch;

  public void clickOnLabelTags() {
    WebDriverFactory.clickWebElement(lblTagSettings);
    WebDriverFactory.waitForPageToLoad(10);
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
    txtboxDescription.sendKeys(Keys.TAB);
  }

  @FindBy(xpath = "//div[@id='e-dropdown-btn_1-popup']")
  private WebElement dropdown;

  public void clickOnRulesField(String fieldValue, String dropValue) {
    WebDriverFactory.clickWebElement(boxSelectField, 5);
    WebDriverFactory.selectElementByVisibleText(dropdown, dropValue);
    WebDriverFactory.sendKeys(txtboxEnterValue, fieldValue);
  }

  public void enterTagDetails(String tagName, String tagValue) {
    WebDriverFactory.sendKeys(txtboxTagName, tagName);
    WebDriverFactory.sendKeys(txtboxTagValue, tagValue);
    WebDriverFactory.clickWebElement(btnAdd, 5);
    btnAdd.sendKeys(Keys.TAB);
  }

  public void clickOnSaveButton() {
    WebDriverFactory.clickWebElement(btnSave);
    WebDriverFactory.waitForAnElementToBeVisible("//div[contains(text(),'Saved successfully!')]",
        20);
  }

  @FindBy(xpath = "//div[contains(text(),'Items per page:')]")
  private WebElement lblPage;

  public boolean isCreatedTagNameDisplayed(String ruleName) {
    WebDriverFactory.refresh();
    WebDriverFactory.waitForAnElementToBeVisible(lblTagSettings, 20);
    WebDriverFactory.clickWebElement(lblTagSettings);
    WebDriverFactory.sendKeys(txtboxSearch, ruleName, 10);
    WebDriverFactory.waitForAnElementToBeVisible("//span[contains(text(),'\" + ruleName + \"')]",
        10);
    return WebDriverFactory.getDriver()
        .findElement(By.xpath("//span[contains(text(),'" + ruleName + "')]")).isDisplayed();
  }

  /**
   * Tag action checking.
   */
  public void clickOnTagActionDeleteButton(String ruleName)
      throws InterruptedException {
    TimeUnit.SECONDS.sleep(3);
    WebDriverFactory.sendKeys(txtboxSearch, ruleName);
    TimeUnit.SECONDS.sleep(3);
    WebDriverFactory.waitForAnElementToBeVisible("//span[contains(text(),'" + ruleName + "')]",
        10);
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//tr[1]/td[5]/button[@id='btntags']")).click();
  }

  public void clickOnButtonDelete() {
    WebDriverFactory.clickWebElement(btnActionDelete);
    WebDriverFactory.clickWebElement(btnYes);

  }

  public boolean isRemovedMessageDisplayed() {
    WebDriverFactory.waitForAnElementToBeVisible("//div[contains(text(),'Removed successfully')]",
        20);
    return WebDriverFactory.getDriver()
        .findElement(By.xpath("//div[contains(text(),'Removed successfully')]")).isDisplayed();
  }

  /**
   * Testing the tag edit button of exciting company.
   *
   * @throws InterruptedException
   */
  public void clickOnTagActionEditButton(String ruleName) throws InterruptedException {
    TimeUnit.SECONDS.sleep(3);
    WebDriverFactory.sendKeys(txtboxSearch, ruleName);
    TimeUnit.SECONDS.sleep(3);
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//tr[1]/td[5]/button[@id='btntags']")).click();
    WebDriverFactory.clickWebElement(btnActionEdit);
  }

  public void enterUpdateForTagRule(String updateName) {
    txtboxname.click();
    txtboxname.clear();
    WebDriverFactory.sendKeys(txtboxname, updateName);
    txtboxname.sendKeys(Keys.TAB);
  }

  public void clickOnButtonSaveUpdate() {
    WebDriverFactory.clickWebElement(btnSave, 10);
  }

  public boolean isSavedSuccessfullyMessageDisplayed() {
    WebDriverFactory.waitForAnElementToBeVisible("//div[contains(text(),'Saved successfully')]",
        20);
    return WebDriverFactory.getDriver()
        .findElement(By.xpath("//div[contains(text(),'Saved successfully')]")).isDisplayed();
  }
}
