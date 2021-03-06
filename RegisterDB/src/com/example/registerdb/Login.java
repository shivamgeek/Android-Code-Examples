package com.example.registerdb;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
EditText e1,e2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){ public void onClick(View v){  go(); }});
		
		
	}
	
	public void go(){
		data ob=new data(getApplicationContext(),"DB",null,1);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		Cursor c=ob.check(e1.getText().toString(),e2.getText().toString());
	
		if(c.getCount()>0&&c!=null){
			c.moveToFirst();
			Bundle b=new Bundle();
			b.putString("name",c.getString(c.getColumnIndexOrThrow("name")));
			b.putString("email",c.getString(c.getColumnIndexOrThrow("email")));
			Intent i=new Intent(this,Profile.class);
			i.putExtras(b);
			startActivity(i);
			
		}
		else{
			Toast t=Toast.makeText(getApplicationContext(),"Id does not exist",Toast.LENGTH_SHORT);t.show();
			Intent i=new Intent(this,MainActivity.class);
			startActivity(i);
			
		}
	
			
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
