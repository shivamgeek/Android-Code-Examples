package com.example.mydictionary;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button add=(Button)findViewById(R.id.button1);
		add.setOnClickListener(new OnClickListener(){public void onClick(View v){ add();    }});
		Button show=(Button)findViewById(R.id.button2);
		show.setOnClickListener(new OnClickListener(){public void onClick(View v){   show();  }});
		Button deleteAll=(Button)findViewById(R.id.button3);
		deleteAll.setOnClickListener(new OnClickListener(){public void onClick(View v){   deleteAll();  }});
	}
	

	void add(){
		
		Intent i=new Intent(this,AddWord.class);
		startActivity(i);
		
		
	}
	void show(){
		Intent i=new Intent(this,ShowWords.class);
		startActivity(i);
		
	}
	void deleteAll(){
		wordsDB ob=new wordsDB(this,"DB",null,1);
		ob.deleteAll();
		Toast.makeText(this,"All words deleted",Toast.LENGTH_SHORT).show();
		
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
