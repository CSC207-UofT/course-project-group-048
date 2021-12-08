package usecases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import entities.FoodItem;

public class MealDataHandler extends MyDBHandler {

    /**
     * Creates an instance of the MealDataHandler object.
     * @param context the current state of the application representing the context in which the
     *                database exists.
     * @param factory allows returning subclasses of Cursor when calling a query in our database.
     */
    public MealDataHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, factory);
    }

    /**
     * Adds a new foodItem to the database.
     * @param foodItem the foodItem object to be added to the database, used to retrieve
     *                 information about itself.
     */
    public void addFood(FoodItem foodItem){
        ContentValues values = new ContentValues();
        values.put(COLUMN_FOOD_NAME, foodItem.getName());
        values.put(COLUMN_CALORIES, foodItem.getCalories());
        values.put(COLUMN_TYPES, foodItem.getStringTypes());
        values.put(COLUMN_NUTRITION, foodItem.getStringNutrition());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FOODITEMS, null, values);
    }

    /**
     * Deletes a food item from the database.
     * @param name the name of the food item to be deleted.
     */
    public void deleteFood(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_FOODITEMS + " WHERE " + COLUMN_FOOD_NAME + "=\"" + name + "\";");
    }

    /**
     * Checks whether the given database is empty or not.
     * @param db is the database that is checked (for emptiness) in the method.
     * @return true if the database db is empty, false otherwise.
     */
    public boolean isEmpty(SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOODITEMS, null);
        return cursor.getCount() == 0;

    }

    /**
     * Returns all of the foodItem objects that have their data in the database.
     * @return a list of FoodItem objects contained in the database.
     */
    public List<FoodItem> getAll() {
        List<FoodItem> finalList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_FOODITEMS;
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
             do {
                 String foodItem = c.getString(0);
                 int calories = c.getInt(1);
                 String[] types = processCommaList(c.getString(2));
                 int[] nutrition = processNutrientsArray(c.getString(3));

                 FoodItem newItem = new FoodItem(foodItem, calories, types, nutrition);
                 finalList.add(newItem);
            }
            while (c.moveToNext());
        }

        c.close();
        return finalList;
    }

    /**
     * A helper method intended to process comma separated list as required.
     * @param string a string, which is the comma separated list to be parsed.
     * @return an array of strings, each one being a string from the comma separated list in the
     * string parameter
     */
    private String[] processCommaList(String string) {
        // fish, lunch, vegetarian,
        string = string.replace(",", "");
        return string.split(" ");
    }

    /**
     * Processes the string representation of the nutrients attribute of a foodItem back into
     * its original format as an array of integers.
     * @param numericCommaString the string that contains comma separated numeric substrings
     *                           representing the nutritional information of a food item in our
     *                           database.
     * @return an array of integers representing the nutrients represented in the numericCommaString
     */
    private int[] processNutrientsArray(String numericCommaString) {
        // 23, 4, 0, 0,
        String[] numbersStringArray = processCommaList(numericCommaString);
        int[] nutrientsArray = new int[numbersStringArray.length];
        for (int i = 0; i < numbersStringArray.length; i++) {
            nutrientsArray[i] = Integer.parseInt(numbersStringArray[i]);
        }
        return nutrientsArray;
    }
}
