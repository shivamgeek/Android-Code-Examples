package com.example.test;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class up extends Fragment {
	public interface meme{
		public void set(String val);
	}
meme ob;
//public static EditText et;
View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	v=inflater.inflate(R.layout.up,container,false);
	Button b= (Button)v.findViewById(R.id.button1);
	
	b.setOnClickListener(new OnClickListener(){public void onClick(View v){ xyz();	 } });
	return v;
	}
	
	public void xyz(){
		EditText et=(EditText)v.findViewById(R.id.editText1);
		ob.set(et.getText().toString());
		
	}
	
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
           ob = (MainActivity) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
	
}
