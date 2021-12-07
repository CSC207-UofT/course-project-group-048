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
        this.mealCourse = new MealCourse(targetCalories, context);
    }

    public MealManager(User user) {
        this.user = user;
        this.targetCalories = this.calculateTargetCalories();
    }

    public MealCourse getMealCourse() {
        return mealCourse;
    }

    private int calculateTargetCalories() {
        int target = user.calculateBMR();

        if (user.getGoal().equals("gain")) {
            return target + 500;
        } else {
            return target - 500;
        }
    }


    public int getTargetCalories() {
        return targetCalories;
    }
}



