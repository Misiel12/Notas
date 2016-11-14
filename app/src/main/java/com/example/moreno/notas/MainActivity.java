package com.example.moreno.notas;



import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import android.support.v7.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity
{


    private CursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertNote("New Note");

        Cursor cursor = getContentResolver().query(NotesProvider.CONTENT_URI,
                DBOpenHelper.ALL_COLUMNS, null, null, null, null);

        String[] from = {DBOpenHelper.NOTE_TEXT};
        int[] to = {android.R.id.text1};

        cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, cursor, from, to, 0);
        ListView List = (ListView) findViewById(R.id.list_view_1);

       List.setAdapter(cursorAdapter);


    }

    private void insertNote(String noteText) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT, noteText);
        Uri noteUri = getContentResolver().insert(NotesProvider.CONTENT_URI,
                values);
        Log.d("MainActivity", "Inserted note " + noteUri.getLastPathSegment());
    }

}
