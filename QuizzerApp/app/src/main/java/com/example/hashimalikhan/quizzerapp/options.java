package com.example.hashimalikhan.quizzerapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class options extends AppCompatActivity {
    Button create_quiz,view_quiz,log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        create_btn();
        view_btn();
        logOut_btn();
    }
    public void create_btn(){
        create_quiz = (Button) findViewById(R.id.createQ);
        // Capture button clicks
        create_quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(options.this, createQuiz.class);
                startActivity(myIntent);}
        });
    }
    public void view_btn(){
        view_quiz = (Button) findViewById(R.id.viewQ);
        // Capture button clicks
        view_quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(options.this, viewQuizlist.class);
                startActivity(myIntent);}
        });
    }
    public void logOut_btn(){
        log_out = (Button) findViewById(R.id.logOut);
        // Capture button clicks
        log_out.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(options.this, login.class);
                startActivity(myIntent);}
        });
    }
}
