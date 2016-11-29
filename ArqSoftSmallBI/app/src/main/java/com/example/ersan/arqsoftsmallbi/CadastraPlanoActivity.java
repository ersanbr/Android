package com.example.ersan.arqsoftsmallbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CadastraPlanoActivity extends AppCompatActivity {

    EditText edtNome, edtDescricao, edtValor;
    Button btnGravar;
    AsyncTaskMensagemCliente a = new AsyncTaskMensagemCliente();
    Plano p = new Plano();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_plano);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtValor = (EditText) findViewById(R.id.edtValor);
        btnGravar = (Button) findViewById(R.id.btnGravar);


    }
}
