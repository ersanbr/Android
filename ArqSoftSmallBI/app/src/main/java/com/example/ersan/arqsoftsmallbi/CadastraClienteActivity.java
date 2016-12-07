package com.example.ersan.arqsoftsmallbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastraClienteActivity extends AppCompatActivity {

    EditText edtNome, edtRG, edtCPF, edtTelefone;
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
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);

        btnGravar = (Button) findViewById(R.id.btnGravar);


    }
    public void clickGravarCliente(View view) {
        c.setNome(edtNome.getText().toString());
        c.setRg(edtRG.getText().toString());
        c.setCpf(edtCPF.getText().toString());
        c.setTelefone(edtTelefone.getText().toString());
        a.setCliente(c);

        a.execute();
        Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();

    }
}
