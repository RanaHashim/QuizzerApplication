package com.example.hashimalikhan.quizzerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class result extends AppCompatActivity {
    Button rLogOut,Attempt_new;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        logOut();
        new_quiz();
    }
    public void logOut(){
        rLogOut=(Button) findViewById(R.id.button7);
        rLogOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(result.this,login.class);
                startActivity(intent);
            }
        });
    }
    public void new_quiz(){
        Attempt_new=(Button) findViewById(R.id.button8);
        Attempt_new.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(result.this,viewQuizlist.class);
                startActivity(intent);
            }
        });
    }
}
