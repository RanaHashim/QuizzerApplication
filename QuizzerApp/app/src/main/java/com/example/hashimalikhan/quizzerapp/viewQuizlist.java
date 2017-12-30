package com.example.hashimalikhan.quizzerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewQuizlist extends AppCompatActivity {
    private Button Log_out,attempt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_quizlist);
    logOut();
        attempt_quiz();
    }
    public void logOut(){
        Log_out=(Button) findViewById(R.id.button3);
        Log_out.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(viewQuizlist.this,login.class);
                startActivity(intent);
            }
        });
    }
    public void attempt_quiz(){
        attempt=(Button) findViewById(R.id.attemptBtn);
        attempt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(viewQuizlist.this,attemptQuiz.class);
                startActivity(intent);
            }
        });
    }
}
