package com.example.ersan.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton rdoFacil, rdoMedio, rdoDificil;
    Button btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoFacil = (RadioButton) findViewById(R.id.rdoFacil);
        rdoMedio = (RadioButton) findViewById(R.id.rdoMedio);
        rdoDificil = (RadioButton) findViewById(R.id.rdoDificil);

        btnJogar = (Button) findViewById(R.id.btnJogar);
    }

    public void btnJogarClick(View view) {
        String dificuldade = "";

        if (rdoFacil.isChecked()) {
            dificuldade = "F";
        }

        if (rdoMedio.isChecked()) {
            dificuldade = "M";
        }
        if (rdoDificil.isChecked()) {
            dificuldade = "D";
        }

        // Primeiro paramentro da intenet é onde eu estou, depois e para eu vou
        Intent abrirTelaJogo = new Intent(MainActivity.this, JogarActivity.class);
        //tem que ficar entre a criação do intent e a inicialização da activity, uma linha para cada informação a ser passada
        abrirTelaJogo.putExtra("Dificuldade",dificuldade);
        // Inicia a activity
        startActivity(abrirTelaJogo);


    }
}
