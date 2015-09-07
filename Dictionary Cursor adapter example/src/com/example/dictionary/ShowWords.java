package com.example.dictionary;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ShowWords extends Activity {
	FragmentManager fm=getFragmentManager();
	FragmentTransaction manager=fm.beginTransaction();
	wordListFragment up=new wordListFragment();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_words);
		
		
		manager.add(R.id.lyy1,up);
		manager.commit();
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_words, menu);
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

	
	public void send(String id1) {
		wordMeaningFragment ob=new wordMeaningFragment();
		Bundle b=new Bundle();
		b.putString("id",id1);
		ob.setArguments(b);
		FragmentManager fm1=getFragmentManager();
		FragmentTransaction manager1=fm1.beginTransaction();
		manager1.replace(R.id.lyy2,ob);
		if(!isFinishing()){
			manager1.commit();
		}
			
	}
}
