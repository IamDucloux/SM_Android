package com.fixware.smartnotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.EditText;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;


public class CreateTest extends AppCompatActivity {

    private EditText test_title;
    private RecyclerView questions;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_test);

        test_title = (EditText) findViewById(R.id.editText_Title);
        questions = (RecyclerView) findViewById(R.id.recyclerView_questions);


        FloatingActionButton fab = findViewById(R.id.save);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });






    }

    /*public boolean BuscarTitulo(String titulo){
        boolean bandera = false;
        ArrayList <String> titulos = new ArrayList<>();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Data", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();






    }*/


    public void CrearTest(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Data", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String title = test_title.getText().toString();

        if(!title.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("Titulo",title);
            db.insert("Tests",null,registro);

            db.close();
            test_title.setText(null);

        }


    }

}
