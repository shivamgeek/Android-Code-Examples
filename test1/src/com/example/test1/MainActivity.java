package com.example.test1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements dialog.myInter{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dialog d= new dialog();
		d.show(getFragmentManager(), "missiles");
		
		Button b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){public void onClick(View va){
			LayoutInflater i=getLayoutInflater();
			 View v=i.inflate(R.layout.toast,(ViewGroup)findViewById(R.id.ly));
			Toast t = Toast.makeText(getApplicationContext(),"iuhiuHElol",Toast.LENGTH_SHORT);
			t.show();
			
			//t.setView(v);
		
		}     });
		
		
		
		
		
		
		
		
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
	 
	public void positive(String name){
		TextView tv=(TextView)findViewById(R.id.textView1);
		tv.setText("Hello "+name);
		
		
		
	}
	
	public void negative(){
		TextView t=(TextView)findViewById(R.id.textView1);
		t.setText("should have agreed");
		
	}
	
	
	
	
}
