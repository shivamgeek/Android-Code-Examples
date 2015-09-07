package com.example.broadcastreceiverexample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et=(EditText)findViewById(R.id.editText1);
		Button b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				sendBroadcast();
				
			}});
	}

	void sendBroadcast(){
	String name=et.getText().toString();
	Intent i=new Intent();
	i.setAction("MyBroadcast_Action");
	i.putExtra("name",name);
	sendBroadcast(i);
		
	}
	
	
	
}
