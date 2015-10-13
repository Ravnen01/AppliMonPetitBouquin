package com.lpiem.mylittelbook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

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
                Snackbar.make(view, "Aucune Connexion", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


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
