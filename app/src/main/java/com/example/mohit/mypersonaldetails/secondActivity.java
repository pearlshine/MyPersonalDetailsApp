package com.example.mohit.mypersonaldetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    private static String TAG ="myMessage";
    TextView t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        t6=(TextView)findViewById(R.id.textView6);

        Intent i= getIntent();
        Bundle b= i.getExtras();

        String o1= (String) b.get("name");
        String o2= (String) b.get("age");
        String o3= (String) b.get("dob");

        t4.setText(t4.getText().toString()+ " "+o1);
        t5.setText(t5.getText().toString()+ " "+o2);
        t6.setText(t6.getText().toString()+ " "+o3);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "State of activity 'secondActivity' :" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "State of activity 'secondActivity' :" + "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "State of activity 'secondActivity' :" + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "State of activity 'secondActivity' :" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "State of activity 'secondActivity' :" + "onDestroy");
    }




}
