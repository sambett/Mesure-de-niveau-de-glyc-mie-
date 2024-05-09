package com.example.mesuredeniveaudeglycmiesambett.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mesuredeniveaudeglycmiesambett.R;


public class ConsultActivity extends AppCompatActivity {
    private TextView tvReponse ;
    private Button btnRetour;
    private final String RESPONSE_KEY = "result";

    private String reponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult); // Set the layout for this activity

        // Retrieve the Intent that started this activity
        Intent intent = getIntent();

        // Extract the string extra from the Intent
        reponse = intent.getStringExtra(RESPONSE_KEY);

        // Set the extracted response string to the TextView
        tvReponse.setText(reponse);

        // Set OnClickListener for the btnRetour Button
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); // Create a new Intent

                // Check if response string is null
                if (reponse == null)
                    setResult(RESULT_CANCELED, intent); // Set result as canceled
                else
                    setResult(RESULT_OK, intent); // Set result as OK

                finish(); // Finish this activity
            }
        });

        init(); // Call the init() method
    }
    private void init(){
        tvReponse = findViewById(R.id.tvReponse);
        btnRetour = findViewById(R.id.btnConsulter);

    }
}