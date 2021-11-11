/*
    A database of food items.
 */


import java.lang.reflect.Field;

public class FoodItems {
    final static FoodItem ORANGE = new FoodItem("orange", "fruit", 50, "snack");
    final static FoodItem APPLE = new FoodItem("apple", "fruit", 41, "snack");
    final static FoodItem BANANA = new FoodItem("banana", "fruit", 70, "snack");
    final static FoodItem EGG = new FoodItem("egg", "dairy", 30, "breakfast");
    final static FoodItem BROCCOLI = new FoodItem("broccoli", "vegetable", 50, "lunch");
    final static FoodItem WHITEBREAD = new FoodItem("white bread", "gain", 60, "breakfast");
    final static FoodItem CEREAL = new FoodItem("cereal", "gain", 30, "breakfast");
    final static FoodItem CHICKENBREAST = new FoodItem("chicken breast", "poultry",
            120, "dinner");
    final static FoodItem WHITERICE = new FoodItem("white rice", "grain", 200, "dinner");
    final static FoodItem PASTA = new FoodItem("pasta", "grain", 180, "dinner");
    final static FoodItem ICECREAM = new FoodItem("ice cream", "dessert", 60, "snack");
    final static FoodItem CHOCOLATE = new FoodItem("chocolate", "dessert", 20, "snack");
    final static FoodItem FRENCHFRIES = new FoodItem("french fries", "vegetable", 90, "lunch");
    final static FoodItem CHICKPEAS = new FoodItem("chickpeas", "legume", 150, "snack");
    final static FoodItem OATS = new FoodItem("oats", "grain", 40, "breakfast");
    final static FoodItem STEAK = new FoodItem("steak", "meat", 130, "dinner");
    final static FoodItem TOMATO= new FoodItem("tomato", "vegetable", 50, "lunch");
    final static FoodItem PEANUTS = new FoodItem("peanuts", "legume", 30, "snack");
    final static FoodItem COOKIES = new FoodItem("cookies", "dessert", 30, "snack");
    final static FoodItem NOODLES = new FoodItem("noodle", "grain", 180, "dinner");
    final static FoodItem LETTUCE = new FoodItem("lettuce", "vegetable", 30, "lunch");

    public void main(String[] args) {
        Field[] fooditems = FoodItems.class.getDeclaredFields();
    }
}
