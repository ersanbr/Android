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

public class Banco extends SQLiteOpenHelper {

    public static final String NOME_DO_BANCO = "AgendaDb.db";
    public static final int VERSAO_DO_BANCO = 1;

    public static final String TIPO_TEXTO = " TEXT";
    public static final String TIPO_INTEIRO = " INTEGER";
    public static final String TIPO_DATETIME = " ";
    public static final String VIRGULA = ",";

        public static final String SQL_CRIA_TABELA_COMPROMISSO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaCompromisso.NOME_DA_TABELA + " (" +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT " + VIRGULA +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_TIPO + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_DATA + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA + TIPO_TEXTO  + " );";



    public static final String SQL_DELETAR_TABELAS =
            "DROP TABLE IF EXISTS " + Contrato.TabelaCompromisso.NOME_DA_TABELA + "; ";


    public Banco(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.v("Criar_Banco", SQL_CRIA_TABELA_COMPROMISSO);
        sqLiteDatabase.execSQL(SQL_CRIA_TABELA_COMPROMISSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.v("Atualizar_Banco", SQL_DELETAR_TABELAS);
        sqLiteDatabase.execSQL(SQL_DELETAR_TABELAS);
    }

    public long inserirCompromisso(Compromisso c){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();

        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_TIPO,c.getTipo());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO,c.getComplemento());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA,c.getHora());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_DATA,c.getData());
//        Log.v("Valores", c.getTipo());
//        Log.v("Valores", c.getComplemento());
//        Log.v("Valores", c.getHora());
//        Log.v("Valores",c.getData());

        return banco.insert(Contrato.TabelaCompromisso.NOME_DA_TABELA, null, registro);
    }

    public long alterarCompromisso(Integer idCompromissoBd, Compromisso newCom){

        SQLiteDatabase banco = getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO, newCom.getComplemento().toString());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA, newCom.getHora().toString());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_TIPO, newCom.getTipo().toString());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_DATA, newCom.getData().toString());

        String selection = Contrato.TabelaCompromisso.NOME_DA_COLUNA_ID + "=" + String.valueOf(idCompromissoBd);

        return banco.update(
            Contrato.TabelaCompromisso.NOME_DA_TABELA,
            registro,
            selection,
            null
        );
    }

    public List<Compromisso> retornarCompromissos(){
        SQLiteDatabase banco = getWritableDatabase();
        List<Compromisso> compromissos = new ArrayList<Compromisso>();

        //Array de colunas que retornam do banco
        String[] colunas = new String[]{
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_ID,
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_TIPO,
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO,
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA,
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_DATA
        };

        /*
            String sortOrder = FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
         */

        String sortOrder = Contrato.TabelaCompromisso.NOME_DA_COLUNA_DATA + "," +
                Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA + " ASC";
        Log.v("SQL", sortOrder.toString());

        Cursor cursor = banco.query(
            Contrato.TabelaCompromisso.NOME_DA_TABELA,
            colunas,
            null,
            null,
            null,
            null,
            sortOrder
        );


        cursor.moveToFirst();
        //para não dar exeção caso a lista esteja vazia.
        if (cursor.getCount()>0){
            do {
                Compromisso com = new Compromisso();
                com.setId(cursor.getInt(0));
                com.setTipo(cursor.getString(1));
                com.setComplemento(cursor.getString(2));
                com.setHora(cursor.getString(3));
                com.setData(cursor.getString(4));
                compromissos.add(com);
//                Log.v("Compromisso: ", com.getComplemento() + " Id: " + String.valueOf(com.getId()) +
//                " Data: " + com.getData());
            }while (cursor.moveToNext());
            return compromissos;
        }
        return null;
    }

    public void apagarCompromisso(String id){
        SQLiteDatabase banco = getWritableDatabase();
        String selection = Contrato.TabelaCompromisso.NOME_DA_COLUNA_ID + " LIKE ?";
        String[] selectionArgs = {id};

        banco.delete(Contrato.TabelaCompromisso.NOME_DA_TABELA, selection, selectionArgs);
    }

//    public void getObjectById(String id){
//        SQLiteDatabase db = getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + Contrato.TabelaCompromisso.NOME_DA_TABELA, null);
//    }
}
