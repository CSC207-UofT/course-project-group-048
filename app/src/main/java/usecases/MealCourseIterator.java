package usecases;

import java.util.Iterator;
import java.util.List;

class MealCourseIterator<Meal> implements Iterator<Meal> {
    private final List<Meal> meals;
    private int position;

    /**
     * The constructor for the MealCourseIterator
     * @param meals this parameter is a list of Meal objects, the primary object the iterator
     *              iterates through.
     */
    public MealCourseIterator(List<Meal> meals) {
        this.meals = meals;
        this.position = 0;
    }

    /**
     * Checks whether the meals attribute has another meal object in it, where the reference point
     * for the current meal object is set using the position attributee.
     * @return true if the meals attribute has additional meal objects, and false otherwise.
     */
    public boolean hasNext() {
        return (position != meals.size());
    }

    /**
     * Uses the position attribute to find and return the next Meal object in the meals attribute.
     * @return the next meal object in the meals attribute (using the position attribute as
     * the reference for the current meal object).
     */
    public Meal next() {
        if (meals.get(position) != null) {
            return (meals.get(position++));
        } else {
            return null;
        }
    }

}