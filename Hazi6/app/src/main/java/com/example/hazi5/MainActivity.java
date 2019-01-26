package com.example.hazi5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    String[] animes = {"FCBarcelona", "Real Betis", "Borussia Dortmund"};

    ArrayList<String> list = new ArrayList<String>(Arrays.asList(animes));
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.zold:
                info.targetView.setBackgroundColor(Color.GREEN);
                adapter.notifyDataSetChanged();
                return  true;

            case R.id.piros:
                info.targetView.setBackgroundColor(Color.RED);
                adapter.notifyDataSetChanged();
                return  true;

            case R.id.sarga:
                info.targetView.setBackgroundColor(Color.YELLOW);
                adapter.notifyDataSetChanged();
                return  true;
            default :
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rendez:
                Collections.sort(list, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"List sorted alphabetically",Toast.LENGTH_LONG).show();
                return  true;
            case R.id.torol:
                list.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"List cleared",Toast.LENGTH_LONG).show();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
