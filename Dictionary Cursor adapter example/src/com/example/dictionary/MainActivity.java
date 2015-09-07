package com.example.dictionary;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1=(Button)findViewById(R.id.button1);
		Button b2=(Button)findViewById(R.id.button2);
		b1.setOnClickListener(new OnClickListener(){public void onClick(View v){
			add();
			
		}});
		
		b2.setOnClickListener(new OnClickListener(){public void onClick(View v){
			show();
			
		}});
		
		Button b3=(Button)findViewById(R.id.button3);
		b3.setOnClickListener(new OnClickListener(){public void onClick(View v){
			delete();
			
		}});
		
		
		
	}
	
	void add(){
		Intent i=new Intent(this,AddWord.class);
		startActivity(i);
	}
	

	void show(){
		Intent i=new Intent(this,ShowWords.class);
		startActivity(i);
		
	}
	
	void delete(){
		wordsDB ob=new wordsDB(this,"DBA",null,1);
		ob.deleteAll();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
