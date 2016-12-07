package com.example.ersan.guess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JogarActivity extends AppCompatActivity {
    TextView txtStatus, txtNumeroSorteado;
    Button btnVerificar;
    EditText edtNumeroDigitado;
    String dificuldade;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar);

        txtStatus = (TextView) findViewById(R.id.txtStatus);
        txtNumeroSorteado = (TextView) findViewById(R.id.txtNumeroSorteado);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        edtNumeroDigitado = (EditText) findViewById(R.id.edtNumeroDigitado);


        dificuldade = getIntent().getStringExtra("Dificuldade");

        //facil = 10
        //medio = 100
        //dificil = 1000

        // escolher um numero aleatorio no nivel de dificuldade selecionado
        // testar com o numero escolhido

        Toast.makeText(JogarActivity.this, "Dificuldade: " + dificuldade, Toast.LENGTH_SHORT).show();

        if (dificuldade.equals("F")) {
            Random r = new Random();
            i = r.nextInt(11);

        }
        if (dificuldade.equals("M")) {
            Random r = new Random();
            i = r.nextInt(101);
        }
        if (dificuldade.equals("D")) {
            Random r = new Random();
            i = r.nextInt(1001);
        }
        //txtNumeroSorteado.setText(i + "");
    }

    public void btnVerificarClick(View view) {
        if (edtNumeroDigitado.getText().toString().equals("") || !edtNumeroDigitado.getText().toString().equals(null)) {
            int x = Integer.parseInt(edtNumeroDigitado.getText().toString());
            if (i == x) {
                Toast.makeText(JogarActivity.this, "Acertou !! ", Toast.LENGTH_LONG).show();
                txtNumeroSorteado.setText(i + "");
                txtStatus.setText("Acertou ");
            } else {
                if (i > x){
                    txtStatus.setText("Número Maior !");
                } else {
                    txtStatus.setText("Número Menor");
                }
            }
        } else {
            Toast.makeText(JogarActivity.this, "É necessário digitar um número! ", Toast.LENGTH_LONG).show();
        }
    }
}
