package com.example.ersan.provaersanholstein;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnConverter,btnLimpar;
    TextView txtDolar,txtEuro,txtPeso;
    EditText edtValorAConverter;
    ImageView imgCifrao;
    Float valorReal,valorConvertido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnConverter = (Button) findViewById(R.id.btnConverter);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        txtDolar = (TextView) findViewById(R.id.txtDolar);
        txtEuro = (TextView) findViewById(R.id.txtEuro);
        txtPeso = (TextView) findViewById(R.id.txtPeso);

        edtValorAConverter = (EditText) findViewById(R.id.edtValorAConverter);

        imgCifrao = (ImageView) findViewById(R.id.imgCifrao);

    }

    public void btnConverter(View view) {
        imgCifrao.setImageResource(R.drawable.imagem2);
        valorReal = Float.parseFloat(edtValorAConverter.getText().toString());
        txtDolar.setText((valorReal * 3.15) + "");
        txtEuro.setText((valorReal * 3.43) + "");
        txtPeso.setText((valorReal * 0.2) + "");


    }

    public void btnLimpar(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(" Conversor de Moedas");
        builder.setMessage("Deseja Limpar os dados?");

        //cria o clique do botão do dialog
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                imgCifrao.setImageResource(R.drawable.imagem1);
                txtDolar.setText("");
                txtEuro.setText("");
                txtPeso.setText("");
                edtValorAConverter.setText("");
                valorConvertido = null;
                valorReal = null;
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
}
