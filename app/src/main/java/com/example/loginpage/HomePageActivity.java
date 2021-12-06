package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import nutrition.User;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Bundle extras = getIntent().getExtras();

        TextView tv1 = (TextView)findViewById(R.id.txtViewHi);
        User user = (User) extras.get("currentUser");
        String welcomeMessage = "Welcome, " + user.getName();
        tv1.setText(welcomeMessage);
    }
}