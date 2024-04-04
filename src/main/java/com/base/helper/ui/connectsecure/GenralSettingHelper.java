package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenralSettingHelper {

  /**
   * Constructor.
   */
  public GenralSettingHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * Test genral setting on dashboard level.
   * 
   * @author apple
   */

  @FindBy(xpath = "//languages/button/span[@class='mat-mdc-button-touch-target']")
  private WebElement imgLanguages;

  @FindBy(xpath = "//app-theme-switch/button/span[@class='mat-mdc-button-touch-target']")
  private WebElement btnToggle;

  public void clickOnLaungaugeImage() {
    WebDriverFactory.clickWebElement(imgLanguages, 5);
  }

  public void clickOnLaunguageAsPreffered(String launguage) {
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//span[contains(text(),'" + launguage + "')]")).click();
  }

  public void clickOnToggleButtonForDarkMode() {
    WebDriverFactory.clickWebElement(btnToggle);
  }
}
