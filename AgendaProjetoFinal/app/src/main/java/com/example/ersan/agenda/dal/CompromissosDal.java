package com.example.ersan.agenda.dal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.ersan.agenda.model.Compromisso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ersan on 10/11/16.
 */

public class CompromissosDal {
    private static List<Compromisso> listaCompromissos = new ArrayList<Compromisso>();

        public static void adicionaCompromisso(Context context, Compromisso c){
//            listaCompromissos.add(c);
            Banco banco = new Banco(context);
            long id = banco.inserirCompromisso(c);
            Toast.makeText(context, "Id: " + id, Toast.LENGTH_LONG).show();
            Log.v("Registros", listaCompromissos.size() + "");
        }

        public static List<Compromisso> listarCompromissos(Context context){
            Banco banco = new Banco(context);
            if (banco.retornarCompromissos()!=null){
                return banco.retornarCompromissos();
            }

            return null;

        }


}
