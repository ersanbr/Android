package com.example.ersan.arqsoftsmallbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastraPlanoActivity extends AppCompatActivity {

    EditText edtNome, edtDescricao, edtValor;
    Button btnGravar;
    AsyncTaskMensagemPlano a = new AsyncTaskMensagemPlano();
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
    public void clickGravarPlano(View view) {
        p.setNome(edtNome.getText().toString());
        p.setDescricao(edtDescricao.getText().toString());
        p.setValor(edtValor.getText().toString());
        a.setPlano(p);

        a.execute();
        Toast.makeText(this, "Plano cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();

    }
}
