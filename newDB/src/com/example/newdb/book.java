package com.example.newdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class book extends SQLiteOpenHelper {
	SQLiteDatabase sdb=this.getWritableDatabase();

	public book(Context context, String name, CursorFactory factory, int version) {
		super(context, "DB", factory, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table book (name text,email text);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
	
	public void add(String name,String email){
		ContentValues cv=new ContentValues();
		cv.put("name",name);
		cv.put("email",email);
		sdb.insert("book", null,cv);
	}
	
	public void delete(){
		String[] p={"shivam","s"};
		sdb.delete("book","name=? and email=?",p);
	}
	
	public void deleteAll(){
		sdb.delete("book",null,null);
	}
	
	public String[] show(){
		String[] col={"name","email"};
		Cursor c=sdb.query("book",col,null,null,null,null,null);
		c.moveToFirst();
		String d[]=new String[2];
		d[0] =c.getString(c.getColumnIndex("name"));
		d[1] =c.getString(c.getColumnIndex("email"));
		return d;
		}
	
	

}
