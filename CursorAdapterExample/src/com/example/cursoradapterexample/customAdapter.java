package com.example.cursoradapterexample;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class customAdapter extends CursorAdapter {

	public customAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		// TODO Auto-generated constructor stub
	}

public View getView(int position, View convertView, ViewGroup parent) {
		
		return super.getView(position, convertView, parent);
	}



	@Override
	public void bindView(View view, final Context context, final Cursor cursor) {
		TextView tv=(TextView)view.findViewById(R.id.textView1);
		tv.setText(cursor.getString(cursor.getColumnIndexOrThrow("WORD_VAL")));
		final String name=cursor.getString(cursor.getColumnIndexOrThrow("WORD_MEANING"));
		Button b=(Button)view.findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Toast.makeText(context, name,Toast.LENGTH_SHORT).show();
			}});
		
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
