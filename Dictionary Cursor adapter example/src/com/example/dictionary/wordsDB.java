package com.example.dictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class wordsDB extends SQLiteOpenHelper {

	String id="_id";
	String val="WORD_VAL";
	String meaning="WORD_MEANING";
	String table="WORD_TABLE";
	SQLiteDatabase db=getWritableDatabase();
	
	public wordsDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context,"DBA",factory, 1);
		
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
	
	
	public void add(String value,String meaning1){
		ContentValues cv=new ContentValues();
		cv.put(val,value);
		cv.put(meaning,meaning1);
		db.insert(table,null,cv);
	}
	
	public void delete(String id1){
	   db.delete(table,"id=?",new String[]{id1});
	}
	
	public void deleteAll(){
		db.delete(table,null,null);
	}

	public void update(String id,String value,String meaning1){
		ContentValues cv=new ContentValues();
		cv.put(val, value);
		cv.put(meaning,meaning1);
		String args[]=new String[]{id};
		db.update(table, cv,"id=?",args);
		
	}
	
	Cursor show(){
		String args[]=new String[]{id,val,meaning};
		Cursor c=db.query(table, args, null,null, null, null, null);
		return c;
	}
	
	Cursor getData(String id1){
		Cursor c=db.query(table, new String[]{id,val,meaning},"_id=?",new String[]{id1},null,null,null);
		return c;
		
	}
	
}
