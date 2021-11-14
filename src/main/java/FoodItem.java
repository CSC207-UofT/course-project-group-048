/*
   FoodItem stores food name, type (fruit, vegetable, meat etc.)
   and its amount in grams and its corresponding nutritional values(carbohydrates, protein and fat)
 */

import java.util.HashMap;

public class FoodItem{
    String name;
    String type;
    int amount;
    String mealtype;
    String diettype;
    String[] types;


    /**
     * @param name name of the food
     * @param type type of the food(fruit, veg, meat etc.)
     * @param amount amount of the food
     * @param mealtype type of meal(breakfast, lunch, dinner and snacks)
     * @param diettype specific diet if it is applicable(vegan, vegetarian, none, or glutenfree)

     */
    public FoodItem(String name, String type, int amount, String mealtype, String diettype) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.mealtype = mealtype;
        this.diettype = diettype;
        this.types = new String[] {this.type, this.diettype, this.mealtype};



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
    public String getMealtype() {return mealtype;}


    public void setClassification(String newmealtype){
        this.mealtype = newmealtype;
    }
    }
