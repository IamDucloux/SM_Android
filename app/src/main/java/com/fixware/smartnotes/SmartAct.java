package com.fixware.smartnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SmartAct extends AppCompatActivity {
    private Button btn_test;
    private Button btn_notes;
    private Button btn_config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart);

        btn_test = (Button) findViewById(R.id.buttonTest);
        btn_notes = (Button) findViewById(R.id.buttonNote);
        btn_config = (Button) findViewById(R.id.buttonConf);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SmartAct.this, Test.class);
                startActivity(intent);
            }
        });

        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SmartAct.this, Notes.class);
                startActivity(intent);

            }
        });

        btn_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SmartAct.this, Configuration.class);
                startActivity(intent);
            }
        });




    }
}
