package com.example.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class intentService extends IntentService {

	public intentService() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		 Log.e("started","service in onHandleIntent");
		
	}
	
	public void onDestroy() {
		Log.e("destroyed","service has been destroyed");
		super.onDestroy();
	}

}
