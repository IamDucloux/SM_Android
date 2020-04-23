package com.fixware.smartnotes;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase data) {
        data.execSQL("PRAGMA FOREIGN_KEYS = True");
        data.execSQL("CREATE TABLE Respuestas(Id_respuesta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Cuerpo VARCHAR(30) NOT NULL, Correcta BOOLEAN NOT NULL)");
        data.execSQL("CREATE TABLE Preguntas(Id_pregunta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Cuerpo VARCHAR(60) NOT NULL)");
        data.execSQL("CREATE TABLE Tests(Id_test INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Titulo VARCHAR(30) NOT NULL)");
        data.execSQL("CREATE TABLE Test_Preguntas(T_Id_test INTEGER NOT NULL, P_Id_pregunta INTEGER NOT NULL, FOREIGN KEY (T_Id_test) REFERENCES Test(Id_test), FOREIGN KEY (P_Id_pregunta) REFERENCES Preguntas(Id_pregunta))");
        data.execSQL("CREATE TABLE Preguntas_Respuestas(P_Id_pregunta INTEGER NOT NULL, R_Id_respuesta INTEGER NOT NULL, FOREIGN KEY (P_Id_pregunta) REFERENCES Preguntas(Id_pregunta), FOREIGN KEY (R_Id_respuesta) REFERENCES Respuestas(Id_respuesta))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
