package entities;

import java.util.Iterator;
import java.util.List;

public class Meal implements Iterable<FoodItem> {

    private final MealIterator mealIterator;
    private String type;
    private List<FoodItem> foodItems;
    private int calories;

    /**
     * The constructor for the Meal class.
     * @param type is the type of the meal (vegan, vegetarian, etc.)
     * @param foodItems is the a list of FoodItem objects that are contained in the meal
     */
    public Meal(String type, List<FoodItem> foodItems) {
        this.type = type;
        this.foodItems = foodItems;
        this.calories = calculateMealCalories();
        mealIterator = new MealIterator(foodItems);
    }

    /**
     * Calculates the calories for the meal.
     * @return the sum of the calories of each FoodItem in the meal.
     */
    private int calculateMealCalories() {
        int totalCalories = 0;

        for (FoodItem foodItem : foodItems) {
            totalCalories += foodItem.getCalories();
        }

        return totalCalories;
    }

    /**
     * A getter method for the calories attribute.
     * @return the calories of the meal.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * A getter method for the foodItems attribute.
     * @return a list of the FoodItem contained in the meal.
     */
    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    /**
     * A getter method for the type attribute.
     * @return the type of the meal (vegan, vegetarian, etc.)
     */
    public String getType() {
        return type;
    }

    /**
     * A getter method for the size of the meal.
     * @return the size of the meal, using the size method in the foodItems attribute
     */
    public int getSize() {
        return foodItems.size();
    }

    /**
     * Returns an iterator for the meal.
     * @return the iterator (MealCourseIterator) object for the meal, implemented using the
     * iterator design pattern.
     */
    @Override
    public Iterator<FoodItem> iterator() {
        return mealIterator;
    }

}
