package com.fixware.smartnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestAct extends AppCompatActivity {

    private Button nuevoTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        nuevoTest = (Button) findViewById(R.id.buttonNuevo);

        nuevoTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAct.this, CreateTest.class);
                startActivity(intent);
            }
        });

    }
}
