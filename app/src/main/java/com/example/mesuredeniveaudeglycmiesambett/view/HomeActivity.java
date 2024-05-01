package com.example.mesuredeniveaudeglycmiesambett.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mesuredeniveaudeglycmiesambett.R;

public class HomeActivity extends AppCompatActivity {
private Button btnConsultation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent explicite
                Intent intent = new Intent(HomeActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        init();
    }
    private void init(){
        btnConsultation = findViewById(R.id.btnConsultation);

    }
}