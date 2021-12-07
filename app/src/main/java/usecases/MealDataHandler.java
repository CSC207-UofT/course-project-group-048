package usecases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import entities.FoodItem;

public class MealDataHandler extends MyDBHandler {

    public MealDataHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, factory);
    }

    public void addFood(FoodItem foodItem){
        ContentValues values = new ContentValues();
        values.put(COLUMN_FOOD_NAME, foodItem.getName());
        values.put(COLUMN_CALORIES, foodItem.getCalories());
        values.put(COLUMN_TYPES, foodItem.getStringTypes());
        values.put(COLUMN_NUTRITION, foodItem.getStringNutrition());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FOODITEMS, null, values);
    }

    public void deleteFood(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_FOODITEMS + " WHERE " + COLUMN_FOOD_NAME + "=\"" + name + "\";");
    }

    public boolean isEmpty(SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FOODITEMS, null);
        return cursor.getCount() == 0;

    }

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

    private String[] processCommaList(String string) {
        // fish, lunch, vegetarian,
        string = string.replace(",", "");
        return string.split(" ");
    }

    private int[] processNutrientsArray(String numericCommaString) {
        // 23, 4, 0, 0,
        String[] numbersStringArray = processCommaList(numericCommaString);
        int[] nutrientsArray = new int[numbersStringArray.length];
        for (int i = 0; i < numbersStringArray.length; i++) {
            nutrientsArray[i] = Integer.parseInt(numbersStringArray[i]);
        }
        return nutrientsArray;
    }

    // implement meal plan algorithm in this class, for different meals and than maybe seperate later
    // or in meal generator using a list
}
