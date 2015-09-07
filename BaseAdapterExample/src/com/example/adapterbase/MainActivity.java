package com.example.adapterbase;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv=(ListView)findViewById(R.id.list);
		adapter ad=new adapter();
		lv.setAdapter(ad);
		
		
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
	 class data{
			String name;
			
		}

		 class adapter extends BaseAdapter{

		ArrayList<data> temp=putData();
			 
			@Override
			public int getCount() {
				
				return temp.size();
			}

			@Override
			public Object getItem(int position) {
				
				return temp.get(position);
			}

			@Override
			public long getItemId(int position) {
				
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				if(convertView==null){
					LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView=inflater.inflate(R.layout.row,parent,false);
				}
				//data ob2=temp.get(position);
				TextView tv=(TextView)convertView.findViewById(R.id.textView1);
				tv.setText(temp.get(position).name);
				
				
				
				return convertView;
			}
			 
			ArrayList<data> putData(){
				
				ArrayList<data> temp1=new ArrayList<data>();
				for(int i=0;i<15;i++){
					data ob=new data();
					ob.name=""+i;
					temp1.add(ob);
				}
			return temp1;
			}
			
			 
			 
		 }

	
}





