package usecases;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import entities.FoodItem;
import entities.Meal;

public class MealCourse implements Iterable<Meal> {
    private final MealCourseIterator<Meal> mealCourseIterator;
    private List<Meal> meals;
    private List<FoodItem> foodItemList;
    private int targetCalories;
    private int calories;

    /**
     * A constructor for the MealCourse class, using a list of Meal objects, one for each type.
     * @param meals a List of Meal objects
     * @param context the current state of the application representing the context in which the
     *                database exists
     */
    public MealCourse(List<Meal> meals, Context context) {
        this.meals = meals;
        loadFoodList(context);
        mealCourseIterator = new MealCourseIterator<>(meals);
    }

    /**
     * A constructor for the MealCourse class, using an integer representing the target calories
     * instead.
     * @param targetCalories an integer representing the target calories of a Meal in this
     *                       MealCourse object
     * @param context the current state of the application representing the context in which the
     *                database exists
     */
    public MealCourse(int targetCalories, Context context) {
        this.targetCalories = targetCalories;
        loadFoodList(context);
        refreshAllMeals();
        mealCourseIterator = new MealCourseIterator<>(meals);
    }

    /**
     * Refreshes all the meals in the MealCourse by replacing them with the new ones.
     */
    public void refreshAllMeals() {
        calories = 0;
        int caloriesAllowed = targetCalories;
        String[] mealTypes = new String[]{"breakfast", "lunch", "dinner"};
        meals = new ArrayList<>(mealTypes.length);
        Meal meal;

        for (String mealType : mealTypes) {
            meal = generateMeal(2, mealType, caloriesAllowed);
            meals.add(meal);
            caloriesAllowed -= meal.getCalories();
            calories += meal.getCalories();
        }
    }

    /**
     * Refreshes one of the meals in the MealCourse, specifically the one corresponding to the
     * mealType meal type.
     * @param mealType the mealType of the meal that is to be refreshed.
     */
    public void refreshMeal(String mealType) {
        int allowedMealCalories = calculateAllowedMealCalories(mealType);
        Meal newMeal = generateMeal(2, mealType, allowedMealCalories);
        int index = -1;

        for (Meal meal : meals) {
            index ++;
            if (meal.getType().equals(mealType)) {
                meals.set(index, newMeal);
            }
        }
    }

    /**
     * Returns the amount of meal calories allowed for a certain meal type (breakfast, lunch, etc)
     * for a user.
     * @param mealType the meal type for which the allowed meal calories are being calculated
     * @return the calculated the allowed meal calories for the required meal type.
     */
    private int calculateAllowedMealCalories(String mealType) {
        int otherMealCalories = 0;
        for (Meal meal : meals) {
            if (!meal.getType().equals(mealType)) {
                otherMealCalories += meal.getCalories();
            }
        }

        return calories - otherMealCalories;
    }

    /**
     * Loads the list of FoodItem objects in the database
     * @param context the current state of the application representing the context in which the
     *                database exists
     */
    private void loadFoodList(Context context) {
        MealDataHandler mealDatabase = new MealDataHandler(context, null);
        this.foodItemList = mealDatabase.getAll();
    }

    private FoodItem generateRandomFoodItem(String mealType) {
        Random randomGenerator = new Random();
        int index;
        FoodItem randomFoodItem;
        do {
            index = randomGenerator.nextInt(foodItemList.size());
            randomFoodItem = foodItemList.get(index);
        } while (!randomFoodItem.getTypes()[1].equals(mealType));

        return randomFoodItem;
    }

    public Meal generateMeal(int numItems, String mealType, int caloriesRestriction) {
        List<FoodItem> items = new ArrayList<>();
        FoodItem item;
        int caloriesSoFar = 0, addedItems = 0;
        System.out.println(caloriesRestriction);

        while (addedItems < numItems) {
            item = generateRandomFoodItem(mealType);
            caloriesSoFar += item.getCalories();
            System.out.println(item.getName() + ":" + item.getCalories() + ":" + caloriesSoFar);
            if (caloriesSoFar < caloriesRestriction){
                items.add(item);
            }
            addedItems += 1;
        }

        return new Meal(mealType, items);
    }

    public Meal getMeal(String mealType) {
        // prompted to change to switch statement but avoided as we were ins
        if (mealType.equals("breakfast")) {
            return meals.get(0);
        } else if (mealType.equals("lunch")) {
            return meals.get(1);
        } else if (mealType.equals("dinner")) {
            return meals.get(2);
        } else {
            // ERROR!
            return meals.get(2);
        }
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    @NonNull
    @Override
    public Iterator<Meal> iterator() {
        return mealCourseIterator;
    }

}
