package com.example.hashimalikhan.quizzerapp;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class createQuiz extends AppCompatActivity {
    private Spinner spinner1;
    private EditText tit;
    private EditText des;
    private Button log_out,save,reset,add_btn;
    private static int counter=0;
    private static int quizno=0;
    private List<questionsController> allques = new ArrayList<questionsController>();
    private questions questionlist=new questions();
    private quizes quizdet=new quizes();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        quizno++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);
        spinner1=(Spinner) findViewById(R.id.qtype);
        List list = new ArrayList();
        list.add("Mcq");
        list.add("True/False");
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        tit=(EditText)findViewById(R.id.editText3);
        des=(EditText)findViewById(R.id.editText4);
        logOut_btn();
        save_btn();
        reset_btn();
        add_btn();
    }
    public void logOut_btn(){
        log_out = (Button) findViewById(R.id.lgOut);
        // Capture button clicks
        log_out.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(createQuiz.this, login.class);
                startActivity(myIntent);}
        });
    }
    public void save_btn(){
        save = (Button) findViewById(R.id.savebtn);
        // Capture button clicks
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                counter=0;
                save_quiz();
                // Start NewActivity.class
               // Intent myIntent = new Intent(createQuiz.this, options.class);
                //startActivity(myIntent);
            }
        });
    }
    public void save_quiz(){
        quizdet.setTitle(tit.getText().toString());
        quizdet.setDescription(des.getText().toString());
        quizdet.setQuizNo(quizno);
        quizdet.setScore(0);
        int i;
        i=0;
            questionlist.setQuizNo(quizno);
            questionlist.setQno(allques.get(i).qno);
            questionlist.setQuestion(allques.get(i).question.toString());
            questionlist.setQtype(allques.get(i).type.toString());
            if(allques.get(i).type.equals("Mcq")) {
                questionlist.setOptionA(allques.get(i).optionA.toString());
                questionlist.setOptionB(allques.get(i).optionB.toString());
                questionlist.setOptionC(allques.get(i).optionC.toString());
                questionlist.setOptionD(allques.get(i).optionD.toString());
                questionlist.setAnswer(allques.get(i).correct.toString());
            }
            else if(allques.get(i).type.equals("True/False")){
                String radioValue=((RadioButton)findViewById(allques.get(0).rg.getCheckedRadioButtonId())).getText().toString();
                questionlist.setT("True");
                questionlist.setF("False");
                questionlist.setAnswer(radioValue);
            }
            Response.Listener<String> responseListener=new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse=new JSONObject(response);
                        boolean success=jsonResponse.getBoolean("success");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            };
            quizRequest quizRequest=new quizRequest(questionlist,responseListener);
            RequestQueue queue= Volley.newRequestQueue(createQuiz.this);
            queue.add(quizRequest);
        Intent myIntent=new Intent(createQuiz.this,options.class);
        startActivity(myIntent);
    }
    public void reset_btn(){
        reset = (Button) findViewById(R.id.reset_btn);
        // Capture button clicks
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                counter=0;
                // Start NewActivity.class
                Intent myIntent = new Intent(createQuiz.this, createQuiz.class);
                startActivity(myIntent);}
        });
    }
    public void add_btn(){
        add_btn = (Button) findViewById(R.id.add);
        final LinearLayout lm = (LinearLayout) findViewById(R.id.qplace);
        lm.setOrientation(LinearLayout.VERTICAL);
        // Capture button clicks
        add_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                counter++;
                questionsController qs=new questionsController();
                TextView qno=new TextView(createQuiz.this);
                qno.setText("Q. "+counter);
                qs.qno=counter;
                qs.quiz_no=quizno;
                qs.question=new EditText(createQuiz.this);
                lm.addView(qno);
                lm.addView(qs.question);
                qs.type=spinner1.getSelectedItem().toString();
                if(qs.type.equals("Mcq"))
                {

                    TextView labelA=new TextView(createQuiz.this);
                    labelA.setText("A");
                    qs.optionA=new EditText(createQuiz.this);
                    TextView labelB=new TextView(createQuiz.this);
                    labelB.setText("B");
                    qs.optionB=new EditText(createQuiz.this);
                    TextView labelC=new TextView(createQuiz.this);
                    labelC.setText("C");
                    qs.optionC=new EditText(createQuiz.this);
                    TextView labelD=new TextView(createQuiz.this);
                    labelD.setText("D");
                    qs.optionD=new EditText(createQuiz.this);
                    lm.addView(labelA);
                    lm.addView(qs.optionA);
                    lm.addView(labelB);
                    lm.addView(qs.optionB);
                    lm.addView(labelC);
                    lm.addView(qs.optionC);
                    lm.addView(labelD);
                    lm.addView(qs.optionD);
                    TextView calabel=new TextView(createQuiz.this);
                    calabel.setText("Correct:");
                    qs.correct=new EditText(createQuiz.this);
                    lm.addView(calabel);
                    lm.addView(qs.correct);
                }
                else if(qs.type.equals("True/False")){
                    qs.rg=new RadioGroup(createQuiz.this);
                    RadioButton truebtn=new RadioButton(createQuiz.this);
                    truebtn.setText("True");
                    RadioButton falsebtn=new RadioButton(createQuiz.this);
                    falsebtn.setText("False");
                    qs.rg.addView(truebtn);
                    qs.rg.addView(falsebtn);
                    qs.rg.check(truebtn.getId());
                    lm.addView(qs.rg);
                }
                allques.add(qs);
            }
        });
    }
}
