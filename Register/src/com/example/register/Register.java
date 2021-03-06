package com.example.register;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
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
	
	public void submit(View view){
		Bundle b= new Bundle();
		EditText n=(EditText)findViewById(R.id.editText1);
		String name=n.getText().toString();
		EditText e= (EditText)findViewById(R.id.editText2);
		String email=e.getText().toString();
		EditText p= (EditText)findViewById(R.id.editText3);
		String pass=p.getText().toString();
		b.putString("name",name);
		b.putString("email",email);
		b.putString("pass",pass);
		Intent i =new Intent(this,Reg.class);
		i.putExtras(b);
		startActivity(i);
		}
	
	public void cancel(View view){
		Intent i =new Intent(this,RegLog.class);
		startActivity(i);
	}
	
	
}
