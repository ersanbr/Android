package com.example.deynesonborba.listas.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.deynesonborba.listas.R;
import com.example.deynesonborba.listas.dao.Banco;
import com.example.deynesonborba.listas.model.Motocicleta;

public class MainActivity extends AppCompatActivity {

    Button btnCadastro, btnListagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnListagem = (Button) findViewById(R.id.btnListagem);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
    }

    public void btnCadastroClick(View view) {
        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
    }

    public void btnListagemClick(View view) {
        Intent intent = new Intent(MainActivity.this, ListaActivity.class);
        startActivity(intent);
    }
}
