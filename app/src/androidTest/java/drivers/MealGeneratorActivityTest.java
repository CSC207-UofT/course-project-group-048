package drivers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import com.example.loginpage.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import drivers.Activity.MainActivity;


import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

@RunWith(JUnit4.class)
public class MealGeneratorActivityTest implements TestLoginSystem {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        registerLoginNewUser("johndoe123", "password");
        openMealGeneratorPage();
    }

    @Test
    public void testLaunch() {
        onView(withId(R.id.textViewBreakfast)).check(matches(withText("Breakfast")));
    }

    @Test
    public void testRefreshAll() {
        onView(withId(R.id.imageBtnRefresh1)).perform(click());
    }

    @Test
    public void testRefreshBreakfast() {
        onView(withId(R.id.imageBtnRefresh2)).perform(click());
    }

    @Test
    public void testRefreshLunch() {
        onView(withId(R.id.imageBtnRefresh3)).perform(click());
    }

    @Test
    public void testRefreshDinner() {
        onView(withId(R.id.imageBtnRefresh4)).perform(click());
    }

    private void openMealGeneratorPage() {
        onView(withId(R.id.imageViewSupport)).perform(click());
    }

}