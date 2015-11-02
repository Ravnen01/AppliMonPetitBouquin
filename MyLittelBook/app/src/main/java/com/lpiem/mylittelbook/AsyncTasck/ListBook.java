package com.lpiem.mylittelbook.AsyncTasck;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lpiem.mylittelbook.CustomListBookActivity;
import com.lpiem.mylittelbook.ListCritism;
import com.lpiem.mylittelbook.Model.Book;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by iem2 on 02/11/15.
 */
public class ListBook extends AsyncTask {

    private ListView listView;
    private Context context;
    private ArrayList<Book> listBook=new ArrayList<>();

    public ListBook(ListView listView, Context context) {
        this.listView = listView;
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            URL url=new URL("http://192.168.240.31/book");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            BufferedReader in=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            JSONArray jsonArray=new JSONArray(in.readLine());
            for(int i=0;i<jsonArray.length();i++) {
                listBook.add(new Book(jsonArray.getJSONObject(i)));
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        listView.setAdapter(new CustomListBookActivity(listBook, context));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(context, ListCritism.class);
                Bundle b=new Bundle();
                b.putString("bookID",listBook.get(position).getIsbn());
                i.putExtras(b);
                context.startActivity(i);
            }
        });
    }
}
