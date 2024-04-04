package com.base.helper.api.reqres;

public class ReqResBeans {

  private static ReqResBeans reqResBeans;
  private String userName;
  private String userRole;

  /**
   * Private no argument constructor for ReqResBeans restricting instance creation.
   */
  private ReqResBeans() {

  }

  /**
   * Initialize the Bean static singleton instance.
   */
  private static void initFileBean() {
    if (reqResBeans == null) {
      reqResBeans = new ReqResBeans();
    }
  }

  /**
   * Set the user name.
   * 
   * @param userName - user name.
   * @author simran.kumari
   */
  public static void set_user_name(String userName) {
    if (reqResBeans == null) {
      initFileBean();
    }
    reqResBeans.userName = userName;
  }

  /**
   * Get the user name.
   * 
   * @return - user name.
   * @author simran.kumari
   */
  public static String get_user_name() {
    if (reqResBeans == null) {
      initFileBean();
    }
    return reqResBeans.userName;
  }

  /**
   * Set the user role.
   * 
   * @param userRole - user role.
   * @author simran.kumari
   */
  public static void set_user_role(String userRole) {
    if (reqResBeans == null) {
      initFileBean();
    }
    reqResBeans.userRole = userRole;
  }

  /**
   * Get the user role.
   * 
   * @return - user role.
   * @author simran.kumari
   */
  public static String get_user_role() {
    if (reqResBeans == null) {
      initFileBean();
    }
    return reqResBeans.userRole;
  }
}
