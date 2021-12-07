package usecases;

import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import entities.FoodItem;
import entities.Meal;

public class MealCourse implements Iterable<Meal> {
    private final MealCourseIterator mealCourseIterator;
    private List<Meal> meals;
    private List<FoodItem> foodItemList;
    private int targetCalories;
    private int calories;

    public MealCourse(List<Meal> meals, Context context) {
        this.meals = meals;
        loadFoodList(context);
        mealCourseIterator = new MealCourseIterator(meals);
    }

    public MealCourse(int targetCalories, Context context) {
        this.targetCalories = targetCalories;
        loadFoodList(context);
        refreshAllMeals();
        mealCourseIterator = new MealCourseIterator(meals);
    }

    public void refreshAllMeals() {
        calories = 0;
        int caloriesAllowed = targetCalories;
        String[] mealTypes = new String[]{"breakfast", "lunch", "dinner"};
        meals = new ArrayList<Meal>(mealTypes.length);
        Meal meal;

        for (String mealType : mealTypes) {
            meal = generateMeal(2, mealType, caloriesAllowed);
            meals.add(meal);
            caloriesAllowed -= meal.getCalories();
            calories += meal.getCalories();
        }
    }

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

    private int calculateAllowedMealCalories(String mealType) {
        int otherMealCalories = 0;
        for (Meal meal : meals) {
            if (!meal.getType().equals(mealType)) {
                otherMealCalories += meal.getCalories();
            }
        }

        return calories - otherMealCalories;
    }

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

    public Meal getMeal(String mealType) {
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

    @Override
    public Iterator<Meal> iterator() {
        return mealCourseIterator;
    }

}
