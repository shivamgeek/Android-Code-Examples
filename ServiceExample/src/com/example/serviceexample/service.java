package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class service extends Service {
int i;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
	  Log.e("started","service has been started");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Thread t=new Thread(new Runnable(){

			@Override
			public void run() {
				for( i=0;i<5;i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//MainActivity.h.post(new Runnable(){public void run(){MainActivity.tv.setText(""+i);}});
					Message m=Message.obtain();
					m.arg1=i;
					MainActivity.h.sendMessage(m);
				}
				
			}
			
			
		});
		t.start();
		
		Log.e("method on startCommand","method on start command invoked");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.e("destroyed","service has been destroyed");
		super.onDestroy();
	}
	
	
	
	
	
	
	
	

}
