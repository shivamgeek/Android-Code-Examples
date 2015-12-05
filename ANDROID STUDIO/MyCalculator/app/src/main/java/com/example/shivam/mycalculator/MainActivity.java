package com.example.shivam.mycalculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
EditText et;
    String s[]=new String[50];
    String val="0";
    static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.editText);

    }

    public void one(View v){
        val=val+"1";
        et.setText(val);
    }
    public void two(View v){
        val=val+"2";
        et.setText(val);
    }
    public void three(View v){
        val=val+"3";
        et.setText(val);
    }
    public void four(View v){
        val=val+"4";
        et.setText(val);
    }
    public void five(View v){
        val=val+"5";
        et.setText(val);
    }public void six(View v){
        val=val+"6";
        et.setText(val);
    }public void seven(View v){
        val=val+"7";
        et.setText(val);
    }
    public void eight(View v){
        val=val+"8";
        et.setText(val);
    }
    public void nine(View v){
        val=val+"9";
        et.setText(val);
    }


    public void zero(View v){
        val=val+"0";
        et.setText(val);
    }
    public void dot(View v){
        val=val+".";
        et.setText(val);
    }
    public void add(View v){
        s[i]=val;i++;
        s[i]="+";i++;
        et.setText(val+"+");
        val="0";

    }
    public void sub(View v){
        s[i]=val;i++;
        s[i]="-";i++;
        et.setText(val+"-");
        val="0";
    }
    public void mul(View v){
        s[i]=val;i++;
        s[i]="*";i++;
        et.setText(val+"*");
        val="0";
    }
    public void div(View v){
        s[i]=val;i++;
        s[i]="/";i++;
        et.setText(val+"/");
        val="0";
    }
    public void equals(View v) {
        s[i] = val;

        float temp=g(s[i]);
        for (int j =i;j>0;j--) {
           if(s[j].equals("+")) {
           temp=temp+g(s[j-1]);
           }

           if(s[j].equals("-")) {
               temp=temp-g(s[j-1]);
            }

           if(s[j].equals("*")) {
               temp=temp*g(s[j-1]);
            }

            if(s[j].equals("/")) {
                temp=temp/g(s[j-1]);
            }

        }
        /*String a="0";
        for (int j=0;j<7;j++) {
            a=a+s[j]+" ";[
        }*/
        et.setText(temp+"  <--Answer");
       // et.setText(a);
    }


        public float g(String s){
        return Float.parseFloat(s);
    }

    public void clear(View v){
       i=0;
        et.setText(" ");
        val="0";
    }


    }



