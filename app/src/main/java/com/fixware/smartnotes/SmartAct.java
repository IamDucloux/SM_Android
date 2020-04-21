package com.fixware.smartnotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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
    private SwipeRefreshLayout swipeRefreshLayout;
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
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.SW_Notes);
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

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                noteRecycleViewAdapter = new NoteRecycleViewAdapter(getNotes());
                recyclerViewNotes.setAdapter(noteRecycleViewAdapter);

                swipeRefreshLayout.setRefreshing(false);
            }
        });

        recyclerViewNotes.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                try {
                    View child = recyclerViewNotes.findChildViewUnder(e.getX(), e.getY());

                    if (child != null ){
                        int pos =recyclerViewNotes.getChildAdapterPosition(child);
                        //Toast.makeText(SmartAct.this, "Tocaste el item "+pos, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SmartAct.this, NoteAct.class);
                        intent.putExtra("NoteTitle", getNotes().get(pos).getTitle());
                        startActivity(intent);


                    }

                }catch (Exception ex){
                    Toast.makeText(SmartAct.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

                return true;
            }


            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });



    }

    

    public List<Note> getNotes(){
        notes = fileList();
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

    public void goNote(View v){
        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SmartAct.this, NoteAct.class);
                startActivity(intent);

            }
        });
    }


}
