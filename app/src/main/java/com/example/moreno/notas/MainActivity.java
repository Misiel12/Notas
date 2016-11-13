package com.example.moreno.notas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT,"New note");
        Uri noteUri = getContentResolver().insert(NotesProvider.CONTENT_URI,values);
        Log.d("MainActivity","Inserted note" + noteUri.getLastPathSegment() );
    }

}
