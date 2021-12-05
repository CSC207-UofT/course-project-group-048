package nutrition;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "logininfo.db";
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

    //Delete user from database.
    public void deleteUser(String username){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
    }


    //Return a hashmap of usernames and passwords stored in the database. Each username key maps to
    //its corresponding password value.
    public HashMap<String, String> GetLoginData(){
        HashMap<String, String> LoginData = new HashMap<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";

        //Cursor point to location in results.
        Cursor c = db.rawQuery(query, null);
        //Move to first row in results.
        c.moveToFirst();

        //Read the database for usernames and their corresponding passwords.
        while (!c.isAfterLast()){
            String username = c.getString(c.getColumnIndexOrThrow("username"));
            String password = c.getString(c.getColumnIndexOrThrow("password"));
            if(username!=null && password != null){
                LoginData.put(username, password);
            }
            c.moveToNext();
        }
        db.close();
        return LoginData;
    }

    //Print database as string. (We won't be needing this for the final app. I just added this to
    //see whether my code works. We will keep it for now and remove it in the end.)

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
