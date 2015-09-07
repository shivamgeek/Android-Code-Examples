package com.example.dictionary;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class wordListFragment extends Fragment {
	
	/*@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
		try{
			co=(connect)activity;
		}
		catch(ClassCastException e){
			throw new ClassCastException();
			
		}
	}*/
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.word_list,container,false);
		wordsDB ob=new wordsDB(this.getActivity(),"DBA",null,1);
	Cursor c=ob.show();
	if(c.getCount()>0){
		customAdapter adapter=new customAdapter(this.getActivity(),c,0);
		ListView lv=(ListView)v.findViewById(R.id.list);
			lv.setAdapter(adapter);
			/*lv.setOnItemClickListener(new OnItemClickListener(){  public void onItemClick(AdapterView<?> adapter,View v,int position,long id){    
				
				Cursor c=(Cursor) adapter.getItemAtPosition(position);
				String id1=c.getString(c.getColumnIndexOrThrow("_id"));
				co.send(id1);
				
				
			}});*/
	}
	else{
		Toast.makeText(this.getActivity(),"No words yet !!!",Toast.LENGTH_SHORT).show();
		Intent i=new Intent(this.getActivity(),MainActivity.class);
		startActivity(i);
	}
		
			
		return v;
	}
	
	
	
	

}
