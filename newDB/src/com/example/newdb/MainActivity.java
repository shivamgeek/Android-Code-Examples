package com.example.newdb;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button add=(Button)findViewById(R.id.button1);
		Button delete=(Button)findViewById(R.id.button2);
		Button show=(Button)findViewById(R.id.button3);
		Button delete1=(Button)findViewById(R.id.button4);
		final EditText name=(EditText)findViewById(R.id.editText1);
		final EditText email=(EditText)findViewById(R.id.editText2);
		final book data=new book(getApplicationContext(),"DB",null,1);
		add.setOnClickListener(new OnClickListener(){ public void onClick(View v){
			data.add(name.getText().toString(), email.getText().toString());
			Toast t= Toast.makeText(getApplicationContext(),"data added successfully",Toast.LENGTH_SHORT);t.show();
		}});
		delete.setOnClickListener(new OnClickListener(){ public void onClick(View v){
			
			data.delete();
			Toast t=Toast.makeText(getApplicationContext(),"data deleted successfully",Toast.LENGTH_SHORT);t.show();
		}});
		show.setOnClickListener(new OnClickListener(){ public void onClick(View v){
			FragmentTransaction ft=getFragmentManager().beginTransaction();
			data frag=new data();
			ft.replace(R.id.ly2,frag);
			ft.commit();		
			String s[]=data.show();
			Bundle b=new Bundle();
			b.putString("name",s[0]);
			b.putString("email",s[1]);
			frag.setArguments(b);
			//frag.set();
			
		}});
delete1.setOnClickListener(new OnClickListener(){ public void onClick(View v){
			
			data.deleteAll();
			Toast t=Toast.makeText(getApplicationContext(),"data deleted successfully",Toast.LENGTH_SHORT);t.show();
		}});
		
		
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
