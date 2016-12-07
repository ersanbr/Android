package com.example.ersan.jogovelha;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class PrincipalActivity extends AppCompatActivity {

    Button btnA1,btnA2,btnA3,btnB1,btnB2,btnB3,btnC1,btnC2,btnC3,btnJogador1,btnJogador2,btnNovoJogo,btnLimpa;
    TextView txtResultJ1,txtResultJ2;
    int jogada,resultadoJogador1,resultadoJogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnA1 =(Button) findViewById(R.id.btnA1);
        btnA2 =(Button) findViewById(R.id.btnA2);
        btnA3 =(Button) findViewById(R.id.btnA3);

        btnB1 =(Button) findViewById(R.id.btnB1);
        btnB2 =(Button) findViewById(R.id.btnB2);
        btnB3 =(Button) findViewById(R.id.btnB3);

        btnC1 =(Button) findViewById(R.id.btnC1);
        btnC2 =(Button) findViewById(R.id.btnC2);
        btnC3 =(Button) findViewById(R.id.btnC3);

        btnJogador1 =(Button) findViewById(R.id.btnJogador1);
        btnJogador2 =(Button) findViewById(R.id.btnJogador2);

        btnNovoJogo =(Button) findViewById(R.id.btnNovoJogo);
        btnLimpa =(Button) findViewById(R.id.btnLimpa);

        txtResultJ1 = (TextView) findViewById(R.id.txtResultJ1);
        txtResultJ2 = (TextView) findViewById(R.id.txtResultJ2);
    }


    public void realizaJogada(View view){
        Button b = (Button)view;
        int resutadoJogada = jogada % 2;


        if (b.isClickable()){

            if (resutadoJogada == 0){
                b.setText("0");
                b.setClickable(false);
                jogada ++;
                if (jogada > 4){
                    verificaGanhador();
                }
                btnJogador1.setTextColor(Color.parseColor("#000000"));
                btnJogador2.setTextColor(Color.parseColor("#ffffff"));

            } else {
                b.setText("X");
                b.setClickable(false);
                jogada ++;
                if (jogada > 4){
                    verificaGanhador();
                }
                btnJogador1.setTextColor(Color.parseColor("#ffffff"));
                btnJogador2.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

    private void verificaGanhador() {


        if ((btnA1.getText().toString() == "0" && btnA2.getText().toString() == "0" && btnA3.getText().toString() == "0") ||
                (btnB1.getText().toString() == "0" && btnB2.getText().toString() == "0" && btnB3.getText().toString() == "0") ||
                (btnC1.getText().toString() == "0" && btnC2.getText().toString() == "0" && btnC3.getText().toString() == "0")){
            resultadoJogador1 ++;
            Toast.makeText(PrincipalActivity.this,"Jogador 1 ganhou!",Toast.LENGTH_LONG).show();
            txtResultJ1.setText(resultadoJogador1 + "");
            travaBotoes();
        }
        if ((btnA1.getText().toString() == "0" && btnB1.getText().toString() == "0" && btnC1.getText().toString() == "0") ||
                (btnA2.getText().toString() == "0" && btnB2.getText().toString() == "0" && btnC2.getText().toString() == "0") ||
                (btnA3.getText().toString() == "0" && btnB3.getText().toString() == "0" && btnC3.getText().toString() == "0")){
            resultadoJogador1 ++;
            Toast.makeText(PrincipalActivity.this,"Jogador 1 ganhou!",Toast.LENGTH_LONG).show();
            txtResultJ1.setText(resultadoJogador1 + "");
            travaBotoes();
        }
        if ((btnA1.getText().toString() == "0" && btnB2.getText().toString() == "0" && btnC3.getText().toString() == "0") ||
                (btnA3.getText().toString() == "0" && btnB2.getText().toString() == "0" && btnC1.getText().toString() == "0")){
            resultadoJogador1 ++;
            Toast.makeText(PrincipalActivity.this,"Jogador 1 ganhou!",Toast.LENGTH_LONG).show();
            txtResultJ1.setText(resultadoJogador1 + "");
            travaBotoes();
        }

        if ((btnA1.getText().toString() == "X" && btnA2.getText().toString() == "X" && btnA3.getText().toString() == "X") ||
                (btnB1.getText().toString() == "X" && btnB2.getText().toString() == "X" && btnB3.getText().toString() == "X") ||
                (btnC1.getText().toString() == "X" && btnC2.getText().toString() == "X" && btnC3.getText().toString() == "X")){
            resultadoJogador2 ++;
            Toast.makeText(PrincipalActivity.this,"Jogador 2 ganhou!",Toast.LENGTH_LONG).show();
            txtResultJ2.setText(resultadoJogador2 + "");
            travaBotoes();
        }
        if ((btnA1.getText().toString() == "X" && btnB1.getText().toString() == "X" && btnC1.getText().toString() == "X") ||
                (btnA2.getText().toString() == "X" && btnB2.getText().toString() == "X" && btnC2.getText().toString() == "X") ||
                (btnA3.getText().toString() == "X" && btnB3.getText().toString() == "X" && btnC3.getText().toString() == "X")){
            resultadoJogador2 ++;
            Toast.makeText(PrincipalActivity.this,"Jogador 2 ganhou!",Toast.LENGTH_LONG).show();
            txtResultJ2.setText(resultadoJogador2 + "");
            travaBotoes();
        }
        if ((btnA1.getText().toString() == "X" && btnB2.getText().toString() == "X" && btnC3.getText().toString() == "X") ||
                (btnA3.getText().toString() == "X" && btnB2.getText().toString() == "X" && btnC1.getText().toString() == "X")){
            resultadoJogador2 ++;
            Toast.makeText(PrincipalActivity.this,"Jogador 2 ganhou!",Toast.LENGTH_LONG).show();
            txtResultJ2.setText(resultadoJogador2 + "");
            travaBotoes();
        }


    }

    private void travaBotoes() {
        btnA1.setClickable(false);
        btnA2.setClickable(false);
        btnA3.setClickable(false);

        btnB1.setClickable(false);
        btnB2.setClickable(false);
        btnB3.setClickable(false);

        btnC1.setClickable(false);
        btnC2.setClickable(false);
        btnC3.setClickable(false);
    }

    private void liberaBotoes() {
        btnA1.setClickable(true);
        btnA1.setText("");
        btnA2.setClickable(true);
        btnA2.setText("");
        btnA3.setClickable(true);
        btnA3.setText("");

        btnB1.setClickable(true);
        btnB1.setText("");
        btnB2.setClickable(true);
        btnB2.setText("");
        btnB3.setClickable(true);
        btnB3.setText("");

        btnC1.setClickable(true);
        btnC1.setText("");
        btnC2.setClickable(true);
        btnC2.setText("");
        btnC3.setClickable(true);
        btnC3.setText("");
    }


    public void limpaTela(View view) {

        //cira e edita o dialog,
        AlertDialog.Builder builder = new AlertDialog.Builder(PrincipalActivity.this);
        builder.setTitle(" Jogo da Velha");
        builder.setMessage("Deseja reiniciar?");

        //cria o clique do botão do dialog
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                liberaBotoes();
                txtResultJ1.setText("");
                resultadoJogador1 = 0;
                txtResultJ2.setText("");
                resultadoJogador2 = 0;
                btnJogador1.setTextColor(Color.parseColor("#000000"));
                btnJogador2.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //cria o dialog
        AlertDialog alertDialog = builder.create();

        //não aceita clique fora das opções sim ou não
        alertDialog.setCanceledOnTouchOutside(false);

        //exibe na tela o dialog
        alertDialog.show();



    }

    public void novoJogo(View view) {
        liberaBotoes();
        jogada = 0;
        btnJogador1.setTextColor(Color.parseColor("#000000"));
        btnJogador2.setTextColor(Color.parseColor("#ffffff"));

    }
}
