package com.example.dictionary;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class wordMeaningFragment extends Fragment{
	TextView tv;
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.word_meaning,container,false);
		 tv=(TextView)v.findViewById(R.id.textView1);
		 wordsDB ob=new wordsDB(this.getActivity(),"DBA",null,1);
		 String id1=getArguments().getString("id1");
			Cursor c=ob.getData(id1);
			 c.moveToFirst();
			 String meaning=c.getString(c.getColumnIndexOrThrow(ob.meaning));
			 tv.setText("Meaning is "+meaning);
		 
		return v;
	}
	
	

}
