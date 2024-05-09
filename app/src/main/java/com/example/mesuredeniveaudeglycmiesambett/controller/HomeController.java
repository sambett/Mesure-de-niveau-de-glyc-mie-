package com.example.mesuredeniveaudeglycmiesambett.controller;

import com.example.mesuredeniveaudeglycmiesambett.model.User;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.SpanWatcher;


    public class HomeController {
        private static User user;
        private static HomeController instance = null; // instance sauvegardée
        public HomeController() {super();}  //on dirait constructeur par défaut
        private static final String SHARED_PREFS ="HomeActivitySharedPrefs";

        public static final HomeController getInstance(Context context)
        {
            if(instance==null)
                instance=new HomeController();
            //recuperation de user
            recapUser(context);
            return HomeController.instance;
        }

        public void createUser(String email, String password, Context context)
        {
            user = new User(email, password);
            SharedPreferences SharedPreferences = context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = SharedPreferences.edit();
            editor.putString("email",email);
            editor.putString("password",password);
            editor.apply();
        }

        public static void recapUser(Context context)
        {
            SharedPreferences SharedPreferences = context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
            String email =SharedPreferences.getString("email","");
            String password =SharedPreferences.getString("password","");
            user=new User(email,password);
        }

        public String getUserEmail() {
            return user.getUserEmail();
        }

        public String getPassword() {
            return user.getPassword();
        }


    }
