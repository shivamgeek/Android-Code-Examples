package com.example.boundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class service extends Service {
IBinder ob=new My_Ibinder();
		

public class My_Ibinder extends Binder{
	public service get_MyService(){
    	return service.this;
    }

  }


@Override
public void onCreate() {
	
Log.e("SERVICE CREATED","ffghhgfgh");

}



@Override
public int onStartCommand(Intent intent, int flags, int startId) {
	Log.e("SERVICE OnStartCommand","fhfgghfh");
	return super.onStartCommand(intent, flags, startId);
}



	@Override
	public IBinder onBind(Intent intent) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.e("SERVICE onBind","fhghfhg");
		return ob;
	}

	
	
	       
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.e("SERVICE DESTROYED","fhgh");
	}
	
	String data(){
		Log.e("SERVICE data method","fhgf");

		return "DATA SUCCESSFULLY TRANSFERRED";
	}
	
	public void ok(){
		Log.e("SERVICE ok method","fghfggfh");
	}
	
	
}


