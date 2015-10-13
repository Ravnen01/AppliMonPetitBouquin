package com.lpiem.mylittelbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AddBookActivity.class);
                startActivity(intent);
            }
        });

        CustomListBookActivity listAdapter=new CustomListBookActivity(createListBook(),this.getApplicationContext());
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(listAdapter);


    }

    public ArrayList<String> createListBook(){
        ArrayList<String> listBook=new ArrayList<>();
        listBook.add("Le Seigneur des Anneaux 1");
        listBook.add("Le Seigneur des Anneaux 2");
        listBook.add("Le Seigneur des Anneaux 3");
        listBook.add("Le Seigneur des Anneaux 4");
        return listBook;
    }

}
