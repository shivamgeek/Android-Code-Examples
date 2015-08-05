package com.example.register;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Log extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		Bundle b= getIntent().getExtras();
		String name=b.getString("name");
		String pass=b.getString("pass");
		TextView n=(TextView)findViewById(R.id.textView2);
		TextView p=(TextView)findViewById(R.id.textView3);
		n.setText("User is "+ name);
		p.setText("Password is "+ pass);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log, menu);
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
	
	 public void back(View view){
		 Intent i =new Intent(this,Login.class);
		 startActivity(i);
		 
		 
	 }
	 
 public void home(View view){
	 Intent i =new Intent(this,RegLog.class);
	 startActivity(i);
		 
	 }
	 
	 
}
