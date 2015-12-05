package com.example.memgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterNumber extends Activity {

	 Button verify,cancel;
	    EditText et;
	    TextView tv;
	    int rem=1;
	    String val=null;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_enter_number);
	        verify=(Button)findViewById(R.id.verify);
	        cancel=(Button)findViewById(R.id.cancel);
	        et=(EditText)findViewById(R.id.et);
	        tv=(TextView)findViewById(R.id.tv);
	        
	        
	        
	         Intent in=getIntent();
	         Bundle b=in.getExtras();
	         rem=b.getInt("rem");
             val=in.getStringExtra("val");
             rem++;
             Game g=new Game();
             g.finish();
            
	        verify.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	               if(et.getText().toString().equalsIgnoreCase(val)){
	            	   
	                    Intent i = new Intent(EnterNumber.this, Game.class);
	                    i.putExtra("rem",rem);
	                    startActivity(i);
	                 
	                    Toast.makeText(getApplicationContext(),"Congratulations. You reached Level "+rem+" !!!",Toast.LENGTH_SHORT).show();
	                    
	                }
	                else{
	                    Intent i = new Intent(EnterNumber.this, MainActivity.class);
	                    startActivity(i);
	                    
	                   Toast.makeText(getApplicationContext(),"Bad Memory !!!",Toast.LENGTH_SHORT).show();
	                 //   Toast.makeText(getApplicationContext(),"val is "+val+" and written value is "+et.getText().toString(),Toast.LENGTH_LONG).show();
	                    Game g=new Game();
	                    rem=0;
		            	g.finish();
		            	
	                }
	            }
	        });

	        cancel.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	Game g=new Game();
	            	g.finish();
	                Intent i = new Intent(EnterNumber.this, MainActivity.class);
	                rem=0;
	                startActivity(i);
	                
	            }
	        });





	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_number, menu);
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
