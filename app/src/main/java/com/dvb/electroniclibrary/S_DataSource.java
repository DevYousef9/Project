package com.dvb.electroniclibrary;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
// conection data beas


public class S_DataSource {
    dataconection sql ;
    SQLiteDatabase mysql;
    String[] ALL_S = new String[]{dataconection.s_id , dataconection.s_name , dataconection.s_collage , dataconection.s_section , dataconection.s_password
            , dataconection.s_email , dataconection.s_level};

    public S_DataSource(Context context){
        sql = new dataconection(context);
    }

    public void open(){
        try{
            mysql = sql.getWritableDatabase();
        }catch (Exception e){
            Log.d("ERROR", e.getMessage());
        }
    }

    public void close(){
        mysql.close();
    }

    public void C_Student( String name , String id , String collage , String section , String password
                          , String email , String level){
        ContentValues S_List = new ContentValues();
        S_List.put(dataconection.s_id , id);
        S_List.put(dataconection.s_name , name);
        S_List.put(dataconection.s_collage , collage);
        S_List.put(dataconection.s_section , section);
       S_List.put(dataconection.s_password , password);
       S_List.put(dataconection.s_email , email);
        S_List.put(dataconection.s_level , level);
        mysql.insert(dataconection.S_TABLE ,null , S_List);
    }

    public void U_Student(int id , String name , String collage , String section , int password , String email
            , int level ){
        ContentValues S_List = new ContentValues();
        S_List.put(dataconection.s_id , id);
        S_List.put(dataconection.s_name , name);
        S_List.put(dataconection.s_collage , collage);
        S_List.put(dataconection.s_section , section);
        S_List.put(dataconection.s_password , password);
        S_List.put(dataconection.s_email , email);
        S_List.put(dataconection.s_level , level);
        mysql.update(dataconection.S_TABLE ,S_List , dataconection.s_password + " = " + password + dataconection.s_email + " = " + email, null);
    }

    public void D_Student(int id ){
        mysql.delete(dataconection.S_TABLE , dataconection.s_id + " = " + id , null);
    }

    public List<Student> S_showall(){
        List<Student> s_list = new ArrayList<Student>();
        Cursor s_cursor = mysql.query(dataconection.S_TABLE , ALL_S , null , null , null , null , null);
        s_cursor.moveToFirst();
        while(!s_cursor.isAfterLast()){
            Student student = new Student();
            student.setId(s_cursor.getInt(0));
            student.setName(s_cursor.getString(1));
            student.setCollage(s_cursor.getString(2));
            student.setSection(s_cursor.getString(3));
            student.setEmail(s_cursor.getString(4));
            student.setLevel(s_cursor.getInt(5));
            student.setPassword(s_cursor.getInt(6));
            s_list.add(student);
            s_cursor.moveToNext();
        }
        s_cursor.close();
        return s_list;
    }

}
