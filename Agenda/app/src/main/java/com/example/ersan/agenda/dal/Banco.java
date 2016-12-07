package com.example.ersan.agenda.dal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ersan.agenda.model.Compromisso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersan on 22/11/16.
 */

public class Banco extends SQLiteOpenHelper {

    public static final String NOME_DO_BANCO = "AgendaDb.db";
    public static final int VERSAO_DO_BANCO = 1;

    public static final String TIPO_TEXTO = " TEXT";
    public static final String TIPO_INTEIRO = " INTEGER";
    public static final String TIPO_DATETIME = " ";
    public static final String VIRGULA = ",";

    public static final String SQL_CRIAR_TABELAS =
            /*"CREATE TABLE IF NOT EXISTS " + Contrato.TabelaTipo.NOME_DA_TABELA + " (" +
                    Contrato.TabelaTipo.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT " + VIRGULA +
                    Contrato.TabelaTipo.NOME_DA_COLUNA_DESCRICAO + TIPO_TEXTO + " ); " +
*/             "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaCompromisso.NOME_DA_TABELA + " (" +
                    Contrato.TabelaCompromisso.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT " + VIRGULA +
                    Contrato.TabelaCompromisso.NOME_DA_COLUNA_IDTIPO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA + TIPO_TEXTO  + " );";


    public static final String SQL_DELETAR_TABELAS =
            "DROP TABLE IF EXISTS " + Contrato.TabelaTipo.NOME_DA_TABELA + "; " +
            "DROP TABLE IF EXISTS " + Contrato.TabelaCompromisso.NOME_DA_TABELA + "; ";

    public Banco(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.v("Criar_Banco", SQL_CRIAR_TABELAS);
        sqLiteDatabase.execSQL(SQL_CRIAR_TABELAS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.v("Atualizar_Banco", SQL_DELETAR_TABELAS);
        sqLiteDatabase.execSQL(SQL_DELETAR_TABELAS);
    }

    public long inserirCompromisso(Compromisso c){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();

        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_IDTIPO,c.getTipo());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO,c.getComplemento());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA,c.getHora());
        Log.v("Valores", c.getTipo());
        Log.v("Valores", c.getComplemento());
        Log.v("Valores", c.getHora());

        return banco.insert(Contrato.TabelaCompromisso.NOME_DA_TABELA, null, registro);
    }

    public List<Compromisso> retornarCompromissos(){
        SQLiteDatabase banco = getWritableDatabase();
        List<Compromisso> compromissos = new ArrayList<Compromisso>();

        //Array de colunas que retornam do banco
        String[] colunas = new String[]{
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_ID,
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_IDTIPO,
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO,
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA

        };

        Cursor cursor = banco.query
                (Contrato.TabelaCompromisso.NOME_DA_TABELA,
                colunas,null,null,null,null,null);

        cursor.moveToFirst();
        //para não dar exeção caso a lista esteja vazia.
        if (cursor.getCount()>0){
            do {
                Compromisso com = new Compromisso();
                com.setId(cursor.getInt(0));
                com.setTipo(cursor.getString(1));
                com.setComplemento(cursor.getString(2));
                com.setHora(cursor.getString(3));
                compromissos.add(com);
            }while (cursor.moveToNext());
            return compromissos;
        }
        return null;

    }
}
