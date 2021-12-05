package nutrition;/*
   FoodItem stores food name, type (fruit, vegetable, meat etc.)
   and its amount in grams and its corresponding nutritional values(carbohydrates, protein and fat)
 */

import java.util.HashMap;

public class FoodItem{
    String name;
    int amount;
    String[] types;
    Integer[] nutrition;

    /**
     * @param name name of the food
     * @param amount amount of the food
     * @param types type of the foo(food category, diet and meal type)
     * @param nutrition nutritional info of the FoodItem(calories, carbohydrates, fat, and protein in grams)
     */
    public FoodItem(String name, int amount, String[] types, Integer[] nutrition) {
        this.name = name;
        this.amount = amount;
        this.types = types;
        this.nutrition = nutrition;



    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }

}