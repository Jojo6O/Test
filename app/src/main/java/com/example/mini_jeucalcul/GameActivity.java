package com.example.mini_jeucalcul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GameActivity extends AppCompatActivity {
    private TextView TextViewCalcul;
    private Button boutonValider;
    int resultat = 0;
    int num1, num2;
    String operateur = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextViewCalcul = findViewById(R.id.TextViewCalcul);
        boutonValider = findViewById(R.id.boutonValider);
        boutonValider.setOnClickListener(view -> {
            GenererCalcul();
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
}
