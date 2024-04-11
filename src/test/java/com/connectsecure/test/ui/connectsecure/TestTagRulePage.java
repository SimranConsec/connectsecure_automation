package com.connectsecure.test.ui.connectsecure;

import com.base.utils.Utilities;
import com.base.utils.timeutils.TimeUtil;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.helper.ui.connectsecure.TagRuleHelper;
import com.base.utils.LogPrinter;
import com.base.utils.WebDriverFactory;

public class TestTagRulePage {

  LoginPageHelper loginPageHelper;
  TagRuleHelper tagRuleHelper;

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    tagRuleHelper = new TagRuleHelper();
    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    loginPageHelper.loginIntoTheApplication(tenantName, loginName, password);
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 0, enabled = true)
  public void testAddTagRuleIsWorkingFine() throws InterruptedException {
    String ruleName = "Tag" + TimeUtil.getCurrentTime();
    String riskScore = Utilities.getEnvironmentProperties("riskScore");
    String collectionTypes = Utilities.getEnvironmentProperties("collectionTypes");
    String tagDescription = Utilities.getEnvironmentProperties("tagDescription");
    String tagName = Utilities.getEnvironmentProperties("tagName");
    String tagValue = Utilities.getEnvironmentProperties("tagValue");
    String fieldValue = Utilities.getEnvironmentProperties("fieldValue");
    String dropValue = Utilities.getEnvironmentProperties("dropValue");
    tagRuleHelper.clickOnLabelTags();
    tagRuleHelper.clickOnButtonAddTagRules();
    tagRuleHelper.enterTagRuleName(ruleName);
    tagRuleHelper.enterTagRiskScore(riskScore);
    tagRuleHelper.clickOnCollectionBox();
    tagRuleHelper.selectCollectionType(collectionTypes);
    tagRuleHelper.enterTagDescription(tagDescription);
    tagRuleHelper.enterTagDetails(tagName, tagValue);
    tagRuleHelper.clickOnSaveButton();
    Assert.assertTrue(tagRuleHelper.isCreatedTagNameDisplayed(ruleName));
    LogPrinter.printLog("Tag is created and verified also.");
  }

  @Test(priority = 0, enabled = true)
  public void testTagActionDelete() throws InterruptedException {
    String ruleName = "New" + TimeUtil.getCurrentTime();
    String riskScore = Utilities.getEnvironmentProperties("riskScore");
    String collectionTypes = Utilities.getEnvironmentProperties("collectionTypes");
    String tagDescription = Utilities.getEnvironmentProperties("tagDescription");
    String tagName = Utilities.getEnvironmentProperties("tagName");
    String tagValue = Utilities.getEnvironmentProperties("tagValue");
    tagRuleHelper.clickOnLabelTags();
    tagRuleHelper.clickOnButtonAddTagRules();
    tagRuleHelper.enterTagRuleName(ruleName);
    tagRuleHelper.enterTagRiskScore(riskScore);
    tagRuleHelper.clickOnCollectionBox();
    tagRuleHelper.selectCollectionType(collectionTypes);
    tagRuleHelper.enterTagDescription(tagDescription);
    tagRuleHelper.enterTagDetails(tagName, tagValue);
    tagRuleHelper.clickOnSaveButton();
    Assert.assertTrue(tagRuleHelper.isCreatedTagNameDisplayed(ruleName));
    LogPrinter.printLog("Tag created successfully.");
    tagRuleHelper.clickOnLabelTags();
    tagRuleHelper.clickOnTagActionDeleteButton(ruleName);
    tagRuleHelper.clickOnButtonDelete();
    Assert.assertTrue(tagRuleHelper.isRemovedMessageDisplayed());
    LogPrinter.printLog("Tag action delete executed successfully.");
  }

  @Test(priority = 0, enabled = true)
  public void testTagActionEdit() throws InterruptedException {
    String companyName = Utilities.getEnvironmentProperties("companyName");
    String updateName = "Updated" + TimeUtil.getCurrentTime();
    tagRuleHelper.clickOnLabelTags();
    WebDriverFactory.waitForPageToLoad(10);
    tagRuleHelper.clickOnTagActionEditButton(companyName);
    tagRuleHelper.enterUpdateForTagRule(updateName);
    tagRuleHelper.clickOnButtonSaveUpdate();
    Assert.assertTrue(tagRuleHelper.isSavedSuccessfullyMessageDisplayed());
    LogPrinter.printLog("Tag action edited executed successfully.");
  }
}
