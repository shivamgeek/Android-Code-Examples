package com.example.notificationexample;


import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b=(Button)findViewById(R.id.button1);
		final NotificationCompat.Builder n=new NotificationCompat.Builder(this);
        n.setContentTitle("HI");
        n.setContentText("TEXT");
        n.setSmallIcon(R.drawable.ic_launcher);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				 NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
			        manager.notify(123,n.build());
				
			}});
        
       
        
	
	
	
	}

	
	
	
}
