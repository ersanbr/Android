package com.example.deynesonborba.listas.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deynesonborba.listas.R;
import com.example.deynesonborba.listas.dao.MotocicletaDao;
import com.example.deynesonborba.util.ArrayAdapterMotos;

public class ListaActivity extends AppCompatActivity {

    ListView lstMotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


//
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(ListaActivity.this,
//                android.R.layout.simple_list_item_1, MotocicletaDao.getMotocicletas());
//
//        lstMotos.setAdapter(stringArrayAdapter);
//
//        lstMotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                TextView modeloMoto = (TextView) view.findViewById(android.R.id.text1);
//                Toast.makeText(ListaActivity.this, modeloMoto.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
        lstMotos = (ListView) findViewById(R.id.lstMotos);

        ArrayAdapterMotos arrayAdapterMotos = new ArrayAdapterMotos(this, MotocicletaDao.getMotocicletas(this));
        lstMotos.setAdapter(arrayAdapterMotos);
    }
}
