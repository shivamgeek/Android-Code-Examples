package com.example.serviceexample;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class myService extends Service {

	

	public class localBinder extends Binder{
		myService getService(){
			return myService.this;
		}
		
		
	}
IBinder ob=new localBinder();
	

	@Override
	public IBinder onBind(Intent intent) {
		
		return ob;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		ok();
		return Service.START_NOT_STICKY;
	}

	int random(){
		return new Random().nextInt();
				
	}
	
	void ok(){
		Toast.makeText(this,"SERVICE START",Toast.LENGTH_SHORT).show();
	}
	
	
}
