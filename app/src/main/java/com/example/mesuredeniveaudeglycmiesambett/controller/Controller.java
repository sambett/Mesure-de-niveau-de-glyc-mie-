package com.example.mesuredeniveaudeglycmiesambett.controller;

import com.example.mesuredeniveaudeglycmiesambett.model.Patient;

public final class Controller {
    private static Controller instance = null;
    private static Patient patient;

    private Controller()
    {
        super();
    }
    public static final Controller getInstance() {
        if(Controller.instance == null)
             Controller.instance = new Controller();
        return Controller.instance;
    }


    // "UserAction" View --> Controller --> Model
    public void createPatient(int age, float valeurMesuree,
                              boolean isFasting){
        //"Update" Controller --> Model
        patient = new Patient(age, valeurMesuree,isFasting);
    }


    //"Notify" Model --> Controller -->View
    public String getReponse() {
        return patient.getReponse();
    }
}
