package com.example.test1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class dialog extends DialogFragment {
	public interface myInter{
		public void positive(String name);
		public void negative();
	}
	myInter ob;
	

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
     
		AlertDialog.Builder ad=new AlertDialog.Builder(getActivity());
		LayoutInflater li=getActivity().getLayoutInflater();
		final View v=li.inflate(R.layout.dialog,null);
		ad.setView(v);
		
				
		ad.setTitle("This is a dialog box");
		ad.setMessage("HI, Do you agree with our terms and conditions ?");
		ad.setPositiveButton("Alright", new DialogInterface.OnClickListener(){  public void onClick(DialogInterface di,int id){        
			EditText et=(EditText)v.findViewById(R.id.editText1);
		ob.positive(et.getText().toString());
		
			
			
		}});

		
		ad.setNegativeButton("Nope", new DialogInterface.OnClickListener(){ public void onClick(DialogInterface di,int i){    

ob.negative();		
		}});
		return ad.create();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
		ob=(myInter)activity;
		
		}
		catch(Exception e){
			throw new ClassCastException();
			
		}
		
		
	}
	
	
	

}