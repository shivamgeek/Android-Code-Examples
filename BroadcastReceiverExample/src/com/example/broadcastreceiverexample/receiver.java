package com.example.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class receiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String name=intent.getStringExtra("name");
		 Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
		
	}

	
	
	
}
