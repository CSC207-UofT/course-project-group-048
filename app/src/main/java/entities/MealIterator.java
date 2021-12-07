package entities;

import java.util.Iterator;
import java.util.List;

class MealIterator<FoodItem> implements Iterator<FoodItem> {
    private List<FoodItem> foodItems;
    private int position;

    public MealIterator(List<FoodItem>  foodItems) {
        this.foodItems = foodItems;
        this.position = 0;
    }

    public boolean hasNext() {
        return (position != foodItems.size());
    }

    public FoodItem next() {
        if (foodItems.get(position) != null) {
            return (foodItems.get(position++));
        } else {
            return null;
        }
    }
}
