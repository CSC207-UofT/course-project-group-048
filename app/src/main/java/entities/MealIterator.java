package entities;

import java.util.Iterator;
import java.util.List;

class MealIterator<FoodItem> implements Iterator<FoodItem> {
    private final List<FoodItem> foodItems;
    private int position;

    /**
     * An Iterator for the Meal objects.
     * @param foodItems A list of FoodItem objects in the meal.
     */

    public MealIterator(List<FoodItem>  foodItems) {
        this.foodItems = foodItems;
        this.position = 0;
    }

    /**
     * Checks if the foodItems attribute has a next item.
     * @return true if the position in the foodItems of the iterator is not the last,
     * or false if it is.
     */
    public boolean hasNext() {
        return (position != foodItems.size());
    }

    /**
     * Returns the next FoodItem in the foodItems attribute, using the position attribute.
     * @return the next FoodItem object in foodItems.
     */
    public FoodItem next() {
        if (foodItems.get(position) != null) {
            return (foodItems.get(position++));
        } else {
            return null;
        }
    }
}
