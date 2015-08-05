package com.example.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragDown extends Fragment {
View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v=inflater.inflate(R.layout.fragdown,container,false);
		seta();
		return v;
	}
	
	public void seta(){
		TextView t1=(TextView)v.findViewById(R.id.textView1);
		TextView t2=(TextView)v.findViewById(R.id.textView2);
		t2.setText(getArguments().getString("a"));
		t1.setTextColor(Color.BLUE);
		t1.setText(getArguments().getString("b"));
		t2.setTextColor(Color.GREEN);
		
	}
	

}
