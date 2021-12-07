package drivers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginpage.R;

import controllers.LoginSystem;
import controllers.MealManager;
import entities.Meal;
import entities.User;
import usecases.MealCourse;

public class MealGeneratorActivity extends AppCompatActivity {

    User user;
    String username;
    LoginSystem system;
    MealManager manager;
    MealCourse mealCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_generator);

        setup();
        setHeaderText();
        mealCourse = manager.getMealCourse();
        refreshAllMeals();

        setRefreshButton("all", R.id.imageBtnRefresh1);
        setRefreshButton("breakfast", R.id.imageBtnRefresh2);
        setRefreshButton("lunch", R.id.imageBtnRefresh3);
        setRefreshButton("dinner", R.id.imageBtnRefresh4);
    }

    private void setRefreshButton(String mealType, int buttonID) {
        ImageView img = (ImageView) findViewById(buttonID);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                refreshMeal(mealType);
            }
        });
    }

    private void refreshAllMeals() {
        refreshBreakfast();
        refreshLunch();
        refreshDinner();
    }

    private void refreshMeal(String mealType) {
        if (mealType.equals("breakfast")) {
            refreshBreakfast();
        } else if (mealType.equals("lunch")) {
            refreshLunch();
        } else if (mealType.equals("dinner")) {
            refreshDinner();
        } else if (mealType.equals("all")) {
            refreshAllMeals();
        } else {
            // ERROR!!
            refreshAllMeals();
        }
    }

    private void refreshBreakfast() {
        mealCourse.refreshMeal("breakfast");
        Meal breakfast = mealCourse.getMeal("breakfast");
        TextView tv3 = (TextView) findViewById(R.id.textViewBreakfastCalories);
        String breakfastCalories = "Calories: " + breakfast.getCalories();
        tv3.setText(breakfastCalories);

        updateMealText(breakfast, 0, R.id.textViewBreakfastMeal1);
        updateMealText(breakfast, 1, R.id.textViewBreakfastMeal2);
    }

    private void refreshLunch() {
        mealCourse.refreshMeal("lunch");
        Meal lunch = mealCourse.getMeal("lunch");
        TextView tv6 = (TextView) findViewById(R.id.textViewLunchCalories);
        String lunchCalories = "Calories: " + lunch.getCalories();
        tv6.setText(lunchCalories);

        updateMealText(lunch, 0, R.id.textViewLunch1);
        updateMealText(lunch, 1, R.id.textViewLunch2);
    }

    private void refreshDinner() {
        mealCourse.refreshMeal("dinner");
        Meal dinner = mealCourse.getMeal("dinner");
        TextView tv9 = (TextView) findViewById(R.id.textViewDinnerCalories);
        String dinnerCalories = "Calories: " + " " + dinner.getCalories();
        tv9.setText(dinnerCalories);

        updateMealText(dinner, 0, R.id.textViewDinner1);
        updateMealText(dinner, 1, R.id.textViewDinner2);
    }

    private void updateMealText(Meal meal, int itemNumber, int id) {
        TextView tv = (TextView) findViewById(id);
        String mealString = "";

        if (itemNumber < meal.getSize()) {
            mealString = meal.getFoodItems().get(itemNumber).toString();
        }

        tv.setText(mealString);
    }

    public void setup() {
        Bundle extras = getIntent().getExtras();
        system = new LoginSystem(this);
        username = (String) extras.get("username");
        user = system.getUser(username);
        manager = new MealManager(user, -1, null, this);
    }

    public void setHeaderText() {
        TextView tv1 = (TextView) findViewById(R.id.textViewTitle);
        String welcomeMessage = "Meal Plan for " + user.getName();
        tv1.setText(welcomeMessage);

        TextView tv2 = (TextView) findViewById(R.id.txtViewCalories);
        String caloriesString = "Target Calories: " + manager.getTargetCalories();
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