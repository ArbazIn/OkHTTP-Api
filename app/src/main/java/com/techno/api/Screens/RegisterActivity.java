package com.techno.api.Screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.techno.api.Api.Api;
import com.techno.api.Api.ApiFunctions;
import com.techno.api.App.AppController;
import com.techno.api.Listener.OnApiCallListener;
import com.techno.api.Model.RegisterDetails;
import com.techno.api.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements OnApiCallListener {
    TextView txt_msg;
    EditText et_fname, et_lname, et_email, et_pass;
    Button btn_submit;
    ApiFunctions apiFunctions;
    private String tag_json_obj = "jobj_req";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        apiFunctions = new ApiFunctions(this, this);
        txt_msg = (TextView) findViewById(R.id.txt_msg);
        et_fname = (EditText) findViewById(R.id.et_fname);
        et_lname = (EditText) findViewById(R.id.et_lname);
        et_email = (EditText) findViewById(R.id.et_email);
        et_pass = (EditText) findViewById(R.id.et_pass);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = et_fname.getText().toString();
                String lname = et_lname.getText().toString();
                String email = et_email.getText().toString();
                String pass = et_pass.getText().toString();
                RegisterDetails userDetails = new RegisterDetails(fname, lname, email, pass);
                apiFunctions.userRegistration(Api.MainUrl + Api.ActionRegistration, userDetails);
               // makeJsonObjReq();
            }
        });
    }

    @Override
    public void onFailure(final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Handle UI here

                txt_msg.setText("failure " + message);
            }
        });

    }

    @Override
        public void onSuccess(final int responseCode, final String responseString, String url) {
        int code = 0;
        String message;
        Gson gson = new Gson();


        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(responseString);
            code = jsonObject.getInt("code");
            message = jsonObject.getString("message");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final int finalCode = code;
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Handle UI here


                if (finalCode == 201) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                }
                txt_msg.setText(responseString);
            }
        });

    }

   /* private void makeJsonObjReq() {
        JSONObject params = new JSONObject();
        try {
            params.put("first_name", "Mas");
            params.put("last_name", "Androidhive");
            params.put("email", "volley1@gmail.com");
            params.put("password", "123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                Api.MainUrl + Api.ActionRegistration, params,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Rsponse", response.toString());
                        txt_msg.setText(response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Response Error", "Error: " + error.getMessage());
            }
        }) {

            *//**
             * Passing some request headers
             * *//*
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("first_name", "Mas");
                params.put("last_name", "Androidhive");
                params.put("email", "volley1@gmail.com");
                params.put("password", "123456");

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq,
                tag_json_obj);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }
*/
}
