package entities;
/*
   FoodItem stores food name, type (fruit, vegetable, meat etc.)
   and its amount in grams and its corresponding nutritional values(carbohydrates, protein and fat)
 */

import androidx.annotation.NonNull;

public class FoodItem {

    public String name;
    public int calories;
    public String[] types;
    public int[] nutrients;

    /**
     * A class representing a FoodItem object.
     *
     * @param name      name of the food
     * @param cals      amount of the food
     * @param types     type of the food (food category, diet and meal type)
     * @param nutrients nutrients of the food item
     */

    public FoodItem(String name, int cals, String[] types, int[] nutrients) {
        this.name = name;
        this.calories = cals;
        this.types = types;
        this.nutrients = nutrients;
    }

    /**
     * A getter method for the types parameter.
     *
     * @return the types parameter (an array of strings) that contains information about the food.
     */

    public String[] getTypes() {
        return types;
    }

    /**
     * A getter method for the name parameter.
     *
     * @return the name of the food.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method for the calories
     *
     * @return the calories of the food.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * A getter method for types, returning a string instead of an array.
     *
     * @return a parsed string containing the information of the types instance attribute.
     */
    public String getStringTypes() {
        // the logic here is to take the list of types, and return a string representation of it
        // POSSIBLY: implement a sanity check of types, or only allow certain allowed in a certain
        // order
        // ALSO: string representation should be readable by code, follow a pattern,
        // strip whitespace, join with spaces
        //
        StringBuilder s = new StringBuilder();
        for (String value : types) {
            String type = value.replaceAll("\\s+", "");
            s.append(type).append(", ");
        }
        return s.toString().trim();
    }

    /**
     * A setter method for the name attribute.
     *
     * @param name is the name we want to set the name parameter to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A setter method for the calories attribute.
     *
     * @param calories is the integer we want to set the calories attribute to.
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * A setter method for the types attribute.
     *
     * @param types is an array of string containing information about the food.
     */
    public void setTypes(String[] types) {
        this.types = types;
    }

    /**
     * A getter method for the nutrients attribute.
     *
     * @return the nutrients attribute, an array of ints.
     */
    public int[] getNutrients() {
        return nutrients;
    }

    /**
     * A setter method for the nutrients attribute.
     *
     * @param nutrients is an array of ints that represent the nutrients of the food.
     */
    public void setNutrients(int[] nutrients) {
        this.nutrients = nutrients;
    }

    /**
     * A getter method for the nutrition parameter.
     *
     * @return a parsed string instead of an array, representing the nutrition attribute.
     */
    public String getStringNutrition() {
        StringBuilder s = new StringBuilder();
        for (int value : nutrients) {
            String amount = String.valueOf(value);
            s.append(amount).append(", ");
        }
        return s.toString().trim();

    }

    /**
     * A method to return the string representation of the food.
     *
     * @return a string representation of the food, containing its name and calories.
     */
    @NonNull
    public String toString() {
        return name + ": " + calories + " calories";
    }
}