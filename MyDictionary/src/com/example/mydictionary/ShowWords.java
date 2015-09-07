package com.example.mydictionary;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ShowWords extends Activity implements upFragment.connect{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_words);
		
		FragmentTransaction trans=getFragmentManager().beginTransaction();
		upFragment up=new upFragment();
		trans.add(R.id.ly1,up);
		trans.commit();
		
		
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

	@Override
	public void send(String id) {
		Bundle b=new Bundle();
		b.putString("id1",id);
		FragmentTransaction ft=getFragmentManager().beginTransaction();
		downFragment down=new downFragment();
		down.setArguments(b);
		ft.replace(R.id.ly2,down);
		ft.commit();
		
	}
}
