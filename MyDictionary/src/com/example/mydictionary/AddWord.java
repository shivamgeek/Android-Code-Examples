package com.example.mydictionary;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddWord extends Activity {
 EditText et1,et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_word);
		
		Button save=(Button)findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener(){public void onClick(View v){
			
			save();    }});
		Button cancel=(Button)findViewById(R.id.button2);
		cancel.setOnClickListener(new OnClickListener(){public void onClick(View v){ cancel();    }});
		
			
	}
	
	
	void save(){
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		if(!et1.getText().toString().equalsIgnoreCase(null)){
			final wordsDB ob=new wordsDB(this,"DB",null,1);
			ob.add(et1.getText().toString(),et2.getText().toString());
			Intent i=new Intent(this,MainActivity.class);
			startActivity(i);
			Toast.makeText(this,"Word "+et1.getText().toString()+" added Successfully",Toast.LENGTH_SHORT).show();
		}
		else{
		Intent i=new Intent(this,MainActivity.class);
		startActivity(i);
		Toast.makeText(this,"Enter a valid word !!!",Toast.LENGTH_SHORT).show();
	}
	}
	void cancel(){
	//	et1=(EditText)findViewById(R.id.editText1);
		//et2=(EditText)findViewById(R.id.editText2);
		
		Intent i=new Intent(this,MainActivity.class);
		startActivity(i);
		//Toast t=Toast.makeText(this,"Word "+et1.getText().toString(),Toast.LENGTH_SHORT);t.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_word, menu);
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
