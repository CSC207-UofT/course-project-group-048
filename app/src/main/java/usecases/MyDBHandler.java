package usecases;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;


import entities.FoodItem;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NutritionApp.db";

    protected static final String TABLE_USERS = "users";
    protected static final String COLUMN_ID = "_id";
    protected static final String COLUMN_FULL_NAME = "name";
    protected static final String COLUMN_USERNAME = "username";
    protected static final String COLUMN_PASSWORD = "password";
    protected static final String COLUMN_GENDER = "gender";
    protected static final String COLUMN_HEIGHT = "height";
    protected static final String COLUMN_WEIGHT = "weight";
    protected static final String COLUMN_AGE = "age";
    protected static final String COLUMN_GOAL = "goal";

    protected static final String TABLE_FOODITEMS = "fooditems";
    protected static final String COLUMN_FOOD_NAME = "Name";
    protected static final String COLUMN_CALORIES = "Calories";
    protected static final String COLUMN_TYPES = "Types";
    protected static final String COLUMN_NUTRITION = "Nutrition";

    public MyDBHandler(Context context, SQLiteDatabase.CursorFactory factory){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = " CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FULL_NAME + " TEXT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_HEIGHT + " DOUBLE, " +
                COLUMN_WEIGHT + " DOUBLE, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_GOAL + " BOOLEAN " +
                ");";

        String query2 = "CREATE TABLE " + TABLE_FOODITEMS + "(" +
                COLUMN_FOOD_NAME + " TEXT, " +
                COLUMN_CALORIES + " INTEGER, " +
                COLUMN_TYPES + " TEXT, " +
                COLUMN_NUTRITION + " TEXT " +
                ");";

        db.execSQL(query1);
        db.execSQL(query2);

        addStandardFoods(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODITEMS);
        onCreate(db);
    }

    public void resetDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODITEMS);
        onCreate(db);
    }


    private void addStandardFoods(SQLiteDatabase db) {
        FoodItems foodItems = new FoodItems();
        for (FoodItem food : foodItems.foodList) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_FOOD_NAME, food.getName());
            values.put(COLUMN_CALORIES, food.getCalories());
            values.put(COLUMN_TYPES, food.getStringTypes());
            values.put(COLUMN_NUTRITION, food.getStringNutrition());
            db.insert(TABLE_FOODITEMS, null, values);
        }
    }

}