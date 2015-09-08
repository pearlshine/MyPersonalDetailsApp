package com.example.mohit.mypersonaldetails;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Calendar;
import java.util.Scanner;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private int day,month,year;
    private  static String TAG= "myMessage";
    EditText editText;
    EditText editText1;
    EditText editText3;
    TextView t,t2,t3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Welcome to MyPersonalDetails App ! ", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText= (EditText)findViewById(R.id.editText);
        editText1= (EditText)findViewById(R.id.editText2);
        editText3= (EditText)findViewById(R.id.editText3);
        calendar= Calendar.getInstance();
        year= calendar.get(Calendar.YEAR);
        month= calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
        showDate(day,month+1,year);

        Log.i(TAG, "State of activity 'MainActivity' :" + "OnCreate");

    }
    public void showDate(int day,int month, int year){
        editText3.setText(day+ "/"+month +"/"+year);
    }

    public void setDate(View v){
        showDialog(0);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==0)
            return new DatePickerDialog(this, myDateListener, year, month, day);
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener =new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year=year;
            if (year > Calendar.getInstance().get(Calendar.YEAR)) {
                Toast.makeText(MainActivity.this, "DOB can not be later than current date.", Toast.LENGTH_LONG).show();
                return;
            }
            month = monthOfYear + 1;
            day = dayOfMonth;

            showDate(day, month, year);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "State of activity 'MainActivity' :" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "State of activity 'MainActivity' :" + "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "State of activity 'MainActivity' :" + "onPause");
   }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "State of activity 'MainActivity' :" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "State of activity 'MainActivity' :" + "onDestroy");
    }

    public void onClickClear(View v)
    {
      editText.setText("");
        editText1.setText("");
        editText3.setText("");
    }



    public void onClick(View v)
    {
        //int ageCalculated= Calendar.getInstance().get(Calendar.YEAR)-year;
       // if(calendar.get(Calendar.MONTH)>month)
         //   ageCalculated+=1;
        //if(!(editText1.getText().equals(ageCalculated)))
        //{
          //  Toast.makeText(this,"Age is not correct as per DOB.", Toast.LENGTH_LONG).show();
            //return;

            //String s= String.valueOf(ageCalculated);
            //editText1.setText(s);

//        }
        Intent se = new Intent(this, secondActivity.class);
        String s1= editText.getText().toString();
        String s2= editText1.getText().toString();
        String s3= editText3.getText().toString();

        se.putExtra("name",s1 );
        se.putExtra("age",s2 );
        se.putExtra("dob",s3 );

        startActivity(se);
    }


}
