package com.example.ersan.agenda.dal;

import android.support.annotation.NonNull;
import android.util.Log;

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

        public static void adiconaCompromisso(Compromisso c){
            listaCompromissos.add(c);
            Log.v("Registros", listaCompromissos.size() + "");
        }

        public static List<Compromisso> listarCompromissos(){
//            List<String> compromissosString = new ArrayList<String>();
//
//            for (Compromisso c: listaCompromissos){
//                compromissosString.add(c.getTipo());
//            }
//            // retorna apenas o tipo do compromisso
            return listaCompromissos;

        }


}
