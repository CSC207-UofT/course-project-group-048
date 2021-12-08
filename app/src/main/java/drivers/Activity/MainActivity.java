package drivers.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginpage.R;

import controllers.LoginSystem;
import entities.User;
import usecases.MealDataHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTxtUsername, edtTxtPassword;
    LoginSystem loginSystem;
    String username, password;
    User user;

    MealDataHandler mealDatabase;

    /**
     * Actions to do when the activity begins. Creates
     * buttons and edit text objects.
     *
     * @param savedInstanceState the state of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // assign the XML file to open

        ImageButton loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this); // instantiate the login button

        Button buttonCreateAcc = findViewById(R.id.buttonCreateAcc);
        buttonCreateAcc.setOnClickListener(this); // instantiate the register button

        edtTxtUsername = findViewById(R.id.edtTxtUsername);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
    }

    /**
     * Finds which part of the View was clicked. If this part is the login
     * button, then log in the user and initiate new Meal database. If this
     * part is the create account button, then open the meal registration page.
     *
     * @param v the current View object
     */
    @Override
    public void onClick(View v) {
        username = edtTxtUsername.getText().toString();
        password = edtTxtPassword.getText().toString();

        // check user fields if login button is clicked,
        // else if registration button is clicked open registration form
        if (v.getId() == R.id.loginButton) {
            mealDatabase = new MealDataHandler(this, null);
            checkFields();
        } else if (v.getId() == R.id.buttonCreateAcc) {
            Toast.makeText(this, "Please Enter All Information",
                    Toast.LENGTH_LONG).show();
            openRegistrationForm();
        }
    }

    /**
     * Check the username and password fields to verify all input is present.
     * Log in the user if this is the case, otherwise dispaly Toast message.
     */
    public void checkFields() {
        if (username.trim().length() == 0) {
            Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show();
        } else if (password.trim().length() == 0) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
        } else {
            handleLogin();
        }
    }

    /**
     * Take the inputted login information and pass it to the LoginSystem controller
     * to verify a user's credentials. Open the home page with valid credentials,
     * otherwise, display Toast message.
     */
    public void handleLogin() {
        // Check whether inputted username and password exist in the database of existing
        // users. If yes, then log in the user. If not, then display "incorrect details" message.
        loginSystem = new LoginSystem(this);
        if (loginSystem.checkUsernamePassword(username, password)) {
            Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
            user = loginSystem.getUser(username);
            openHomePage();
        } else {
            Toast.makeText(this, "Incorrect username or password...",
                    Toast.LENGTH_SHORT).show();
            edtTxtUsername.setText("");
            edtTxtPassword.setText("");
        }
    }

    /**
     * Open the registration page and start RegisterActivity.
     */
    public void openRegistrationForm() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * Open the home page and start HomePageActivity with provided username.
     * Should only be called if user has logged in with valid credentials.
     */
    public void openHomePage() {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        openTheHomePage.putExtra("username", username);
        startActivity(openTheHomePage);
    }

}
