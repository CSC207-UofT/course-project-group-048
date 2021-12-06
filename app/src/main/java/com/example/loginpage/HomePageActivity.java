package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nutrition.MealGenerator;
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

    public void openHomePage(View view) {
        // refresh the page
        finish();
        startActivity(getIntent());
    }

    public void openMealGeneratorPage(View view) {
        Intent openTheMealGeneratorPage = new Intent(this, MealGeneratorActivity.class);
        openTheMealGeneratorPage.putExtra("user", user);
        startActivity(openTheMealGeneratorPage);
    }
}