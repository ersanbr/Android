package com.example.ersan.agenda.dal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.ersan.agenda.model.Compromisso;
import com.example.ersan.agenda.view.AgendaActivity;
import com.example.ersan.agenda.view.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CompromissosDal {
    private static List<Compromisso> listaCompromissos = new ArrayList<Compromisso>();

    public static long adicionaCompromisso(Context context, Compromisso c){
        Banco banco = new Banco(context);
        long id = banco.inserirCompromisso(c);
        //Toast.makeText(context, "Id: " + id, Toast.LENGTH_LONG).show();
        Log.v("Registros", listaCompromissos.size() + "");
        return id;
    }

    public static List<Compromisso> listarCompromissos(Context context){
        Banco banco = new Banco(context);
        List<Compromisso> compromissos = new ArrayList<>();
        if (banco.retornarCompromissos()!=null){
            compromissos = banco.retornarCompromissos();
        }

        //GAMBIARRA
        List<Date> dates = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for(Compromisso c : compromissos){
            try{
                Date date = simpleDateFormat.parse(c.getData().toString());
                dates.add(date);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return compromissos;
    }

    public static void apagarCompromisso(Context context, String id){
        Banco banco = new Banco(context);
        banco.apagarCompromisso(id);
    }

    public static long editarCompromisso(Context context, Compromisso compromisso, List<Compromisso> compromissos){
        for(Compromisso c : compromissos){
            if(c.getId() == compromisso.getId()){
                Banco banco = new Banco(context);
                long id = banco.alterarCompromisso(c.getId(), compromisso);
                return 0;
            }
        }
        return 0;
    }
}
