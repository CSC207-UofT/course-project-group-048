package usecases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

import entities.User;

public class LoginDataHandler extends MyDBHandler {

    /**
     * Creates an instance of the LoginDataHandler object.
     * @param context the current state of the application representing the context in which the
     *                database exists
     * @param factory allows returning subclasses of Cursor when calling a query in our database
     */
    public LoginDataHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, factory);
    }

    /**
     * Adds a user to the database.
     * @param user this object is used to retrieve information about the user and
     */
    // Add new user to database.
    public void addUser(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULL_NAME, user.getName());
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

    /**
     * Updates the details of a user in the database.
     * @param username the username of the user who's information is being updates
     * @param newHeight an integer representing the new height of the user
     * @param newWeight an integer representing the new weight of the user
     * @param newAge an integer representing the new age of the user
     * @param newGender an integer representing the new gender of the user
     * @param newGoal an integer representing the new goal set by the user
     */
    public void UpdateDetails(String username, Integer newHeight, Integer newWeight, Integer newAge,
                              String newGender, String newGoal){
        String query = "UPDATE " + TABLE_USERS + " SET " + COLUMN_HEIGHT + " =\"" + newHeight +"\", " +
                COLUMN_WEIGHT + " =\"" + newWeight +"\", " + COLUMN_AGE + " =\"" + newAge +"\", " +
                COLUMN_GENDER + " =\"" + newGender + "\", " + COLUMN_GOAL + " =\"" + newGoal + "\"" +
                " WHERE " + COLUMN_USERNAME + " =\"" + username + "\";";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);

    }

    /**
     * Delete user from database.
     * @param username the username of the user we are trying to delete
     */
    public void deleteUser(String username){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
    }


    /**
     * Returns a hashmap containing login information (username and user object) for each user.
     * Each username key maps to its corresponding password value.
     * @return a hashmap of usernames and user objects (containing passwords
     * stored in the database.
     */
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
        c.close();
        return loginData;
    }

    /**
     * Returns a string representing all of the information in the database
     * @return a string representation of the information in the database.
     */
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
        return dbString;
    }

}
