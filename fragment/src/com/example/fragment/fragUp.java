package com.example.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class fragUp extends Fragment {
	View v;
	public interface fragInterface{
		public void set(String a,String b);
	}
	fragInterface ob;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	v=inflater.inflate(R.layout.fragup,container,false);
	Button b=(Button)v.findViewById(R.id.button1);
	b.setOnClickListener( new OnClickListener(){ public void onClick(View v){ store();    }});
	
	return v;
	}
	
	
	
	
	
	public void onAttach(Activity activity){
	super.onAttach(activity);
	try{
		ob=(fragInterface)activity;
	}
	catch(ClassCastException e){
		throw new ClassCastException();
		
	}
	
	
	}
	
	
	
public void store(){
	EditText et1=(EditText)v.findViewById(R.id.editText1);
	EditText et2=(EditText)v.findViewById(R.id.editText2);
	ob.set(et1.getText().toString(),et2.getText().toString());
}
}
