package controllers;

import android.content.Context;

import java.util.List;
import java.lang.Math;
import java.util.ArrayList;

import entities.FoodItem;
import usecases.FoodItems;
import usecases.MealDBHandler;

public class MealGenerator {

    private final String mealType;
    private final int caloriesAim;
    private final String dietInfo;
    public MealDBHandler dbHandler;
    public List<FoodItem> foodItemList;

    /**
     * A goal set for a given User.
     *
     * @param mealType the type of meal to be generated
     * @param calories the target calories to be gained for the goal to be achieved, set using a setter
     * @param dietaryInfo dietary requirements (vegan, veg, or all ONLY)
     */

    public MealGenerator(String mealType, int calories, String dietaryInfo, Context context) {
        this.mealType = mealType;
        this.caloriesAim = this.caloriesAimCalculator(calories);
        this.dietInfo = dietaryInfo;
        this.dbHandler = new MealDBHandler(context, null, null, 2);
        this.foodItemList = this.dbHandler.getAll();
    }

    public int caloriesAimCalculator(int c) {
        int[] calories = new int[]{1500, 2000, 2500, 3000};
        int min = 10000;
        int cCalorie = 0;
        for (int calorie : calories) {
            // the <= gives a higher meal plan in the case of a tie, and so the user has more
            // options to choose from
            int diff = Math.abs(calorie - c);
            if (diff <= min) {
                min = diff;
                cCalorie = calorie;
            }
        }
        return cCalorie;
    }

    public ArrayList<FoodItem> customMeals() {
            String hashKey = String.valueOf(caloriesAim) + dietInfo;
            // find a random meal from the hashmap, and return it
            return FoodItems.meals.get(hashKey);
        }

    public void refreshMeal() {
        // here, if its vegan we only have 1 option as of now, 2 for vegetarian and 3 for all
        // need to store closest
    }

    public void changeItem(){
        // still working on it, THIS IS WHERE FOODITEM LIST IS USED
        // returns void anyways if it takes in a ArrayList of fooditems, OR returns the modified list - decide on either
    }

    public FoodItem generateSingle() {
        // to be used in the change item class, uses the mealType parameter and MealDBHandler
        return FoodItems.PEANUTS;



    }


}



