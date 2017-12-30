package com.example.hashimalikhan.quizzerapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hashim Ali Khan on 12/30/2017.
 */

public class quizRequest extends StringRequest {
    private static final String QUIZ_REQUEST_URL="http://quizzerapplication.000webhostapp.com/saveQuiz.php";
    private Map<String,String> params;
    //int quizNo,int quesno,String question,String qtype,String optionA,String optionB,String optionC,String optionD,String answer,String t,String f
    public quizRequest(questions qs, Response.Listener<String> listener){
         super(Method.POST,QUIZ_REQUEST_URL,listener,null);
         params=new HashMap<>();
         params.put("quizNo",qs.getQuizNo()+"");
         params.put("qno",qs.getQno()+"");
         params.put("question",qs.getQuestion());
         params.put("qtype",qs.getQtype());
         params.put("optionA",qs.getOptionA());
         params.put("optionB",qs.getOptionB());
         params.put("optionC",qs.getOptionC());
         params.put("optionD",qs.getOptionD());
         params.put("answer",qs.getAnswer());
         params.put("t",qs.getT());
         params.put("f",qs.getF());
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
