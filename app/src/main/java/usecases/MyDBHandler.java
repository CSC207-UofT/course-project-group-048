package usecases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public MyDBHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    /**
     * Overrides the onCreate method, which is ran upon creation of a database, helping create
     * the initial columns and rows of data that are standard and required to all databases.
     *
     * @param db the database that this method is being ran on (when it is created)
     */
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

    /**
     * Upgrades the version of a database from its current version (oldVersion) to the new inputted
     * version (newVersion).
     *
     * @param db         the database which is to be upgraded.
     * @param oldVersion the oldVersion (or current version) of the database db.
     * @param newVersion the new version of the database to be upgraded to.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODITEMS);
        onCreate(db);
    }

    /**
     * Resets the current database, removing all changes, additions and deletions, restoring its
     * format to that which is seen when it is initially created.
     */
    public void resetDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODITEMS);
        onCreate(db);
    }

    /**
     * Adds the standard food items to the database, used to generate the standard meals provided
     * by the application.
     *
     * @param db the database to which the standard food items are being added.
     */
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