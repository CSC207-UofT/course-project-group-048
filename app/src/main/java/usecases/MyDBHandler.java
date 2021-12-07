package usecases;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.HashMap;

import entities.User;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "logindata.db";
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GOAL = "goal";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        System.out.println("Worrk!!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_HEIGHT + " DOUBLE, " +
                COLUMN_WEIGHT + " DOUBLE, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_GOAL + " BOOLEAN " +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void resetDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //Add new user to database.
    public void addUser(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPasswordHash());
        values.put(COLUMN_GENDER, user.getGender());
        values.put(COLUMN_HEIGHT, user.getHeight());
        values.put(COLUMN_WEIGHT, user.getWeight());
        values.put(COLUMN_AGE, user.getAge());
        values.put(COLUMN_GOAL, user.getGoal());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
    }

    public void UpdateDetails(String username, Integer newHeight, Integer newWeight, Integer newAge,
                              String newGender, String newGoal){
        String query = "UPDATE " + TABLE_USERS + " SET " + COLUMN_HEIGHT + " =\"" + newHeight +"\", " +
                COLUMN_WEIGHT + " =\"" + newWeight +"\", " + COLUMN_AGE + " =\"" + newAge +"\", " +
                COLUMN_GENDER + " =\"" + newGender + "\", " + COLUMN_GOAL + " =\"" + newGoal + "\"" +
                " WHERE " + COLUMN_USERNAME + " =\"" + username + "\";";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);

    }

    //Delete user from database.
    public void deleteUser(String username){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
    }


    //Return a hashmap of usernames and passwords stored in the database. Each username key maps to
    //its corresponding password value.
    public HashMap<String, User> getLoginData(){
        HashMap<String, User> loginData = new HashMap<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";

        // Cursor point to location in results.
        Cursor c = db.rawQuery(query, null);
        // Move to first row in results.
        c.moveToFirst();
        User user;

        // Read the database for usernames and their corresponding passwords.
        while (!c.isAfterLast()){
            String name = c.getString(c.getColumnIndexOrThrow("name"));
            String username = c.getString(c.getColumnIndexOrThrow("username"));
            String password = c.getString(c.getColumnIndexOrThrow("password"));
            String gender = c.getString(c.getColumnIndexOrThrow("gender"));
            int height = c.getInt(c.getColumnIndexOrThrow("height"));
            int weight = c.getInt(c.getColumnIndexOrThrow("weight"));
            int age = c.getInt(c.getColumnIndexOrThrow("age"));
            String goal = c.getString(c.getColumnIndexOrThrow("goal"));
            user = new User(name, username, password, gender, weight, height, age, goal);

            if(username!=null && password != null){
                loginData.put(username, user);
            }
            c.moveToNext();
        }
        db.close();
        return loginData;
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";

        //Cursor point to location in results.
        Cursor c = db.rawQuery(query, null);
        //Move to first row in results.
        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndexOrThrow("username"))!=null){
                dbString += c.getString(c.getColumnIndexOrThrow("username"));
                dbString += "  ";
                dbString += c.getString(c.getColumnIndexOrThrow("password"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}