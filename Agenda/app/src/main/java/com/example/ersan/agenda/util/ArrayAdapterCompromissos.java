package com.example.ersan.agenda.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.model.Compromisso;
import com.example.ersan.agenda.view.AgendaActivity;

import java.util.List;

/**
 * Created by ersan on 17/11/16.
 */

public class ArrayAdapterCompromissos extends ArrayAdapter{

    Context context;
    List<Compromisso> compromissos;

    TextView txtTipo, txtHora, txtComplemento;

    public ArrayAdapterCompromissos(Context context, List<Compromisso> compromissos){
        //Necessário devido a extensão ArrayAdapter
        super(context, 0, compromissos);

        //Transfere a informação que veio no construtor para as variaveis globais para poderem ser usadas nos metodos seguintes
        this.context = context;
        this.compromissos = compromissos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //pega a posição do item e joga no objeto compromisso
        Compromisso compromisso = compromissos.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.agenda_layout, null);
        }

        txtTipo = (TextView) convertView.findViewById(R.id.txtTipo);
        txtHora = (TextView) convertView.findViewById(R.id.txtHora);
        txtComplemento = (TextView) convertView.findViewById(R.id.txtComplemento);

        txtTipo.setText(compromisso.getTipo());
        txtHora.setText(compromisso.getHora());
        txtComplemento.setText(compromisso.getComplemento());

        convertView.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Toast.makeText(context, txtTipo.getText(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, AgendaActivity.class);
                intent.putExtra("CompromissoTipo", txtTipo.getText());
                intent.putExtra("CompromissoComplmento",txtComplemento.getText());
                intent.putExtra("CompromissoHora", txtHora.getText());
                context.startActivity(intent);

            }
        });

        return convertView;

    }
}
