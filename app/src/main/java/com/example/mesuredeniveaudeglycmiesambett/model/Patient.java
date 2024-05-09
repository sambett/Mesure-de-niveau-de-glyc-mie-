package com.example.mesuredeniveaudeglycmiesambett.model;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
    private Date dateMesure;
    private int age;
    private float valeurMesuree;
    private boolean isFasting;
    private  String reponse;

    // "Update" Controller --> Model
    public Patient(int age, float valeurMesuree,
                   boolean isFasting) {
        this.age = age;
        this.valeurMesuree = valeurMesuree;
        this.isFasting = isFasting;
        setReponse(); //calculer le resulat et faire un set to reponse
    }




    public void setReponse()
    {
        if(isFasting) {
            if (age >= 13) {
                if (valeurMesuree < 5.0)
                    reponse="Very Low Levels";
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                    reponse="Normal Levels";
                else
                    reponse="Very High Levels";
            } else if (age >= 6 && age <= 12) {
                if (valeurMesuree < 5.0)
                    reponse ="Very Low Levels";
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                    reponse="Normal Levels";
                else
                    reponse="Very High Levels";
            } else if (age < 6) {
                if (valeurMesuree < 5.5)
                   reponse="Very Low Levels";
                else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                    reponse="Normal Levels";

                else
                    reponse="Very High Levels";
            }
        } else {
            if (valeurMesuree > 10.5)
                reponse="Very High Levels";
            else
                reponse="Normal Levels";
        }


    }
    public int getAge() {
        return age;
    }
    public float getValeurMesuree() {
        return valeurMesuree;
    }
    public boolean isFasting() {
        return isFasting;
    }

    public Date getDate() {
        return dateMesure;
    }


    //Flèche "Notify" Model --> Controller
    public String getReponse() {
        return reponse;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setValeurMesuree(float valeurMesuree) {
        this.valeurMesuree = valeurMesuree;
    }

    public void setFasting(boolean fasting) {
        isFasting = fasting;
    }

    /**
     * conversion du patient en format JSONArray
     * @return
     */
    public JSONArray convertToJSONArray (){
        List laListe = new ArrayList<>();
        laListe.add(dateMesure);
        laListe.add(age);
        laListe.add(isFasting);
        laListe.add(valeurMesuree);
        return new JSONArray(laListe);
    }



}




