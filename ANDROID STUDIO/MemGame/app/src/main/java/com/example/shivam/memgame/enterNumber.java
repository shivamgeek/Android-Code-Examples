package com.example.shivam.memgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class enterNumber extends Activity {

    Button verify,cancel;
    EditText et;
    String val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_number);
        verify=(Button)findViewById(R.id.verify);
        cancel=(Button)findViewById(R.id.cancel);
        et=(EditText)findViewById(R.id.et);
         val=et.getText().toString();
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent in=getIntent();
                String val1=in.getStringExtra("val");
                if(val.equals(val1)) {
                    Intent i = new Intent(enterNumber.this, game.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Congratulations. Level up !",Toast.LENGTH_SHORT);
                }
                else{
                    Intent i = new Intent(enterNumber.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Bad Memory !",Toast.LENGTH_SHORT);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(enterNumber.this, MainActivity.class);
                startActivity(i);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_number, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
