package com.engineeringeric.parkerapp;

/**
 * Created by Eric on 3/16/2017.
 */
public class Config {

    private static final String API_BASE_URL = "http://10.0.2.2:8080/api";

    public static String getApiBaseUrl () {
        return API_BASE_URL;
    }
}
