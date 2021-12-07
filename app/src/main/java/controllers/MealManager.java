package controllers;

import android.content.Context;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import entities.FoodItem;
import entities.Meal;
import entities.User;
import usecases.FoodItems;
import usecases.MealDataHandler;

public class MealManager {

    private int targetCalories;

    // we do not use this in our program, but it has been left for future development
    private String dietaryInfo;

    private Random randomGenerator;
    private User user;
    public MealDataHandler mealDatabase;
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
        this.randomGenerator = new Random();
        this.mealDatabase = new MealDataHandler(context, null);

        this.foodItemList = mealDatabase.getAll();

        // FoodItems foodItems = new FoodItems();
        // this.foodItemList = foodItems.foodList;
    }

    public MealManager(User user) {
        this.user = user;
        this.targetCalories = this.calculateTargetCalories();
        this.randomGenerator = new Random();
        FoodItems foodItems = new FoodItems();
        this.foodItemList = foodItems.foodList;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    private int calculateTargetCalories() {
        int target = user.calculateBMR();

        if (user.getGoal().equals("gain")) {
            return target + 500;
        } else {
            return target - 500;
        }
    }

    private FoodItem generateRandomFoodItem(String mealType) {
        int index;
        FoodItem randomFoodItem;
        do {
            index = randomGenerator.nextInt(foodItemList.size());
            randomFoodItem = foodItemList.get(index);
        } while (!randomFoodItem.getTypes()[1].equals(mealType));

        return randomFoodItem;
    }

    public List<Meal> generateAllMeals() {
        int caloriesAllowed = targetCalories;
        String[] mealTypes = new String[]{"breakfast", "lunch", "dinner"};
        List<Meal> meals = new ArrayList<Meal>(mealTypes.length);
        Meal meal;

        for (String mealType : mealTypes) {
            meal = generateMeal(2, mealType, caloriesAllowed);
            meals.add(meal);
            caloriesAllowed -= meal.getCalories();
        }

        return meals;
    }

    public Meal generateMeal(int numItems, String mealType, int caloriesRestriction) {
        List<FoodItem> items = new ArrayList<FoodItem>();
        FoodItem item;
        int caloriesSoFar = 0, addedItems = 0;

        while (caloriesSoFar < caloriesRestriction && addedItems < numItems) {
            item = generateRandomFoodItem(mealType);
            items.add(item);
            caloriesSoFar += item.getCalories();
            addedItems += 1;
        }

        return new Meal(mealType, items);
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



