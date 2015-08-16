package com.example.newdb;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class data extends Fragment {
	TextView t1,t2;
	@Override
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.data,container,false);
		 t1=(TextView)v.findViewById(R.id.textView3);
		 t2=(TextView)v.findViewById(R.id.textView4);
		 set();
		return v;
	}
	
	public void set(){
		
	
		t1.setText(getArguments().getString("name"));
		t2.setText(getArguments().getString("email"));
		
	}

	

}
