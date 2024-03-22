package com.example.mesuredeniveaudeglycmiesambett;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvAge, tvReponse;
    private SeekBar sbAge;
    private RadioButton rbtOui , rbtNon;
    private Button btnConsulter;
    private EditText etValeur;

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
                    calculer();
                }
            }
        });
    }

        //listener explicitly created that's why the method is private
        public void calculer ()
        {
            int age = Integer.valueOf(sbAge.getProgress());
            float valeurMesuree = Float.valueOf(etValeur.getText().toString());
            boolean isFasting = rbtOui.isChecked();
            if(isFasting) {
                if (age >= 13) {
                    if (valeurMesuree < 5.0)
                        tvReponse.setText("Very Low Levels");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                        tvReponse.setText("Normal Levels");
                    else
                        tvReponse.setText("Very High Levels");
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5.0)
                        tvReponse.setText("Very Low Levels");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                        tvReponse.setText("Normal Levels");
                    else
                        tvReponse.setText("Very High Levels");
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        tvReponse.setText("Very Low Levels");
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        tvReponse.setText("Normal Levels");

                    else
                        tvReponse.setText("Very High Levels");
                }
            } else {
                if (valeurMesuree > 10.5)
                    tvReponse.setText("Very High Levels");
                else
                    tvReponse.setText("Normal levels");
            }
        }
        private void init(){
        tvAge = findViewById(R.id.tvAge);
        tvReponse = findViewById(R.id.tvReponse);
        sbAge = findViewById(R.id.sbAge);
        btnConsulter = findViewById(R.id.btnConsulter);
        rbtNon = findViewById(R.id.rbtNon);
        rbtOui = findViewById(R.id.rbtOui);
        etValeur = findViewById(R.id.etValeur);
    }



}