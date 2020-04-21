package com.fixware.smartnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NoteAct extends AppCompatActivity {

    private EditText editTextNote;
    private EditText editTextTitle;
    private Button btn_save;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        editTextNote = (EditText) findViewById(R.id.editText_note);
        editTextTitle = (EditText) findViewById(R.id.editText_Title);
        String Notes [] = fileList();



        if(getIntent().getExtras() != null){
            //Bundle extras = getIntent().getExtras();
            extras = getIntent().getExtras();
            editTextTitle.setText(extras.getString("NoteTitle"));
            editTextNote.setText(AbrirNota(editTextTitle.getText().toString()));
        }









    }


    public void guardarNota(View v){
        //Toast.makeText(this, "El boton se activo", Toast.LENGTH_SHORT).show();
        try {

            OutputStreamWriter file = new OutputStreamWriter(openFileOutput(editTextTitle.getText().toString(), Activity.MODE_PRIVATE));
            file.write(editTextNote.getText().toString());
            file.flush();
            file.close();
            //Toast.makeText(this, "El archivo se cerro", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "La nota "+editTextTitle.getText().toString()+" se guardo con exito.", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error, El titulo no puee estar vacio", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

        }



    }


    public String AbrirNota(String NoteTitle){
        String content = "";
        try{
            InputStreamReader opener = new InputStreamReader(openFileInput(NoteTitle));
            BufferedReader reader = new BufferedReader(opener);
            String linea = reader.readLine();


            while(linea != null){
                content += linea + "\n";
                linea = reader.readLine();
            }

            reader.close();
            opener.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return content;
    }



}
