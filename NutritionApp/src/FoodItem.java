import java.util.HashMap;

public class FoodItem {
    /** FoodItem stores food name, type(fruit, vegetable, meat etc.),
     * its amount.
     */
    String name;
    String type;
    int amount; /* amount of food in grams or units*/


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
