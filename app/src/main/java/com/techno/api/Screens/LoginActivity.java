package com.techno.api.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.techno.api.Api.Api;
import com.techno.api.Api.ApiFunctions;
import com.techno.api.Listener.OnApiCallListener;
import com.techno.api.Model.DeviceInfo;
import com.techno.api.Model.Login;
import com.techno.api.Model.LoginDetails;
import com.techno.api.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by arbaz on 29/6/16.
 */
public class LoginActivity extends AppCompatActivity implements OnApiCallListener {
    EditText et_login_email, et_login_pass;
    Button btn_login;
    ApiFunctions apiFunctions;
    DeviceInfo deviceInfo;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiFunctions = new ApiFunctions(this,this);

        et_login_email = (EditText) findViewById(R.id.et_login_email);
        et_login_pass = (EditText) findViewById(R.id.et_login_pass);

        et_login_email.setText("demo1@gmail.com");
        et_login_pass.setText("123456");

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_login_email.getText().toString();
                String password = et_login_pass.getText().toString();
                deviceInfo = new DeviceInfo();
                Login login = new Login(email, password, deviceInfo);
                apiFunctions.userLogin(Api.MainUrl + Api.ActionLogin, login);
            }
        });
    }

    @Override
    public void onFailure(final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Handle UI here

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onSuccess(int responseCode, final String responseString, String url) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Handle UI here
                // Toast.makeText(getApplicationContext(), responseString, Toast.LENGTH_LONG).show();
                String fname, lname, fullname;
                Gson gson = new Gson();
                LoginDetails loginDetails;
                JSONObject jsonObject = null;

                try {
                    jsonObject = new JSONObject(responseString);
                    loginDetails = gson.fromJson(jsonObject.toString(), LoginDetails.class);
                    Intent iNext = new Intent(getApplicationContext(), DetailPage.class);
                    iNext.putExtra("details", loginDetails);
                    startActivity(iNext);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}