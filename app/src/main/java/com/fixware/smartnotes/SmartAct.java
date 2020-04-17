package com.fixware.smartnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmartAct extends AppCompatActivity {
    private Button btn_test;
    private Button btn_notes;
    private Button btn_config;
    private Button btn_act;
    private EditText editTextNotes;
    public String notes [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart);

        btn_test = (Button) findViewById(R.id.buttonTest);
        btn_notes = (Button) findViewById(R.id.buttonNote);
        btn_config = (Button) findViewById(R.id.buttonConf);

        editTextNotes = (EditText) findViewById(R.id.editText_Result);
        notes = fileList();



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

    public void updateNotes(View v){
        Toast.makeText(this, "El boton se activo", Toast.LENGTH_SHORT).show();
        notes = fileList();
        editTextNotes.setText(null);
        for (String s : notes) {
            editTextNotes.setText(editTextNotes.getText().toString()+"\n"+s);
        }
        ;
    }



}
