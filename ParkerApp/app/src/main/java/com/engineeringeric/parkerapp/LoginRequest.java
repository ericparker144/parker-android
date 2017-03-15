package com.engineeringeric.parkerapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric on 3/14/2017.
 */
public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "http://localhost:8080/api/Login";
    private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener, Response.ErrorListener error) {
        // HTTP Method, URL, callback, and error callback
        super(Method.POST, LOGIN_REQUEST_URL, listener, error);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    // This method is called by volley when the request is being sent
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
