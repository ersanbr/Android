package com.example.deynesonborba.listas.dao;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.deynesonborba.listas.model.Motocicleta;

import java.util.ArrayList;
import java.util.List;

public class MotocicletaDao {

    private static List<Motocicleta> motocicletas = new ArrayList<Motocicleta>();

    public static Long addMotocicleta(Motocicleta moto, Context context){
        //motocicletas.add(moto);
        Banco banco = new Banco(context);
        long id = banco.inserirMoto(moto);
        Toast.makeText(context, "ID: " + id, Toast.LENGTH_SHORT).show();
        Log.v("Registros", motocicletas.size() + "");
        return id;
    }

    public static List<Motocicleta> getMotocicletas(Context context){
        Banco banco = new Banco(context);
        return banco.listMotos();
    }
}
