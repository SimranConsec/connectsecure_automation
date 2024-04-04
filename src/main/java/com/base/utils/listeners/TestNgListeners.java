package com.base.utils.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.utils.LogPrinter;

public class TestNgListeners implements ITestListener, IRetryAnalyzer {

  private int retryCount = 0;
  private static final int maxRetryCount = 2;

  /**
   * This method will be executed before the main test start (@Test).
   */
  public void onStart(ITestContext context) {
    System.out.println("Automation Execution started");
  }

  /**
   * This method will be executed when a test case is pass or fail.
   */
  public void onTestStart(ITestResult result) {
    LogPrinter.printLog("Test Case Name:" + result.getName());
  }

  /**
   * This method will be executed when a test case is pass or fail.
   */
  public void onTestSuccess(ITestResult result) {
    LogPrinter.printLog(result.getName() + " method passed");
  }

  /**
   * This method will be executed when a test case is pass or fail.
   */
  public void onTestFailure(ITestResult result) {
    LogPrinter.printLog(result.getName() + " method failed");
    /*
     * WebDriverFactory.captureScreenShot(WebDriverFactory.getDriver(), result.getTestName() +
     * System.currentTimeMillis());
     */
  }

  /**
   * This method will be executed when a test case is pass or fail.
   */
  public void onTestSkipped(ITestResult result) {
    LogPrinter.printLog(result.getName() + " method skipped");
  }

  /**
   * This method will be executed when a test case is pass or fail.
   */
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // LogPrinter.printLog("Test Failed but within success percentage:" + result.getName());
  }

  /**
   * This method will be executed after the main test finish.
   */
  public void onFinish(ITestContext context) {
    LogPrinter.printLog("Automation Execution finished");
  }

  @Override
  public boolean retry(ITestResult result) {
    LogPrinter.printLog("Retry:" + retryCount);
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }

}
