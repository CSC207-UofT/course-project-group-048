package nutrition;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MealDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "foodinfo.db";
    public static final String TABLE_FOODITEMS = "fooditems";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_CALORIES = "Calories";
    public static final String COLUMN_TYPES = "Types";

    public MealDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_FOODITEMS + "(" +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CALORIES + " INTEGER, " +
                COLUMN_TYPES + " TEXT " +
                ");";
        db.execSQL(query);
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
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FOODITEMS, null, values);
        db.close();
    }

    public void deleteFood(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_FOODITEMS + " WHERE " + COLUMN_NAME + "=\"" + name + "\";");
    }
}
