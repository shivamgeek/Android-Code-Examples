package com.example.register;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Reg extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		Bundle b= getIntent().getExtras();
		String name=b.getString("email");
		String email=b.getString("pass");
		TextView n=(TextView)findViewById(R.id.textView2);
		TextView e=(TextView)findViewById(R.id.textView3);
		n.setText("User is "+ name);
		e.setText("Email is "+ email);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg, menu);
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
	
	public void home(View view){
		Intent i =new Intent(this,RegLog.class);
		startActivity(i);
		
	}
	
	public void back(View view){
		Intent i =new Intent(this,Register.class);
		startActivity(i);
		
	}
}
