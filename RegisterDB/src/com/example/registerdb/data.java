package com.example.registerdb;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class data extends SQLiteOpenHelper{
	
	SQLiteDatabase sdb=this.getWritableDatabase();
	
public data(Context context, String name, CursorFactory factory, int version) {
		super(context,"DB", factory, 1);
		
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table book (name text,email text,password text);");
	}
	
	public void insert(String name,String password,String email){
		//sdb.execSQL("create table book (name text,email text,password text);");
		ContentValues cv=new ContentValues();
		cv.put("name",name);
		cv.put("email",email);
		cv.put("password",password);
		sdb.insert("book", null,cv);
	}
	
	public void delete(String name){
		String[] val={name};
		sdb.delete("book","name=?",val);
		
	}
	
	public Cursor check(String name,String password){
		String[] val={name,password};
		String[] column={"name","email"};
		Cursor c=sdb.query("book",null,"name=? and password=?", val,null,null,null);
		
		return c;
		
	}
	 
	
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists book");
		onCreate(db);
		
	}
	


}
