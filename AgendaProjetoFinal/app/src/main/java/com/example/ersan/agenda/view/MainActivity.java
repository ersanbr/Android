package com.example.ersan.agenda.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.model.Compromisso;
import com.example.ersan.agenda.util.ArrayAdapterCompromissos;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrar, btnListar;
    ListView lstCompromissos;
    ArrayAdapterCompromissos arrayAdapterCompromissos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R .id.btnCadastrar);


        lstCompromissos = (ListView) findViewById(R.id.lstCompromissos);
        arrayAdapterCompromissos = new ArrayAdapterCompromissos(this, CompromissosDal.listarCompromissos());
        lstCompromissos.setAdapter(arrayAdapterCompromissos);




        //btnCadastrar = (Button) findViewById(R .id.btnListar);
    }

//    public void btnListaClick(View view) {
//        Intent listar = new Intent(MainActivity.this, ListaCompromissosActivity.class);
//        startActivity(listar);
//    }


    @Override
    protected void onResume() {

        super.onResume();
        arrayAdapterCompromissos.notifyDataSetChanged();
    }

    public void btnCadastrarClick(View view) {
        Intent cadastrar = new Intent(MainActivity.this, AgendaActivity.class);

        startActivity(cadastrar);

    }
}
