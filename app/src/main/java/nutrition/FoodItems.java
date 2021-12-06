package nutrition;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;


public class FoodItems {

    public static final ArrayList<FoodItem> foodList = new ArrayList<>();
    public static final HashMap<Integer, ArrayList<FoodItem>> meals = new HashMap<Integer, ArrayList<FoodItem> >();

    final static FoodItem ORANGE = new FoodItem("orange", 50,
            new String[]{"fruit","snack", "vegan"}, new Integer[]{23, 4, 0, 0});
    final static FoodItem APPLE = new FoodItem("apple", 182,
            new String[] {"fruit", "snack", "vegan"}, new Integer[]{95, 25, 0, 0});
    final static FoodItem BANANA = new FoodItem("banana", 118,
            new String[]  {"fruit", "snack", "vegan"}, new Integer[]{105, 27, 0, 1});
    final static FoodItem EGG = new FoodItem("egg", 70,
            new String[] {"dairy", "breakfast", "vegetarian"}, new Integer[]{70, 0, 5, 6});
    final static FoodItem BROCCOLI = new FoodItem("broccoli", 100,
            new String[] {"vegetable","lunch","vegan"}, new Integer[]{34, 7, 0, 3});
    final static FoodItem WHITEBREAD = new FoodItem("white bread",
            40, new String[] {"grain", "vegetarian", "breakfast"}, new Integer[]{50, 9, 1, 2});
    final static FoodItem CEREAL = new FoodItem("cereal", 30,
            new String[] {"grain", "breakfast", "vegetarian"}, new Integer[]{113, 23, 1, 2});
    final static FoodItem CHICKENBREAST = new FoodItem("chicken breast",
            85, new String[]  {"poultry", "dinner", "none"}, new Integer[]{110, 2, 3, 20});
    final static FoodItem WHITERICE = new FoodItem("white rice",
            45, new String[] {"grain", "dinner", "vegan"}, new Integer[]{160, 38, 0, 3});
    final static FoodItem PASTA = new FoodItem("pasta", 72,
            new String[] {"grain", "dinner", "vegetarian"}, new Integer[]{265, 54, 1, 9});
    final static FoodItem ICECREAM = new FoodItem("ice cream",
            100, new String[] {"dessert", "snack", "vegetarian"}, new Integer[]{250, 25, 10, 4});
    final static FoodItem CHOCOLATE = new FoodItem("chocolate",
            20, new String[] {"dessert", "snack", "vegetarian"}, new Integer[]{22, 2, 1, 1});
    final static FoodItem FRENCHFRIES = new FoodItem("french fries",
            84, new String[] {"vegetable", "lunch", "vegan"}, new Integer[]{120, 20, 4, 2});
    final static FoodItem CHICKPEAS = new FoodItem("chickpeas",
            100, new String[] {"legume", "snack", "vegan"}, new Integer[]{46, 8, 1, 2});
    final static FoodItem OATS = new FoodItem("oats",
            100, new String[] {"grain", "breakfast", "vegan"}, new Integer[]{371, 59, 8, 12});
    final static FoodItem STEAK = new FoodItem("steak", 113,
            new String[] {"meat", "dinner", "none"}, new Integer[]{170, 0, 9, 23});
    final static FoodItem TOMATO= new FoodItem("tomato", 60,
            new String[] {"vegetable", "lunch", "vegan"}, new Integer[]{11, 2, 0, 1});
    final static FoodItem PEANUTS = new FoodItem("peanuts", 30,
            new String[] {"legume", "snack", "vegan"}, new Integer[]{161, 5, 14, 7});
    final static FoodItem COOKIES = new FoodItem("cookies", 20,
            new String[] {"dessert", "snack", "vegetarian"}, new Integer[]{220, 30, 10, 2});
    final static FoodItem NOODLES = new FoodItem("noodle", 60,
            new String[] {"grain", "dinner", "vegetarian"}, new Integer[]{200, 41, 1, 7});
    final static FoodItem LETTUCE = new FoodItem("lettuce", 50,
            new String[] {"vegetable", "lunch", "vegan"}, new Integer[]{4, 2, 0, 0});
    final static FoodItem GRAPES = new FoodItem("grapes", 100,
            new String[]{"fruit","snack", "vegan"}, new Integer[]{23, 4, 0, 0});
    final static FoodItem STRAWBERRIES = new FoodItem("strawberries", 50,
            new String[]{"fruit","snack", "vegan"}, new Integer[]{23, 4, 0, 0});


    public FoodItems() {
        foodList.add(ORANGE);
        foodList.add(APPLE);
        foodList.add(BANANA);
        foodList.add(EGG);
        foodList.add(BROCCOLI);
        foodList.add(WHITEBREAD);
        foodList.add(CEREAL);
        foodList.add(CHICKENBREAST);
        foodList.add(WHITERICE);
        foodList.add(PASTA);
        foodList.add(ICECREAM);
        foodList.add(CHOCOLATE);
        foodList.add(FRENCHFRIES);
        foodList.add(CHICKPEAS);
        foodList.add(OATS);
        foodList.add(STEAK);
        foodList.add(TOMATO);
        foodList.add(PEANUTS);
        foodList.add(COOKIES);
        foodList.add(LETTUCE);
        foodList.add(NOODLES);
    }
}
