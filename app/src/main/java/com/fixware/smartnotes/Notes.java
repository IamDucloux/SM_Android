package com.fixware.smartnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Notes extends AppCompatActivity {

    private EditText editTextNote;
    private EditText editTextTitle;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        editTextNote = (EditText) findViewById(R.id.editText_note);
        editTextTitle = (EditText) findViewById(R.id.editText_Title);
        btn_save = (Button) findViewById(R.id.btn_save);



        String Notes [] = fileList();



    }


    public void guardarNota(View v){
        try {

            OutputStreamWriter file = new OutputStreamWriter(openFileOutput(editTextTitle.getText().toString(), Activity.MODE_PRIVATE));
            file.write(editTextNote.getText().toString());
            file.flush();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error, El titulo no puee estar vacion", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

        }

        Toast.makeText(this, "La nota "+editTextTitle.getText().toString()+" se guardo con exito.", Toast.LENGTH_SHORT).show();

    }



}
