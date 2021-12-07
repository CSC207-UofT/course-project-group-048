package drivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.loginpage.R;

import controllers.LoginSystem;
import controllers.MealManager;
import entities.User;

public class MealGeneratorActivity extends AppCompatActivity {

    User user;
    String username;
    LoginSystem system;
    MealManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_generator);
        Bundle extras = getIntent().getExtras();
        system = new LoginSystem(this);
        username = (String) extras.get("username");
        user = system.getUser(username);
        manager = new MealManager(user, -1, null, this);

        TextView tv1 = (TextView)findViewById(R.id.textViewTitle);
        String welcomeMessage = "Meal Plan for " + user.getName();
        tv1.setText(welcomeMessage);

        TextView tv2 = (TextView)findViewById(R.id.txtViewCalories);
        String caloriesString = "Target Calories: " + String.valueOf(manager.getTargetCalories());
        tv2.setText(caloriesString);
    }

    public void openHomePage(View view) {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        openTheHomePage.putExtra("username", username);
        startActivity(openTheHomePage);
    }

    public void openProfilePage(View view) {
        Intent openTheProfilePage = new Intent(this, ProfileActivity.class);
        openTheProfilePage.putExtra("username", username);
        startActivity(openTheProfilePage);
    }

    public void openMealGeneratorPage(View view) {
        // refresh the page
        finish();
        startActivity(getIntent());
    }


}