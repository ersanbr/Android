package com.example.ersan.arqsoftsmallbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastraClienteActivity extends AppCompatActivity {

    EditText edtNome, edtRG, edtCPF;
    Button btnGravar;
    AsyncTaskMensagemCliente a = new AsyncTaskMensagemCliente();
    Cliente c = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_cliente);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtRG = (EditText) findViewById(R.id.edtRG);
        edtCPF = (EditText) findViewById(R.id.edtCPF);

        btnGravar = (Button) findViewById(R.id.btnGravar);


        c.setNome(edtNome.getText().toString());
        c.setRg(edtCPF.getText().toString());
        c.setCpf(edtRG.getText().toString());
        a.setCliente(c);
    }
    public void clickGravar(View view) {
        a.execute();
    }
}
