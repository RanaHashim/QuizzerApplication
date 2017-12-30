package com.example.hashimalikhan.quizzerapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {
    Spinner role;

    private String password=new String();
    private String nam=new String();
    private Button log;
    private EditText text1;
    private EditText text2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);
        // Locate the button in activity_main.xml
        spinner_values();
       login_btn();
        text1=(EditText)findViewById(R.id.username);
        text2=(EditText)findViewById(R.id.pass);
        role=(Spinner)findViewById(R.id.role_as);
    }
    public void spinner_values(){
        role=(Spinner) findViewById(R.id.role_as);
        List list = new ArrayList();
        list.add("Teacher");
        list.add("Student");
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        role.setAdapter(dataAdapter);
    }
    public void login_btn(){
        log = (Button) findViewById(R.id.lg);
        // Capture button clicks
        log.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                String name;
                String password;
                String login_role;
                name = "fahad";
                password = "satti";
                login_role = role.getSelectedItem().toString();

                if (text1.getText().toString().equals(name) && text2.getText().toString().equals(password)&&login_role.equals("Teacher" ) ){

                        // Start NewActivity.class
                        Intent myIntent = new Intent(login.this,
                                options.class);
                        startActivity(myIntent);


                }
                else if(text1.getText().toString().equals("Hashim") && text2.getText().toString().equals("rana")&&login_role.equals("Student")){
                        Intent myIntent=new Intent(login.this,viewQuizlist.class);
                        startActivity(myIntent);
                    }

                else {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(login.this);
                    dlgAlert.setMessage("Username or Password is incorrect");
                    dlgAlert.setTitle("Invalid Username or password");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                };
                            });
                }
            }
        });
    }
}
