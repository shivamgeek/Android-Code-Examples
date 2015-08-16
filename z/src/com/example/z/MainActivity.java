package com.example.z;

import java.util.ArrayList;
import java.util.List;

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
		adapt ad=new adapt();
		ListView lv=(ListView)findViewById(R.id.list);
		lv.setAdapter(ad);
		
	}
	
	class adapt extends BaseAdapter{

		ArrayList<data> listOb=setData();
		
		
		ArrayList<data> setData(){
			ArrayList<data> listOb=new ArrayList<data>();
			data d=new data();
			for(int i=0;i<5;i++){
			d.name="Name is "+i;
			d.course="Course is"+(char)i;
			listOb.add(d);
			}
			return listOb;
			
		}
		
		
		@Override
		public int getCount() {
			
			return listOb.size();
		}

		@Override
		public Object getItem(int position) {
			
			return listOb.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if(convertView==null){
			LayoutInflater inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.adapt,parent,false);
			}
			
			TextView tv1=(TextView)convertView.findViewById(R.id.textView1);
			TextView tv2=(TextView)convertView.findViewById(R.id.textView2);
			data d=listOb.get(position);
			
			tv1.setText(d.name);
			tv2.setText(d.course);
			return convertView;
		}
		
	}

class data{
		String name,course;
		
	}


	
}











