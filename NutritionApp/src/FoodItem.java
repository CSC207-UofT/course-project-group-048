public class FoodItem implements Nutrient{
    String name;
    String type;
    int amount; /* amount of food in grams */

    public FoodItem(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

}
