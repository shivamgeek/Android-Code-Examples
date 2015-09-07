package com.example.mydictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class wordsDB extends SQLiteOpenHelper{
	
	String table="WORD_TABLE";
	String id="_id";
	String val="WORD_VALUE";
	String meaning="WORD_MEANING";
	SQLiteDatabase db=getWritableDatabase();
	
	public wordsDB(Context context, String name, CursorFactory factory,int version) {
		super(context,"DB", factory,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table "+table+"("+id+" integer primary key,"+val+" text,"+meaning+" text);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists "+table);
		onCreate(db);
		
	}

	void add(String val1,String meaning1){
		ContentValues cv=new ContentValues();
		cv.put(val, val1);
		cv.put(meaning,meaning1);
		db.insert(table, null, cv);
		
	}
	
	void deleteAll(){
		db.delete(table, null, null);
	}
	
	void delete(String id1){
		db.delete(table,"_id=?",new String[]{id1});
	}
	
	Cursor show(){
		Cursor c=db.query(table, new String[]{id,val,meaning},null,null,null, null,null);
		return c;
	}
	
	Cursor getData(String id1){
		Cursor c=db.query(table, new String[]{id,val,meaning}, "_id=?",new String[]{id1},null,null,null);
		return c;
	}
	
	
}
