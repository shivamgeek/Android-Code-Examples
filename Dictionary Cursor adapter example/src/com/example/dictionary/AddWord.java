package com.example.dictionary;

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

public class AddWord extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_word);
		
		
		
		 Button b=(Button)findViewById(R.id.button2);
			b.setOnClickListener(new OnClickListener(){public void onClick(View v){
				
				add();
				
			}});
			
			Button b1=(Button)findViewById(R.id.button1);
			b1.setOnClickListener(new OnClickListener(){public void onClick(View v){
				
				cancel();
				
			}});
		
	}
	
	void add(){
		EditText et1=(EditText)findViewById(R.id.editText1);
		EditText et2=(EditText)findViewById(R.id.editText2);
		
		String val=et1.getText().toString();
		String meaning=et2.getText().toString();
		if(!val.equals(null)){
			wordsDB ob=new wordsDB(this,"DBA",null,1);
			ob.add(val,meaning);
			Toast.makeText(this,"Word "+val+" added Successfully!!!",Toast.LENGTH_LONG).show();
			Intent i=new Intent(this,MainActivity.class);
			startActivity(i);
		}
		else{
			Toast.makeText(this,"Please enter a valid word",Toast.LENGTH_SHORT).show();
			Intent i=new Intent(this,MainActivity.class);
			startActivity(i);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_word, menu);
		return true;
	}
	
	void cancel(){
		Intent i=new Intent(this,MainActivity.class);
		startActivity(i);
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
