package com.example.registerdb;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
EditText e1,e2,e3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	 e1=(EditText)findViewById(R.id.editText1);
	 e2=(EditText)findViewById(R.id.editText2);
	 e3=(EditText)findViewById(R.id.editText3);
		
		Button b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){ public void onClick(View v){  
			data ob=new data(getApplicationContext(),"DB",null,1);
			ob.insert(e1.getText().toString(),e2.getText().toString(),e3.getText().toString()); 
		go();
		}});
	}

	public void go(){
		Intent i=new Intent(this,MainActivity.class);
		startActivity(i);
		Toast t=Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_SHORT);t.show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
