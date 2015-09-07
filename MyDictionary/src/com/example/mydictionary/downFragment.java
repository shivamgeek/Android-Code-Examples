package com.example.mydictionary;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class downFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.downfragment,null,false);
	TextView tv=(TextView)v.findViewById(R.id.textView2);
	String id1=getArguments().getString("id1");
	wordsDB ob=new wordsDB(getActivity(),"DB",null,1);
	Cursor c=ob.getData(id1);
	c.moveToFirst();
	String meaning=c.getString(c.getColumnIndexOrThrow(ob.meaning));
	tv.setText(meaning);
	
		
		
		
		
		return v;
	}

	
	
}
