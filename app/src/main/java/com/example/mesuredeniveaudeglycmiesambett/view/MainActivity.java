package com.example.mesuredeniveaudeglycmiesambett.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mesuredeniveaudeglycmiesambett.R;
import com.example.mesuredeniveaudeglycmiesambett.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private final String RESPONSE_key = "reponse";
    private final int Request_Code = 1; // code de l'activite ConsultActivity
    private TextView tvAge; //, tvReponse in consult activity
    private SeekBar sbAge;
    private RadioButton rbtOui , rbtNon;
    private Button btnConsulter;
    private EditText etValeur;
    private Controller controller ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean

                    fromUser) {

                Log.i("Information", "onProgressChanged "+progress);
                tvAge.setText("Votre âge : "+ progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        btnConsulter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int age;
                float valeur;
                Log.i("Information", "button clicked");
                boolean verifAge = false, verifValeur = false;
                if(sbAge.getProgress()!=0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Saisir votre age !", Toast.LENGTH_SHORT).show();

                if(!etValeur.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();
                if(verifAge && verifValeur)
                {
                   age = sbAge.getProgress();
                   valeur = Float.valueOf((etValeur.getText().toString()));
                   // "UserAction" View --> Controller
                    controller.createPatient(age,valeur,rbtOui.isChecked());
                    // Notify Controller -->View
                    //tvReponse.setText((controller.getReponse()));
                    Intent intent = new Intent(getApplicationContext(),ConsultActivity.class); //MainActivity.this is also correct
                    intent.putExtra(RESPONSE_key ,controller.getReponse() );
                    startActivityForResult(intent, Request_Code);

                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Request_Code)
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"erruer, result code canceled",Toast.LENGTH_LONG).show();
            }
    }

    //listener explicitly created that's why the method is private

        private void init(){
        controller = Controller.getInstance();
        tvAge = findViewById(R.id.tvAge);
        //tvReponse = findViewById(R.id.tvReponse); in consult activity
        sbAge = findViewById(R.id.sbAge);
        btnConsulter = findViewById(R.id.btnConsulter);
        rbtNon = findViewById(R.id.rbtNon);
        rbtOui = findViewById(R.id.rbtOui);
        etValeur = findViewById(R.id.etValeur);
    }



}