package com.engineeringeric.parkerapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tells the Java file which xml file it's working with
        setContentView(R.layout.activity_main);

        // create references to each input in the xml file
        final Globals g = (Globals) getApplication();
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String username = etUsername.getText().toString();
                    final String password = etPassword.getText().toString();

                    // Success Callback
                    Response.Listener responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean result = jsonResponse.getBoolean("success");

                                if (result) {

                                    Intent intent = new Intent(MainActivity.this, LandingActivity.class);

                                    JSONObject userData = jsonResponse.getJSONArray("result").getJSONObject(0);
                                    g.setUserId(userData.getString("Id"));
                                    g.setFirstName(userData.getString("FirstName"));
                                    g.setLastName(userData.getString("LastName"));

                                    MainActivity.this.startActivity(intent);
                                }
                                else {
                                    Toast error = Toast.makeText(MainActivity.this, jsonResponse.getString("error"), Toast.LENGTH_LONG);
                                    error.show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    // Failure Callback (500)
                    Response.ErrorListener errorListener = new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Server Error. Please try again later.").create().show();
                        }
                    };


                        LoginRequest loginRequest = new LoginRequest(username, password, responseListener, errorListener);
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    queue.add(loginRequest);
                }
            });
    }
}
