package com.example.registerdb;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends Activity {
//TextView t1,t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		ok();
		 final Bundle b=this.getIntent().getExtras();
		
		Button b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener(){ public void onClick(View v){ delete();
			    }});
		Button b2=(Button)findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener(){ public void onClick(View v){    logout();  }});
		
	}
	
	public void logout(){
		Intent i=new Intent(this,MainActivity.class);
		startActivity(i);
		Toast t=Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_SHORT);t.show();
	}
	
	public void delete(){
		 Bundle b=this.getIntent().getExtras();
		data ob=new data(getApplicationContext(),"DB",null,1);
		ob.delete(b.getString("name"));
		Intent i = new Intent(this,MainActivity.class);
		startActivity(i);
		Toast t=Toast.makeText(getApplicationContext(),"Profile Deleted",Toast.LENGTH_SHORT);t.show();
	}
	
	public void ok(){
		 Bundle b=this.getIntent().getExtras();
		TextView t1=(TextView)findViewById(R.id.textView1);
		TextView t2=(TextView)findViewById(R.id.textView2);
		t1.setText("Hello "+b.getString("name")+" !!!");
		t2.setText("Email is "+b.getString("email"));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
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
