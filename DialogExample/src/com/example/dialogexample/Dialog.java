package com.example.dialogexample;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


public class Dialog extends DialogFragment{

	@Override
	public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
		
		AlertDialog.Builder alert=new AlertDialog.Builder(this.getActivity());
		alert.setMessage("THIS IS THE MESSAGE");
		alert.setTitle("Title of dialog");
		alert.setPositiveButton("OK(Positive)",new DialogInterface.OnClickListener(){

		@Override
		public void onClick(DialogInterface dialog, int which) {
			
			
		}
		});
		
		alert.setNegativeButton("CANCEL(Negative)",new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog,int i){
			
			
		}});
		
		return alert.create();  //MUST RETURN THIS METHOD INSTEAD OF CALLING SUPER CLASS CONSTRUCTOR
		
		
	}
	
	
	
	
	
	

}
