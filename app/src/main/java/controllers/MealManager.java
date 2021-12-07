package controllers;

import android.content.Context;

import java.util.List;
import java.util.ArrayList;

import entities.FoodItem;
import entities.User;
import usecases.FoodItems;
import usecases.MealDBHandler;

public class MealManager {

    private final int targetCalories;

    // we do not use this in our program, but it has been left for future development
    private String dietaryInfo;

    private User user;
    public MealDBHandler dbHandler;
    public List<FoodItem> foodItemList;

    /**
     * A goal set for a given User.
     *
     * @param user the user that we are generating meals for
     * @param calories the target calories to be gained for the goal to be achieved, set using a setter
     * @param dietaryInfo dietary requirements (vegan, veg, or all ONLY)
     * @param context the activity class generating meals
     */

    public MealManager(User user, int calories, String dietaryInfo, Context context) {
        this.user = user;

        if (calories == -1) {
            this.targetCalories = this.calculateTargetCalories();
        } else {
            this.targetCalories = calories;
        }

        this.dietaryInfo = dietaryInfo;

        this.dbHandler = new MealDBHandler(context, null, null, 2);
        this.foodItemList = this.dbHandler.getAll();
    }

    private int calculateTargetCalories() {
        int target = user.calculateBMR();

        if (user.getGoal().equals("gain")) {
            return target + 500;
        } else {
            return target - 500;
        }
    }

    private FoodItem generateRandomFoodItem() {
        return FoodItems.CHICKEN_CURRY;
    }

    public List<FoodItem> generateFoodItems() {
        List<FoodItem> items = new ArrayList<FoodItem>();
        FoodItem item;
        int caloriesSoFar = 0;

        while (caloriesSoFar < targetCalories) {
            item = generateRandomFoodItem();
            items.add(item);
            caloriesSoFar += item.getCalories();
        }

        return items;
    }

    public ArrayList<FoodItem> customMeals() {
            String hashKey = targetCalories + dietaryInfo;
            // find a random meal from the hashmap, and return it
            return FoodItems.meals.get(hashKey);
        }

    public void refreshMeal() {
        // here, if its vegan we only have 1 option as of now, 2 for vegetarian and 3 for all
        // need to store closest
    }

    public void changeItem() {
        // still working on it, THIS IS WHERE FOODITEM LIST IS USED
        // returns void anyways if it takes in a ArrayList of fooditems, OR returns the modified list - decide on either
    }


    public int getTargetCalories() {
        return targetCalories;
    }
}



