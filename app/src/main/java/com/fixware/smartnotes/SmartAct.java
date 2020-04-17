package com.fixware.smartnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SmartAct extends AppCompatActivity {
    private Button btn_test;
    private Button btn_notes;
    private Button btn_config;
    private Button btn_act;
    private RecyclerView recyclerViewNotes;
    private NoteRecycleViewAdapter noteRecycleViewAdapter;
    public String notes [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart);

        btn_test = (Button) findViewById(R.id.buttonTest);
        btn_notes = (Button) findViewById(R.id.buttonNote);
        btn_config = (Button) findViewById(R.id.buttonConf);
        recyclerViewNotes = (RecyclerView) findViewById(R.id.RecyclerNotes);
        notes = fileList();

        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SmartAct.this, TestAct.class);
                startActivity(intent);
            }
        });

        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SmartAct.this, NoteAct.class);
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

        noteRecycleViewAdapter = new NoteRecycleViewAdapter(getNotes());
        recyclerViewNotes.setAdapter(noteRecycleViewAdapter);


    }

    public List<Note> getNotes(){
        List<Note> note = new ArrayList<>();
        for (String s: notes
             ) {
            note.add(new Note(s,"Futura version",R.mipmap.ic_launcher_foreground));
        }

        return note;
    }

    public void ActNotes(View v){
        noteRecycleViewAdapter = new NoteRecycleViewAdapter(getNotes());
        recyclerViewNotes.setAdapter(noteRecycleViewAdapter);
    }

    /*public void updateNotes(View v){
        Toast.makeText(this, "El boton se activo", Toast.LENGTH_SHORT).show();
        notes = fileList();
        editTextNotes.setText(null);
        for (String s : notes) {
            editTextNotes.setText(editTextNotes.getText().toString()+"\n"+s);
        }
        ;
    }*/



}
