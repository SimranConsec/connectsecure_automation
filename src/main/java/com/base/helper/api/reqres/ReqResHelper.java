package com.base.helper.api.reqres;

import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;

import com.base.utils.Utilities;

import io.restassured.response.Response;

public class ReqResHelper {

  private static Response response = null;
  private static String errorMessage = null;

  /**
   * Get the user details.
   * 
   * @return - user details in JSON format.
   * @throws JSONException - JSON exception.
   * @author simran.kumari
   */
  public static JSONObject getUserDetails() throws JSONException {
    String apiUrl = Utilities.getEnvironmentProperties("reqResBaseUrl") + "/api/users";
    response = given().when().relaxedHTTPSValidation().header("Content-Type", "application/json")
        .basePath("/api/users").queryParam("page", "2").get(apiUrl);
    if (response.statusCode() != 200) {
      errorMessage = response.then().extract().asString();
      throw new JSONException("Service to get uder details is not working " + errorMessage);
    } else {
      System.out.println("Get user details APIs is working fine.");
    }
    JSONObject getUserDetailsJson = new JSONObject(response.asString());
    return getUserDetailsJson;
  }

  /**
   * Create an user.
   * 
   * @param payload - payload to create an user.
   * @return - user details in JSON format.
   * @author simran.kumari
   */
  public static JSONObject create_user(JSONObject payload) {
    payload.put("name", ReqResBeans.get_user_name());
    payload.put("job", ReqResBeans.get_user_role());
    String apiUrl = Utilities.getEnvironmentProperties("reqResBaseUrl") + "/api/users";
    response = given().when().header("Content-Type", "application/json").basePath("/api/users")
        .body(payload.toString()).post(apiUrl);
    if (response.statusCode() != 201) {
      errorMessage = response.then().extract().asString();
      throw new JSONException("Service to create an user is not working " + errorMessage);
    } else {
      System.out.println("Create user APIs is working fine.");
    }
    JSONObject userCreatedResponse = new JSONObject(response.asString());
    return userCreatedResponse;
  }

  /**
   * Update an user.
   *
   * @param payload - payload to update an user.
   * @return - user details in JSON format.
   * @author - simran.kumari
   */
  public static JSONObject update_user(JSONObject payload) {
    payload.put("name", ReqResBeans.get_user_name());
    payload.put("job", ReqResBeans.get_user_role());
    String apiUrl = Utilities.getEnvironmentProperties("reqResBaseUrl") + "/api/users/2";
    response = given().when().header("Content-Type", "application/json").basePath("/api/users/2")
        .body(payload.toString()).put(apiUrl);
    if (response.statusCode() != 200) {
      errorMessage = response.then().extract().asString();
      throw new JSONException("Service to update an user is not working " + errorMessage);
    } else {
      System.out.println("Update user APIs is working fine.");
    }
    JSONObject userUpdatedResponse = new JSONObject(response.asString());
    return userUpdatedResponse;
  }

}
