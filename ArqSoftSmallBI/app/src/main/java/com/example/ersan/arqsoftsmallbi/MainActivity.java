package com.example.ersan.arqsoftsmallbi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnCadastraCliente,btnCadastraPlano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastraCliente = (Button) findViewById(R.id.btnCadastrarCliente);
        btnCadastraPlano = (Button) findViewById(R.id.btnCadastrarPlano);



    }


    public void btnCadastrarClienteClick(View view) {
        Intent cadastrarCliente = new Intent(MainActivity.this, CadastraClienteActivity.class);
        startActivity(cadastrarCliente);
    }

    public void btnCadastrarPlanoClick(View view) {
        Intent cadastrarPlano = new Intent(MainActivity.this, CadastraPlanoActivity.class);
        startActivity(cadastrarPlano);

    }
}
