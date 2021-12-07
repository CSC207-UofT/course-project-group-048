package controllers;

import org.junit.*;

import static org.junit.Assert.*;

import entities.FoodItem;
import entities.User;

public class MealManagerTest {
    User user;
    MealManager mealManager;

    @Before
    public void setUp() throws Exception {
        user = new User("John Doe", "johndoe", "0000", "male", 130, 167, 22, "gain");
        mealManager = new MealManager(user, -1, null, null);
    }

    @Test(timeout = 50)
    public void TestGenerateFoodItems() {
        System.out.println(mealManager.getTargetCalories());
        for (FoodItem foodItem : mealManager.generateFoodItems()) {
            System.out.println(foodItem);
        }
    }
}