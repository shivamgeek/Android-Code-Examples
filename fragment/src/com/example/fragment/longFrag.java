package com.example.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class longFrag extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.longfrag,container,false);
		Button b=(Button)v.findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){ public void onClick(View v){ ok();  }  }  );
		
		return v;
	}

	public void ok(){
		FragmentTransaction ft=getFragmentManager().beginTransaction();
		ft.remove(this); 
		ft.commit();
	}
	
	}
	

