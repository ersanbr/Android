package com.example.ersan.forca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import java.util.Random;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtLetras,txtPalavra,txtMostraPalavra;
    EditText edtLetra;
    Button btnVerificar;
    ImageView imgForca;
    int erro = 0;
    char[] vetor;
    char[] letrasCorretas;
    String palavra;
    String tracos;
    ArrayList<String> letrasUtilizadas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnVerificar =(Button) findViewById(R.id.btnVerificar);

        txtLetras = (TextView) findViewById(R.id.txtLetras);
        txtMostraPalavra =  (TextView) findViewById(R.id.txtMostraPalavra);
        txtPalavra = (TextView) findViewById(R.id.txtPalavra);

        edtLetra = (EditText) findViewById(R.id.edtLetra);

        imgForca = (ImageView) findViewById(R.id.imgForca);

        Random r = new Random();

        vetor = ListaDePalavras.retornarPalavra(r.nextInt(105));
        letrasCorretas = new char[vetor.length];

        palavra = String.valueOf(vetor).toUpperCase();

        tracos = "";

        for (int i = 0; i < vetor.length; i++) {
            letrasCorretas[i] = "_".charAt(0);
        }

        imprimirVetor();


        txtPalavra.setText(tracos);

        txtMostraPalavra.setText(palavra);


    }

    private void imprimirVetor() {
        txtPalavra.setText(palavra + "\n");
        for (int i = 0; i < letrasCorretas.length; i++) {
            txtPalavra.setText(txtPalavra.getText() +
                    String.valueOf(letrasCorretas[i]) + " ");
        }

        txtLetras.setText("");

        for (String letraJaUtilizada : letrasUtilizadas){
            txtLetras.setText(letraJaUtilizada+ " - " + txtLetras.getText() );
        }
    }

    public void verificar(View view) {
        int acertos = 0;
        String letraSelecionada = "";

        if (!edtLetra.getText().toString().equals(null) && edtLetra.getText().length()>0 ){
            for (int i = 0;  i < vetor.length; i ++) {
                String letra = String.valueOf(vetor[i]);
                letraSelecionada = edtLetra.getText().toString();

                if (letra.equals(letraSelecionada)){
                    letrasCorretas[i] = letra.charAt(0);
                    acertos ++;
                }
            }
            txtLetras.setText(txtLetras.getText() + letraSelecionada + " ");
            edtLetra.setText("");
        } else {
            Toast.makeText(PrincipalActivity.this, "Preencha uma letra!", Toast.LENGTH_LONG).show();
        }

        if (acertos == 0){
            erro ++;
        } else {
            Toast.makeText(PrincipalActivity.this, "Encontrada " + acertos + " letra(s).", Toast.LENGTH_LONG).show();
            if (String.valueOf(vetor).equals(String.valueOf(letrasCorretas))){
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }
        }



        switch (erro){
            case 1:
                imgForca.setImageResource(R.drawable.image1);
                break;
            case 2:
                imgForca.setImageResource(R.drawable.image2);
                break;
            case 3:
                imgForca.setImageResource(R.drawable.image3);
                break;
            case 4:
                imgForca.setImageResource(R.drawable.image4);
                break;
            case 5:
                imgForca.setImageResource(R.drawable.image5);
                break;
            case 6:
                imgForca.setImageResource(R.drawable.image6);
                break;
            case 7:
                imgForca.setImageResource(R.drawable.image7);
                break;
            case 8:
                imgForca.setImageResource(R.drawable.image8);
                break;
            case 9:
                imgForca.setImageResource(R.drawable.image9);
                break;
            default:
                break;
        }
    }
}
