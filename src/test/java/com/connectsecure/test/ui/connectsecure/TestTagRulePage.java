package com.connectsecure.test.ui.connectsecure;

import com.base.utils.Utilities;
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

  String updateName = "TagDemo";

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    tagRuleHelper = new TagRuleHelper();
  }

  @AfterClass
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 23, enabled = true)
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

  @Test(priority = 24, enabled = true)
  public void testAddTagRule() throws InterruptedException {
    String ruleName = Utilities.getEnvironmentProperties("ruleName");
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
    TimeUnit.SECONDS.sleep(5);
    Assert.assertTrue(tagRuleHelper.isCreatedTagNameDisplayed(ruleName));
    LogPrinter.printLog("Created tag displayed and saved successfully.");
  }

  @Test(priority = 25, enabled = true)
  public void testTagActionDelete() throws InterruptedException {
    String tagIndex = Utilities.getEnvironmentProperties("tagIndex");
    tagRuleHelper.clickOnLabelTags();
    TimeUnit.SECONDS.sleep(5);
    tagRuleHelper.clickOnTagActionDeleteButton(tagIndex);
    LogPrinter.printLog("Tag action delete executed successfully.");
  }

  @Test(priority = 26, enabled = true)
  public void testTagActionEdit() throws InterruptedException {
    String tagIndex1 = Utilities.getEnvironmentProperties("tagIndex1");
    tagRuleHelper.clickOnLabelTags();
    TimeUnit.SECONDS.sleep(5);
    tagRuleHelper.clickOnTagActionEditButton(tagIndex1);
    tagRuleHelper.enterUpdateForTagRule(updateName);
    LogPrinter.printLog("Tag action edit executed successfully.");
  }
}
