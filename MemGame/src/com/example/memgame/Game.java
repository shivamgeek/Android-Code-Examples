package com.example.memgame;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity implements Runnable {

	Button done,cancel;
    TextView tv,num;
   static int time=4;
    Boolean flag=true;
   Thread th;
   Random r=new Random();
   int i,rem=1,ran=0,t=0;
  
   
  
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
       //done=(Button)findViewById(R.id.done);
       cancel=(Button)findViewById(R.id.cancel);
        tv=(TextView)findViewById(R.id.count);
        num=(TextView)findViewById(R.id.num);
       // Toast.makeText(this,"create",Toast.LENGTH_SHORT).show();
        th=new Thread(this);
       
       if(time<=0){
    	   time=4;
       }
        
        Intent i=getIntent();
        Bundle b=i.getExtras();
       
        if(b!=null){
        	 rem=b.getInt("rem");
        	if(rem==0){
        		do{
      ran= r.nextInt()%9;
        		}while(ran<=0);
        num.setText(""+ran); 
       
       }
        	
        	
        	
        	else{
    	   do{
    		  t=r.nextInt();
    		    
    	   ran=(int) (t%(Math.pow(10,b.getInt("rem"))));
       }while(ran<=0);
           num.setText(""+ran); 
           
       }
        	
        
        	
        	
       
        }
        else{
        	do{
        	  ran= r.nextInt()%9;
        }while(ran<=0);
             num.setText(""+ran); 
            
        }
        
        
        
        
        th.start();
        
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
                Intent i=new Intent(Game.this,MainActivity.class);
                rem=0;
              finish();
              th=null;
                startActivity(i);
            }
        });

       /* done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
               Intent i = new Intent(Game.this,EnterNumber.class);
                i.putExtra("val",""+ran);
                i.putExtra("rem",rem);
                startActivity(i);
            }
        });*/

}

        
  
   
 
	


	 public void run(){
	    	
		
			 
	        for( i=time;i>=0;i--){
	        	runOnUiThread(new Runnable(){public void run(){
	        		tv.setText("Time left "+i+" sec");
	    }
	    });
	        	
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            
	           
	            
	            
	        }
	        
	       Intent in=new Intent(this,EnterNumber.class);
	        in.putExtra("val",""+ran);
	        in.putExtra("rem",rem);
	        startActivity(in);
	    
		 
	    }
	
	
	
	
	
	
	
	
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
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
