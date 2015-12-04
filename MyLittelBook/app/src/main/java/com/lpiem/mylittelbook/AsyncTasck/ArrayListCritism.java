package com.lpiem.mylittelbook.AsyncTasck;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.lpiem.mylittelbook.CustomListCritisumActivity;
import com.lpiem.mylittelbook.Model.Criticism;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by iem2 on 02/11/15.
 */
public class ArrayListCritism extends AsyncTask {

    private ListView listView;
    private Context context;
    private ArrayList<Criticism> listCritism=new ArrayList<>();
    private String idBook;

    public ArrayListCritism(ListView listView, Context context, String idBook) {
        this.listView = listView;
        this.context = context;
        this.idBook = idBook;
    }
    @Override
    protected Object doInBackground(Object[] params) {
        URL url= null;
        try {
            url = new URL("http://book.local/criticism/"+idBook);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            BufferedReader in=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            JSONArray jsonArray=new JSONArray(in.readLine());
            for(int i=0;i<jsonArray.length();i++) {
                listCritism.add(new Criticism(jsonArray.getJSONObject(i)));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        listView.setAdapter(new CustomListCritisumActivity(listCritism, context));
    }
}
