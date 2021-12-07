package entities;

import java.util.Iterator;
import java.util.List;

public class Meal implements Iterable<FoodItem> {

    private final MealIterator mealIterator;
    private String type;
    private List<FoodItem> foodItems;
    private int calories;

    public Meal(String type, List<FoodItem> foodItems) {
        this.type = type;
        this.foodItems = foodItems;
        this.calories = calculateMealCalories();
        mealIterator = new MealIterator(foodItems);
    }

    private int calculateMealCalories() {
        int totalCalories = 0;

        for (FoodItem foodItem : foodItems) {
            totalCalories += foodItem.getCalories();
        }

        return totalCalories;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public Iterator<FoodItem> iterator() {
        return mealIterator;
    }

}
