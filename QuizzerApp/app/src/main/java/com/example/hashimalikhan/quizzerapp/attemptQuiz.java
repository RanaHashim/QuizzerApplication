package com.example.hashimalikhan.quizzerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class attemptQuiz extends AppCompatActivity {
    Button log_out1,finish,new_quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attempt_quiz);
        log_out();
        finish_quiz();
        newQuiz();
    }
    public void log_out(){
        log_out1=(Button) findViewById(R.id.button4);
        log_out1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent myintent=new Intent(attemptQuiz.this,login.class);
                startActivity(myintent);
            }
        });
    }
    public void finish_quiz(){
        finish=(Button) findViewById(R.id.button5);
        finish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent myintent=new Intent(attemptQuiz.this,result.class);
                startActivity(myintent);
            }
        });
    }
    public void newQuiz(){
        new_quiz=(Button) findViewById(R.id.button6);
        new_quiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent myintent=new Intent(attemptQuiz.this,viewQuizlist.class);
                startActivity(myintent);
            }
        });
    }

}
