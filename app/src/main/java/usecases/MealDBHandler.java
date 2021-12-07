package usecases;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

import entities.FoodItem;

public class MealDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "foodinfo.db";
    public static final String TABLE_FOODITEMS = "fooditems";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_CALORIES = "Calories";
    public static final String COLUMN_TYPES = "Types";
    public static final String COLUMN_NUTRITION = "Nutrition";

    public MealDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_FOODITEMS + "(" +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CALORIES + " INTEGER, " +
                COLUMN_TYPES + " TEXT, " +
                COLUMN_NUTRITION + " TEXT " +
                ");";
        db.execSQL(query);
        if (!isEmpty(db)){
            addStandardFoods();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODITEMS);
        onCreate(db);
    }

    public void addFood(FoodItem foodItem){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, foodItem.getName());
        values.put(COLUMN_CALORIES, foodItem.getCalories());
        values.put(COLUMN_TYPES, foodItem.getStringTypes());
        values.put(COLUMN_NUTRITION, foodItem.getStringNutrition());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FOODITEMS, null, values);
        db.close();
    }



    public void deleteFood(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_FOODITEMS + " WHERE " + COLUMN_NAME + "=\"" + name + "\";");
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
                String[] types = FoodItem.getTypesFromString(c.getString(2));
                Integer[] nutrition = FoodItem.getNutsFromString(c.getString(3));
                FoodItem newItem = new FoodItem(foodItem, calories, types, nutrition);
                finalList.add(newItem);
            }
            while (c.moveToNext());
        }
        c.close();
        return finalList;
    }

    // implement meal plan algorithm in this class, for different meals and than maybe seperate later
    // or in meal generator using a list

    public void addStandardFoods() {
        SQLiteDatabase db = getWritableDatabase();
        for (FoodItem food : FoodItems.foodList) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, food.getName());
            values.put(COLUMN_CALORIES, food.getCalories());
            values.put(COLUMN_TYPES, food.getStringTypes());
            values.put(COLUMN_NUTRITION, food.getStringNutrition());
            db.insert(TABLE_FOODITEMS, null, values);
        }
        db.close();
    }



}
