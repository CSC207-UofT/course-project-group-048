package drivers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import com.example.loginpage.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import drivers.Activity.RegisterActivity;


import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import java.util.Random;

@RunWith(JUnit4.class)
public class RegisterActivityTest implements TestLoginSystem {

    Random randomGenerator;

    @Rule
    public ActivityScenarioRule<RegisterActivity> activityRule = new ActivityScenarioRule<>(RegisterActivity.class);

    @Before
    public void setUp() {
        randomGenerator = new Random();
        registerNewUser("johndoe", "password");
    }

    @Test
    public void testLaunch(){
        onView(withId(R.id.registerBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void testRegistrationNewUser() {
        reEnterUsername("john" + randomGenerator.nextInt(10000));
    }

    @Test
    public void testRegistrationExistingUser() {
        // re-enter already entered username johndoe and click register
        reEnterUsername("johndoe");

        // should still be on the registration page if user already exists
        onView(withId(R.id.registerBtn)).check(matches(isDisplayed()));
    }

    /**
     * Re-enter a new username and click register. Assumes all other
     * fields have been entered
     * @param username the new username to type
     */
    private void reEnterUsername(String username) {
        onView(withId(R.id.edtTxtUser)).perform(typeText(username));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.registerBtn)).perform(click());
    }
}