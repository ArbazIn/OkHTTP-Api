package com.techno.api.Api;

/**
 * Created by arbaz on 29/6/16.
 */
public class Api {

    //Dump Condition
    public static final int ConnectionTimeout = 30000; // = 30 seconds
    public static final int ConnectionSoTimeout = 60000; // = 60 seconds


    //Response Codes
    public static final int ResponseOk = 200;
    public static final int ResponsePageError = 400;
    public static final int ResponseServerError = 500;

    // App URL
    public static final String MainUrl = "http://192.168.1.12/salon/webservices/web/index.php";

    //Api Call
    public static final String ActionLogin = "/login";
    public static final String ActionRegistration = "/user/register";

}
