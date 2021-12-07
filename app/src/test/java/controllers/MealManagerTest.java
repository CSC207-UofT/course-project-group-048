package controllers;

import org.junit.*;

import static org.junit.Assert.*;

import entities.FoodItem;
import entities.Meal;
import entities.User;

public class MealManagerTest {
    User user;
    MealManager mealManager;

    @Before
    public void setUp() throws Exception {
        user = new User("John Doe", "johndoe", "0000", "male", 130, 167, 22, "gain");
        mealManager = new MealManager(user);
    }

    @Test(timeout = 50)
    public void TestGenerateFoodItems() {
        System.out.println(mealManager.getTargetCalories());
        for (Meal meal : mealManager.generateAllMeals()) {
            for (FoodItem foodItem : meal) {
                System.out.println(foodItem);
            }
        }
    }
}