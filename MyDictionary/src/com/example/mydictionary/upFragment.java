package com.example.mydictionary;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class upFragment extends Fragment {

	
	public interface connect{
		public void send(String id);
	}
	connect co;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.upfragment,null,false);
		final wordsDB ob=new wordsDB(getActivity(),"DB",null,1);
		if(ob.show().getCount()>0){
		
			SimpleCursorAdapter adapter=new SimpleCursorAdapter(this.getActivity(),R.layout.listrow,ob.show(),new String[]{ob.id,ob.val},new int[]{R.id.textView1,R.id.textView2},1);
			ListView lv=(ListView)v.findViewById(R.id.list);
			lv.setAdapter(adapter);
			lv.setOnItemClickListener(new OnItemClickListener(){public void onItemClick(final AdapterView<?> adapter,View v,final int position,long id){
				
				//Button b=(Button)adapter.findViewById(R.id.button1);
			//	b.setOnClickListener(new OnClickListener(){public void onClick(View v){
					
					Cursor c=(Cursor)adapter.getItemAtPosition(position);
					String id1=c.getString(c.getColumnIndexOrThrow(ob.id));
					co.send(id1);
				}});
				
				
			//}});
			
			
			
			
		}
		
		
		else{
			Toast.makeText(this.getActivity(),"No words in Dictionary",Toast.LENGTH_SHORT).show();
			Intent i=new Intent(this.getActivity(),MainActivity.class);
			startActivity(i);
		}
		
		return v;
	}
	
	
	
	
	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
		try{
			co=(connect)activity;
		}
		catch(ClassCastException e){
			throw new ClassCastException();
			
		}
		
	}
	
	

}
