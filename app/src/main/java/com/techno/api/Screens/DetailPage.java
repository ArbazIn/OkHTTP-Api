package com.techno.api.Screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.techno.api.Model.LoginDetails;
import com.techno.api.R;

/**
 * Created by arbaz on 29/6/16.
 */
public class DetailPage extends AppCompatActivity {
    TextView txt_fname, txt_lname, txt_email;
    LoginDetails loginDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);

        Bundle b = new Bundle(getIntent().getExtras());
        //b.getString("fname");

        loginDetails = (LoginDetails) b.get("details");
        txt_fname = (TextView) findViewById(R.id.txt_fname);
        txt_lname = (TextView) findViewById(R.id.txt_lname);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_fname.setText(loginDetails.getFirst_name());
        txt_lname.setText(loginDetails.getLast_name());
        txt_email.setText(loginDetails.getEmail());
    }
}
