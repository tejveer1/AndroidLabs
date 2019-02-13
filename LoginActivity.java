package com.example.nisini.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    protected static final String Activity_Name = "LoginActivity";
   // protected Button loginButton;

    Button button1;
    String demail = "email@domain.com";

  //  public static String pref_emails = "myEmails";
    //public static SharedPreferences sharedPref ;
    //static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Log.i(Activity_Name, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //sharedPref = getSharedPreferences(pref_emails, Context.MODE_PRIVATE);

        final SharedPreferences email = getPreferences(Context.MODE_PRIVATE);
        final EditText editT = (EditText) findViewById(R.id.editText);
        String address = email.getString("defEmail", demail);
        editT.setText(address);

        button1 = (Button) findViewById(R.id.button);
        email.getString("defEmail", demail);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputemail = editT.getEditableText().toString();
                SharedPreferences.Editor write = email.edit();
                write.putString("DefaultEmail", inputemail);
                write.commit();

                Intent startIntent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(startIntent);

            }
        });

    }

    protected void onStart(){
        Log.i(Activity_Name, "In onStart()");
        super.onStart();
    }

    protected void onResume() {
        Log.i(Activity_Name, "In onResume()");
        super.onResume();
    }

    protected void onPause(){
        Log.i(Activity_Name, "In onPause()");
        super.onPause();
    }
    protected void onStop(){
        Log.i(Activity_Name, "In onStop()");
        super.onStop();
    }
    protected void onDestroy(){
        Log.i(Activity_Name, "In onDestroy()");
        super.onDestroy();
    }
}
