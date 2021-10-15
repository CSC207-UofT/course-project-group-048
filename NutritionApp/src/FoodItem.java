import java.util.HashMap;

public class FoodItem {
    /** FoodItem stores food name, type(fruit, vegetable, meat etc.),
     * its nutritional facts in a certain amount.
     */
    String name;
    String type;
    int amount; /* amount of food in grams or units*/
    HashMap<String, Integer> nutrients;

    /**
     * @param name name of the food
     * @param type type of the food(fruit, veg, meat etc.)
     * @param amount amount of the food
     * @param carbs amount of contained carbohydrates
     * @param fat amount of contained fat
     * @param protein amount of contained protein
     */

    public FoodItem(String name, String type, int amount, Integer carbs,
                    Integer fat, Integer protein) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.nutrients = new HashMap<>();
        this.nutrients.put("fat", fat);
        this.nutrients.put("protein", protein);
        this.nutrients.put("carbohydrates", carbs);
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
