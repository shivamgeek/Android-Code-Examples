package com.example.fragment;

import android.support.v7.app.AppCompatActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b= (Button)findViewById(R.id.button1);
		b.setOnClickListener( 
				new OnClickListener(){
					public void onClick(View v){
						FragmentTransaction ft=getFragmentManager().beginTransaction();
						longFrag lf=new longFrag();
						ft.add(R.id.ly,lf); ft.commit();
						}
				});
		
		b.setOnLongClickListener(
				new OnLongClickListener(){
					public boolean onLongClick(View v){
						Intent i=new Intent(MainActivity.this,Second.class);
						startActivity(i);
						return true;
						
					}
				}
				);
		
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
			LinearLayout l=(LinearLayout)findViewById(R.id.ly);
			l.setBackgroundColor(Color.RED);
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
