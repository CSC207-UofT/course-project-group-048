/*
   FoodItem stores food name, type (fruit, vegetable, meat etc.)
   and its amount in grams or units.
 */

public class FoodItem implements Nutrient {
    String name;
    String type;
    int amount;


    /**
     * @param name name of the food
     * @param type type of the food(fruit, veg, meat etc.)
     * @param amount amount of the food
     */
    public FoodItem(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;

    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getAmount() {
        return amount;
    }


}
