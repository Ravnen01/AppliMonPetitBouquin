package com.lpiem.testobserveur.Controleur;

/**
 * Created by iem2 on 03/11/15.
 */
public interface Observable {
    void addObserveur(Observeur observeur);
    void delObserveur(Observeur observeur);
    void notif();
}
