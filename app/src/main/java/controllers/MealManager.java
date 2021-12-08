package controllers;

import android.content.Context;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import entities.FoodItem;
import entities.Meal;
import entities.User;
import usecases.FoodItems;
import usecases.MealCourse;
import usecases.MealDataHandler;

public class MealManager {

    private int targetCalories;

    // we do not use this in our program, but it has been left for future development
    private String dietaryInfo;
    private MealCourse mealCourse;
    private User user;

    /**
     * A MealManager for a given user incorporating their nutritional and dietary requirements.
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
        this.mealCourse = new MealCourse(targetCalories, context);
    }

    /**
     * A MealManager for a user incorporating their targeted calories.
     * @param user the user that we are generating meals for
     */
    public MealManager(User user) {
        this.user = user;
        this.targetCalories = this.calculateTargetCalories();
    }

    /**
     * A getter method for the mealCourse attribute.
     * @return the mealCourse attribute of a user.
     */
    public MealCourse getMealCourse() {
        return mealCourse;
    }

    /**
     * A method that calculates the target calories for a user based on their selected goals.
     * @return an integer with the target calories a user is trying to achieve calculated from
     * their goal
     */
    private int calculateTargetCalories() {
        int target = user.calculateBMR();

        if (user.getGoal().equals("gain")) {
            return target + 500;
        } else {
            return target - 500;
        }
    }

    /**
     * A getter method for the targetCalories attribute.
     * @return the integer representing the targetCalories the user is trying to achieve.
     */
    public int getTargetCalories() {
        return targetCalories;
    }
}



