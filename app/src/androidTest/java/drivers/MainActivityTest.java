package drivers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import com.example.loginpage.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import drivers.Activity.MainActivity;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

@RunWith(JUnit4.class)
public class MainActivityTest implements TestLoginSystem {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        onView(withId(R.id.buttonCreateAcc)).perform(click());
        registerNewUser("johndoe123", "password");
        goToLoginPage();
    }

    @Test
    public void testLaunch(){
        onView(withId(R.id.txtViewPassword)).check(matches(withText("Password")));
        onView(withId(R.id.buttonCreateAcc)).check(matches(isDisplayed()));
    }

    @Test
    public void testLoginValidCredentials() {
        loginNewUser("johndoe123", "password");

        // should have opened to the home page, test by seeing if home button is displayed
        onView(withId(R.id.imageViewHome)).check(matches(isDisplayed()));
    }

    @Test
    public void testLoginInvalidUsername() {
        loginNewUser("invalid-username", "password");

        // should NOT have opened to the home page, test seeing if login button is still present
        onView(withId(R.id.loginButton)).check(matches(isDisplayed()));
    }

    @Test
    public void testLoginInvalidPassword() {
        loginNewUser("johndoe123", "invalid-password");

        // should NOT have opened the home page, test seeing if login button is still present
        onView(withId(R.id.loginButton)).check(matches(isDisplayed()));
    }

}