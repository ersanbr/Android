package com.example.ersan.agenda.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.Banco;
import com.example.ersan.agenda.model.Compromisso;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button btnCadastrar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R .id.btnCadastrar);
        btnCadastrar = (Button) findViewById(R .id.btnListar);

        //Banco banco = new Banco(getApplicationContext());

    }

    public void btnListaClick(View view) {
        Intent listar = new Intent(MainActivity.this, ListaCompromissosActivity.class);
        startActivity(listar);
    }

    public void btnCadastrarClick(View view) {
        Intent cadastrar = new Intent(MainActivity.this, AgendaActivity.class);

        startActivity(cadastrar);

    }

}
