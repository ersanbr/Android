package com.example.deynesonborba.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deynesonborba.listas.R;
import com.example.deynesonborba.listas.model.Motocicleta;

import java.util.List;

public class ArrayAdapterMotos extends ArrayAdapter{

    Context context;
    List<Motocicleta> motocicletas;
    TextView txtMarca, txtModelo, txtAno;

    public ArrayAdapterMotos(Context context, List<Motocicleta> motocicletas){
        super(context, 0, motocicletas);
        this.context = context;
        this.motocicletas = motocicletas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Motocicleta m = motocicletas.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_deyneson, null);
        }

        txtMarca = (TextView) convertView.findViewById(R.id.txtMarca);
        txtModelo = (TextView) convertView.findViewById(R.id.txtModelo);
        txtAno = (TextView) convertView.findViewById(R.id.txtAno);

        txtMarca.setText(m.getMarca());
        txtModelo.setText(m.getModelo());
        txtAno.setText(m.getAno() + "");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, txtModelo.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
