/*
   FoodItem stores food name, type (fruit, vegetable, meat etc.)
   and its amount in grams and its corresponding nutritional values(carbohydrates, protein and fat)
 */

import java.util.HashMap;

public class FoodItem{
    String name;
    String type;
    int amount;
    String classification;
    HashMap<String, Double> nutrients;


    /**
     * @param name name of the food
     * @param type type of the food(fruit, veg, meat etc.)
     * @param amount amount of the food
     * @param classification classification of the FoodItem(breakfast, lunch, dinner and snacks)

     */
    public FoodItem(String name, String type, int amount, String classification) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.classification = classification;



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
    public String getClassification() {return classification;}


    public void setClassification(String newclassf){
        this.classification = newclassf;
    }
    }
