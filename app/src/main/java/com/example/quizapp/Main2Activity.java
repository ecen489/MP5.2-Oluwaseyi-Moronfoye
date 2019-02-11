package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.Scanner;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;

import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    private static final String[] topics = new String[5];
    private static final String[] answers = {"avatar","elvis presley","canine", "android"};
    private static final String[] questions = new String[5];


    String topic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Scanner scan = new Scanner(getResources().openRawResource(R.raw.topics));

        int i = 0;
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            topics[i]=line;
            i++;
        }

        scan = new Scanner(getResources().openRawResource(R.raw.questions));

        i = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            questions[i] = line;
            i++;
        }
        scan.close();


        Intent intent = getIntent();
        topic = intent.getStringExtra("topic");

        if(topic.equals(topics[0]))
        {
            TextView textView = (TextView) findViewById(R.id.question);
            textView.setText(questions[0]);

        }
        else if(topic.equals(topics[1]))
        {
            TextView textView = (TextView) findViewById(R.id.question);
            textView.setText(questions[1]);

        }
        else if(topic.equals(topics[2]))
        {
            TextView textView = (TextView) findViewById(R.id.question);
            textView.setText(questions[2]);

        }
        else
        {
            TextView textView = (TextView) findViewById(R.id.question);
            textView.setText(questions[3]);

        }
    }

    public void subButton(View view) {
        EditText tEdit = (EditText) findViewById(R.id.answer);

        String answer = tEdit.getText().toString().toLowerCase();


        Intent backIntent = new Intent();




        if(topic.equals(topics[0]))
        {
            if(answer.equals(answers[0]))
            {
                backIntent.putExtra("point", 1);
                Toast.makeText(Main2Activity.this, "Correct!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();

            }
            else
            {
                backIntent.putExtra("point", 0);
                Toast.makeText(Main2Activity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();
            }

        }
        else if(topic.equals(topics[1]))
        {
            if(answer.equals(answers[1]))
            {
                backIntent.putExtra("point", 1);
                Toast.makeText(Main2Activity.this, "Correct!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();

            }
            else
            {
                backIntent.putExtra("point", 0);
                Toast.makeText(Main2Activity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();
            }

        }
        else if(topic.equals(topics[2]))
        {
            if(answer.equals(answers[2]))
            {
                backIntent.putExtra("point", 1);
                Toast.makeText(Main2Activity.this, "Correct!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();

            }
            else
            {
                backIntent.putExtra("point", 0);
                Toast.makeText(Main2Activity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();
            }

        }
        else
        {
            if(answer.equals(answers[3]))
            {
                backIntent.putExtra("point", 1);
                Toast.makeText(Main2Activity.this, "Correct!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();

            }
            else
            {
                backIntent.putExtra("point", 0);

                Toast.makeText(Main2Activity.this, "Wrong!",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();
            }

        }



    }

}
