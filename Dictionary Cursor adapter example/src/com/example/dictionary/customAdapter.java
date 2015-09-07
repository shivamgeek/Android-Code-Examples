package com.example.dictionary;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class customAdapter extends CursorAdapter {
	



	public customAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		
	}


	
	

	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		return super.getView(position, convertView, parent);
	}



	@Override
	public void bindView(View view, final Context context, final Cursor cursor) {
		TextView tv=(TextView)view.findViewById(R.id.textView1);
		wordsDB data=new wordsDB(context,"DBA",null, 1);
		tv.setText(cursor.getString(cursor.getColumnIndexOrThrow(data.val)));
		Button b=(Button)view.findViewById(R.id.button1);
		final String id1=cursor.getString(cursor.getColumnIndexOrThrow(data.id));
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				wordMeaningFragment ob=new wordMeaningFragment();
				FragmentManager fm1=((ShowWords)context).getFragmentManager();
				FragmentTransaction manager1=fm1.beginTransaction();
				Bundle b=new Bundle();
				b.putString("id1",id1);
				ob.setArguments(b);
				manager1.replace(R.id.lyy2,ob);
				manager1.commit();
					
					
			}});
		
		
	}



	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		
		 return LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
	}

	
	
	}
	
	
	

