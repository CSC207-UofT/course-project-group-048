package drivers.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginpage.R;

import java.util.ArrayList;

import controllers.LoginSystem;
import drivers.Adapter.CategoryAdapter;
import drivers.Adapter.PopularMealAdapter;
import drivers.Domain.CategoryDomain;
import drivers.Domain.PopularMealDomain;
import entities.User;

public class HomePageActivity extends AppCompatActivity implements LoggedInActivity {

    LoginSystem system;
    String username;
    User user;

    /**
     * Actions to do when the activity begins. Sets the
     * text to welcome the user.
     *
     * @param savedInstanceState the state of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage); // set the XML file to open

        loadUserInformation();

        TextView tv1 = findViewById(R.id.txtViewHi);
        String welcomeMessage = "Welcome, " + user.getName();
        tv1.setText(welcomeMessage); // display welcome message with user name

        recyclerViewCategory();
        recyclerViewPopularMeals();
    }

    /**
     * Loads the current user information from the username
     * passed from another activity in a Bundle object.
     */
    @Override
    public void loadUserInformation() {
        Bundle extras = getIntent().getExtras();
        system = new LoginSystem(this);
        username = (String) extras.get("username");
        user = system.getUser(username);
    }

    /**
     * Create a recycle view for the Popular Meals tab on the home page.
     */
    private void recyclerViewPopularMeals() {
        // create the format for popular meals
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewPopular = findViewById(R.id.view2);
        recyclerViewPopular.setLayoutManager(linearLayoutManager);

        // add popular meals
        ArrayList<PopularMealDomain> popularMeal = new ArrayList<>();
        popularMeal.add(new PopularMealDomain("Pepperoni Pizza", "pizza1", 1500));
        popularMeal.add(new PopularMealDomain("Double Cheeseburger", "burger", 1100));
        popularMeal.add(new PopularMealDomain("Vegan Pizza", "pizza3", 800));

        RecyclerView.Adapter<PopularMealAdapter.ViewHolder> adapter2 = new PopularMealAdapter(popularMeal);
        recyclerViewPopular.setAdapter(adapter2);
    }

    /**
     * Create a recycle view for the Categories tab on the home page.
     */
    private void recyclerViewCategory() {
        // creates the format for categories
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewCategories = findViewById(R.id.recyclerView);
        recyclerViewCategories.setLayoutManager(linearLayoutManager);

        // add categories
        ArrayList<CategoryDomain> categories = new ArrayList<>();
        categories.add(new CategoryDomain("Breakfast"));
        categories.add(new CategoryDomain("Lunch"));
        categories.add(new CategoryDomain("Dinner"));

        RecyclerView.Adapter<CategoryAdapter.ViewHolder> adapter = new CategoryAdapter(categories);
        recyclerViewCategories.setAdapter(adapter);
    }

    /**
     * Open the profile page and start ProfileActivity with provided username.
     *
     * @param view the view object
     */
    @Override
    public void openProfilePage(View view) {
        Intent openTheProfilePage = new Intent(this, ProfileActivity.class);
        openTheProfilePage.putExtra("username", username);
        startActivity(openTheProfilePage);
    }

    /**
     * Reopen the home page and restart the activity
     *
     * @param view the view object
     */
    @Override
    public void openHomePage(View view) {
        // refresh the page
        finish();
        startActivity(getIntent());
    }

    /**
     * Open the Meal Generator page and start MealGeneratorActivity with provided username.
     *
     * @param view the view object
     */
    @Override
    public void openMealGeneratorPage(View view) {
        Intent openTheMealGeneratorPage = new Intent(this, MealGeneratorActivity.class);
        openTheMealGeneratorPage.putExtra("username", username);
        startActivity(openTheMealGeneratorPage);
    }
}