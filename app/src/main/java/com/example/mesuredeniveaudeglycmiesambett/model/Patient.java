package com.example.mesuredeniveaudeglycmiesambett.model;

public class Patient {
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
    // "Notify" Model --> Controller

    public  String getReponse() {
        return reponse;
    }


}



