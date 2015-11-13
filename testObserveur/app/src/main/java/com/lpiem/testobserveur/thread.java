package com.lpiem.testobserveur;

import android.os.AsyncTask;

import com.lpiem.testobserveur.Controleur.Observable;
import com.lpiem.testobserveur.Controleur.Observeur;

import java.util.ArrayList;

/**
 * Created by iem2 on 03/11/15.
 */
public class thread extends AsyncTask implements Observable {
    private ArrayList<Observeur> listObserveur=new ArrayList<>();
    @Override
    protected Object doInBackground(Object[] params) {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        return null;
    }

    @Override
    public void addObserveur(Observeur observeur) {
        listObserveur.add(observeur);

    }

    @Override
    public void delObserveur(Observeur observeur) {
        listObserveur.remove(observeur);
    }

    @Override
    public void notif() {
        for(int i=0;i<listObserveur.size();i++){
            listObserveur.get(i).onUpdate();
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        notif();
        thread t = new thread();
        t.addObserveur(listObserveur.get(0));
        t.execute();
    }
}
