package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nutrition.User;

public class HomePageActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Bundle extras = getIntent().getExtras();

        TextView tv1 = (TextView)findViewById(R.id.txtViewHi);
        user = (User) extras.get("user");
        String welcomeMessage = "Welcome, " + user.getName();
        tv1.setText(welcomeMessage);
    }

    public void openProfilePage(View view) {
        Intent openTheProfilePage = new Intent(this, ProfileActivity.class);
        openTheProfilePage.putExtra("user", user);
        startActivity(openTheProfilePage);
    }
}