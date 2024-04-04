package com.connectsecure.test.api.reqres;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.base.helper.api.reqres.ReqResBeans;
import com.base.helper.api.reqres.ReqResHelper;
import com.base.utils.LogPrinter;
import com.base.utils.fileutils.FileUtil;
import com.base.utils.listeners.TestNgListeners;


public class TestReqRes {

  @Test(priority = 1, enabled = false)
  public void test_get_user_details_api() throws JSONException {
    JSONObject getUserDetailsApiRes = ReqResHelper.getUserDetails();
    LogPrinter.printLog("The user details are: " + getUserDetailsApiRes.toString());
    Assert.assertTrue(getUserDetailsApiRes.getInt("per_page") == 6);
    Assert.assertTrue(getUserDetailsApiRes.getInt("total") == 12);
    int dataArrLen = getUserDetailsApiRes.getJSONArray("data").length();
    JSONArray dataJsonArr = getUserDetailsApiRes.getJSONArray("data");
    for (int i = 0; i < dataArrLen; i++) {
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("id") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("email") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("first_name") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("last_name") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("avatar") != null);
    }
    Reporter.log("The user details are correct");
  }

  @Test(priority = 1, enabled = false, retryAnalyzer = TestNgListeners.class)
  public void test_create_user_api() throws JSONException, IOException {
    ReqResBeans.set_user_name("Test");
    ReqResBeans.set_user_role("Tester");
    JSONObject create_user_payload = FileUtil.readJsonFile("createuser.json");
    JSONObject response = ReqResHelper.create_user(create_user_payload);
    Assert.assertEquals(response.get("name"), ReqResBeans.get_user_name());
  }

  @Test(priority = 1, enabled = true)
  public void test_update_user() throws JSONException, IOException {
    ReqResBeans.set_user_name("Test");
    ReqResBeans.set_user_role("Tester");
    JSONObject create_user_payload = FileUtil.readJsonFile("createuser.json");
    JSONObject response = ReqResHelper.update_user(create_user_payload);
    Assert.assertEquals(response.get("name"), ReqResBeans.get_user_name());
    Assert.assertEquals(response.get("job"), ReqResBeans.get_user_role());
  }

  @AfterClass
  public static void endTest() {}

}
