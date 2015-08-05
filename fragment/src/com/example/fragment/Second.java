package com.example.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Second extends AppCompatActivity implements fragUp.fragInterface {
FragmentTransaction ft,ft1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		 ft=getFragmentManager().beginTransaction();
		fragUp fu=new fragUp();
		fragDown ob=new fragDown();
		ft.add(R.id.ly1,fu);
		//ft.add(R.id.ly2,ob);
	   ft.commit();
		}

	public void set(String a,String b){
      ft1=getFragmentManager().beginTransaction();
      fragDown ob=new fragDown();
      Bundle bu= new Bundle();
      bu.putString("a",a);
      bu.putString("b",b);
      ob.setArguments(bu);
     ft1.replace(R.id.ly2,ob);
     ft1.commit();
     
		
		 
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
