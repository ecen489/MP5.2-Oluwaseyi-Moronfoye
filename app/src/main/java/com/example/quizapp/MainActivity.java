package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.Scanner;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private static final String[] topics = new String[5];
    private static final int REQ_CODE_ANS = 2468;
    int score = 0;

//    ArrayList<String> topicsArray = {"Movies","Music", "Animals","Technology"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Scanner scan = new Scanner(getResources().openRawResource(R.raw.topics));

        int i = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            topics[i] = line;
            i++;
        }
        scan.close();

        final Intent intent = new Intent(this, Main2Activity.class);


        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, topics);

        ListView list = (ListView) findViewById(R.id.lView);
        list.setAdapter(myadapter);


        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> list, View row, int index, long rowID) {

                        String topic = list.getItemAtPosition(index).toString();


                        intent.putExtra("topic", topic);
                        startActivityForResult(intent,REQ_CODE_ANS);


                    }
                }
        );
    }

    public void restButton(View view) {
        score = 0;
        TextView sV = (TextView) findViewById(R.id.scoreView);
        sV.setText(Integer.toString(score));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQ_CODE_ANS) {
            int point = intent.getIntExtra("point", 0);
            score = score + point;
            TextView sV = findViewById(R.id.scoreView);
            sV.setText(Integer.toString(score));
        }
    }
}
