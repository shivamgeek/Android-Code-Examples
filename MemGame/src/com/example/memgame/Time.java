package com.example.memgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Time extends Activity {
EditText et;
Button b1;
String t;
int in;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time);
		 b1=(Button)findViewById(R.id.b1);
		 et=(EditText)findViewById(R.id.editText1);
		 b1.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	t=et.getText().toString();
	            	in=Integer.parseInt(t);
	            	Game ob=new Game();
	            	Game.time=in;
	             Intent i=new Intent(Time.this,MainActivity.class);
	                startActivity(i);
	                Toast.makeText(getApplicationContext(),"CountDown time changed to "+in+" sec",Toast.LENGTH_SHORT).show();
	            }
	        });
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.time, menu);
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
