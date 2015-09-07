package com.example.serviceexample;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				ok();
				
				
			}});
		
	}

	
	
	void ok(){
		Intent i=new Intent(this,myService.class);
		startService(i);
	}

	myService serviceObject=new myService();
ServiceConnection sc=new ServiceConnection(){

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		
		
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		// TODO Auto-generated method stub
		
	}
	
	
};
	
	
	
}
