package com.example.threadingexample;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	tv=(TextView)findViewById(R.id.textView1);
		tv.setText("initial");
	Thread t=new Thread(new Runnable(){

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				runOnUiThread(new Runnable(){

					@Override
					public void run() {
						ok();
						
					}});
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
		t.start();
	tv.setText("it should be this only");
	
	
	
	}

	void ok(){
		tv.setText("After 3 seconds of thread");
	}
	
}
