package drivers.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginpage.R;

import controllers.LoginSystem;
import controllers.MealManager;
import entities.FoodItem;
import entities.Meal;
import entities.User;
import entities.Utils;
import usecases.MealCourse;

public class MealGeneratorActivity extends AppCompatActivity {

    User user;
    String username;
    LoginSystem system;
    MealManager manager;
    MealCourse mealCourse;

    /**
     * Actions to do when the activity begins. Creates
     * buttons and generates a meal course for the user.
     *
     * @param savedInstanceState the state of the application
     */
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
        ImageView img = findViewById(buttonID);
        img.setOnClickListener(v -> refreshMeal(mealType));
    }

    private void refreshAllMeals() {
        refreshBreakfast();
        refreshLunch();
        refreshDinner();
    }

    private void refreshMeal(String mealType) {
        // prompted to change to switch statement but avoided as per advise to avoid switch statements
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
        TextView tv3 = findViewById(R.id.textViewBreakfastCalories);
        String breakfastCalories = "Calories: " + breakfast.getCalories();
        tv3.setText(breakfastCalories);

        updateMealText(breakfast, 0, R.id.textViewBreakfastMeal1, R.id.imageViewBM1);
        updateMealText(breakfast, 1, R.id.textViewBreakfastMeal2, R.id.imageViewBM2);
    }

    private void refreshLunch() {
        mealCourse.refreshMeal("lunch");
        Meal lunch = mealCourse.getMeal("lunch");
        TextView tv6 = findViewById(R.id.textViewLunchCalories);

        String lunchCalories = "Calories: " + lunch.getCalories();
        tv6.setText(lunchCalories);

        updateMealText(lunch, 0, R.id.textViewLunch1, R.id.imageViewLM1);
        updateMealText(lunch, 1, R.id.textViewLunch2, R.id.imageViewLM2);
    }

    private void refreshDinner() {
        mealCourse.refreshMeal("dinner");
        Meal dinner = mealCourse.getMeal("dinner");
        TextView tv9 = findViewById(R.id.textViewDinnerCalories);
        String dinnerCalories = "Calories: " + " " + dinner.getCalories();
        tv9.setText(dinnerCalories);

        updateMealText(dinner, 0, R.id.textViewDinner1, R.id.imageViewDM1);
        updateMealText(dinner, 1, R.id.textViewDinner2, R.id.imageViewDM2);
    }

    private void updateMealText(Meal meal, int itemNumber, int textId, int imageId) {
        TextView tv = findViewById(textId);
        ImageView iv = findViewById(imageId);
        String mealString = "";
        String newImageIdString;
        FoodItem foodItem;
        int newImageId = Utils.getResId("nothing", R.drawable.class);

        if (itemNumber < meal.getSize()) {
            foodItem = meal.getFoodItems().get(itemNumber);
            mealString = foodItem.toString();
            newImageIdString = foodItem.getName().replace(" ", "_");
            newImageId = Utils.getResId(newImageIdString, R.drawable.class);
        }

        tv.setText(mealString);
        iv.setImageResource(newImageId);
    }

    public void setup() {
        Bundle extras = getIntent().getExtras();
        system = new LoginSystem(this);
        username = (String) extras.get("username");
        user = system.getUser(username);
        manager = new MealManager(user, -1, null, this);
    }

    public void setHeaderText() {
        TextView tv1 = findViewById(R.id.textViewTitle);
        String welcomeMessage = "Meal Plan for " + user.getName();
        tv1.setText(welcomeMessage);

        TextView tv2 = findViewById(R.id.txtViewCalories);
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