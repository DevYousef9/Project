package com.dvb.electroniclibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;



public class dataconection extends  SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "db";

    // Contacts table name


    // Contacts Table Columns names
    public static final String S_TABLE = "student";
    public static final String s_id = "ID";
    public static final String s_name = "NAME";
    public static final String s_collage = "COLLAGE";
    public static final String s_section = "SECTION";
    public static final String s_password = "PASS";
    public static final String s_email = "E_MAIL";
    public static final String s_level = "LEVEL";

    private final ArrayList<Student> contact_list = new ArrayList<Student>();

    public dataconection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + S_TABLE + "("
                + s_id + " TEXT," + s_name + " TEXT,"
                + s_collage + " TEXT," + s_section + " TEXT,"    + s_password + " TEXT," +  s_email + " TEXT,"   + s_level + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }




    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + S_TABLE);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new student
    public void Add_student(Student student) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(s_name, student.getName()); // Contact Name
            values.put(s_password, student.getPassword()); // Contact Phone
            values.put(s_email, student.getEmail()); // Contact Email
            values.put(s_level , student.getLevel());
            values.put (s_collage , student.getCollage());
            values.put (s_section , student.getSection());
            // Inserting Row
            db.insert(S_TABLE, null, values);
            db.close(); // Closing database connection




    }

    // Getting single contact
    Student Get_Contact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(S_TABLE, new String[] { s_id,
                        s_name, s_password, s_email ,s_level,s_section,s_collage }, s_id + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student dbstudent = new Student (Integer.parseInt(cursor.getString(0)),
                 cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),Integer.parseInt(cursor.getString(5)),Integer.parseInt(cursor.getString(6)));

        cursor.close();
        db.close();

        return dbstudent;
    }

    // Getting All Contacts
    public ArrayList<Student> Get_Contacts() {
        try {
            contact_list.clear();

            // Select All Query
            String selectQuery = "SELECT  * FROM " + S_TABLE;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {

                    Student contact = new Student();
                    contact.setId(Integer.parseInt(cursor.getString(0)));
                    contact.setName(cursor.getString(1));
                    contact.setPassword(cursor.getInt(2));
                    contact.setEmail(cursor.getString(3));
                    contact.setCollage(cursor.getString(4));
                    contact.setLevel(cursor.getInt(5));
                    contact.setSection(cursor.getString(6));

                    // Adding contact to list
                    contact_list.add(contact);
                } while (cursor.moveToNext());
            }

            // return contact list
            cursor.close();
            db.close();
            return contact_list;
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("all_contact", "" + e);
        }

        return contact_list;
    }

    // Updating single contact
    public int Update_Contact(Student contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(s_name, contact.getName());
        values.put(s_password, contact.getPassword());
        values.put(s_email, contact.getEmail());
        values.put(s_collage, contact.getCollage());
        values.put(s_level, contact.getLevel());
        values.put(s_section, contact.getSection());
        values.put(s_id, contact.getId());


        // updating row
        return db.update(S_TABLE, values, s_id + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }

    // Deleting single contact
    public void Delete_Contact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(S_TABLE, s_id + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Getting contacts Count
    public int Get_Total_Contacts() {
        String countQuery = "SELECT  * FROM " + S_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }



}
