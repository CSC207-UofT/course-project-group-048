package usecases;

import java.util.Iterator;
import java.util.List;

class MealCourseIterator<Meal> implements Iterator<Meal> {
    private List<Meal> meals;
    private int position;

    public MealCourseIterator(List<Meal> meals) {
        this.meals = meals;
        this.position = 0;
    }

    public boolean hasNext() {
        return (position != meals.size());
    }

    public Meal next() {
        if (meals.get(position) != null) {
            return (meals.get(position++));
        } else {
            return null;
        }
    }

}