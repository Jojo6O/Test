package com.example.mini_jeucalcul;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GameActivity extends AppCompatActivity {
    private TextView TextViewCalcul,TextViewReponse,TextViewScore,TextViewVie,TextViewValide;;
    int num1,num2,resultat;
    private Button boutonValider;
    private Button boutonEffacer;
    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Integer Nombre = 0, Score = 0, Vie = 3;
    String operateur;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextViewCalcul = findViewById(R.id.TextViewCalcul);
        TextViewReponse = findViewById(R.id.TextViewReponse);
        TextViewValide = findViewById(R.id.TextViewValide);

        GenererCalcul();
        boutonValider = findViewById(R.id.boutonValider);
        boutonValider.setOnClickListener(view -> {
            verifNombre();
        });
        boutonEffacer = findViewById(R.id.boutonEffacer);
        boutonEffacer.setOnClickListener(view -> {
            TextViewReponse.setText("0");
            Nombre=0;
        });
        bouton0 = findViewById(R.id.bouton_zero);
        bouton0.setOnClickListener(view -> {
            ajouterChiffre(0);
        });
        bouton1 = findViewById(R.id.bouton_un);
        bouton1.setOnClickListener(view -> {
            ajouterChiffre(1);
        });
        bouton2 = findViewById(R.id.bouton_deux);
        bouton2.setOnClickListener(view -> {
            ajouterChiffre(2);
        });
        bouton3 = findViewById(R.id.bouton_trois);
        bouton3.setOnClickListener(view -> {
            ajouterChiffre(3);
        });
        bouton4 = findViewById(R.id.bouton_quatre);
        bouton4.setOnClickListener(view -> {
            ajouterChiffre(4);
        });
        bouton5 = findViewById(R.id.bouton_cinq);
        bouton5.setOnClickListener(view -> {
            ajouterChiffre(5);
        });
        bouton6 = findViewById(R.id.bouton_six);
        bouton6.setOnClickListener(view -> {
            ajouterChiffre(6);
        });
        bouton7 = findViewById(R.id.bouton_sept);
        bouton7.setOnClickListener(view -> {
            ajouterChiffre(7);
        });
        bouton8 = findViewById(R.id.bouton_huit);
        bouton8.setOnClickListener(view -> {
            ajouterChiffre(8);
        });
        bouton9 = findViewById(R.id.bouton_neuf);
        bouton9.setOnClickListener(view -> {
            ajouterChiffre(9);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }

    private void GenererCalcul() {

        Random random = new Random();
        int operation = random.nextInt(4);
        if(operation == 3) {
            do {
                num1 = random.nextInt(10) + 1;
                num2 = random.nextInt(10) + 1;
            } while (num1 % num2 != 0);
        }
        else{
            num1 = random.nextInt(10) + 1;
            num2 = random.nextInt(10) + 1;
        }

        if(operation == 1 && num2 > num1) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        switch(operation) {
            case 0:
                resultat = num1 + num2;
                operateur = "+";
                break;
            case 1:
                resultat = num1 - num2;
                operateur = "-";
                break;
            case 2:
                resultat = num1 * num2;
                operateur = "*";
                break;
            case 3:
                resultat = num1 / num2;
                operateur = "/";
                break;


        }

        TextViewCalcul.setText(num1 + " " + operateur + " " + num2 + " = ");
    }

    private void ajouterChiffre(Integer chiffre) {
        if (Nombre <= 9999) {
            Nombre = 10 * Nombre + chiffre;
            TextViewReponse.setText(String.valueOf(Nombre));
        }
        else
        {
            Toast.makeText(this, getString(R.string.ERROR_NUMBER_TOO_HIGH), Toast.LENGTH_LONG).show();
        }

    }

    private void verifNombre() {
        TextViewScore = findViewById(R.id.TextViewScore);
        TextViewVie = findViewById(R.id.TextViewVie);

        if(Nombre==resultat) {
            Score++;
            TextViewScore.setText("Score: " + Score);
            TextViewValide.setText("Vrai");
            TextViewValide.setTextColor(Color.rgb(0,100,0));
            TextViewValide.setVisibility(View.VISIBLE);
        }
        else
        {
            Vie--;
            TextViewVie.setText("Vies: " + Vie);
            TextViewValide.setTextColor(Color.RED);
            TextViewValide.setText("Faux");
            TextViewValide.setVisibility(View.VISIBLE);
        }
        TextViewReponse.setText("0");
        Nombre=0;
        AffichageValide();
        GenererCalcul();
    }

    private void AffichageValide() {

        new Handler().postDelayed(new Runnable() {
            public void run() {
                TextViewValide.setVisibility(View.GONE);
            }
        }, 1000);
    }
}
