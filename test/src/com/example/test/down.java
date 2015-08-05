package com.example.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class down extends Fragment{
   View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    v=inflater.inflate(R.layout.down,container,false);
	return v;
	}

	public void abc(String a){
		TextView tv=(TextView)v.findViewById(R.id.textView1);
		tv.setText(a);
	}
	
}
