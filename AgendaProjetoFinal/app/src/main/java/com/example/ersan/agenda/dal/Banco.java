package com.example.ersan.agenda.dal;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ersan.agenda.model.Compromisso;

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

    public static final String SQL_CRIA_TABELA_TIPO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaTipo.NOME_DA_TABELA + " (" +
                    Contrato.TabelaTipo.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT " + VIRGULA +
                    Contrato.TabelaTipo.NOME_DA_COLUNA_DESCRICAO + TIPO_TEXTO + " );";

    public static final String SQL_CRIA_TABELA_COMPROMISSO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaCompromisso.NOME_DA_TABELA + " (" +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT " + VIRGULA +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_IDTIPO + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA + TIPO_TEXTO  + " );";


    public static final String SQL_DELETAR_TABELAS =
            "DROP TABLE IF EXISTS " + Contrato.TabelaTipo.NOME_DA_TABELA + "; " +
                    "DROP TABLE IF EXISTS " + Contrato.TabelaCompromisso.NOME_DA_TABELA + "; ";

    public static final String SQL_INSERE_REGISTROS_TIPO =
            "INSERT INTO " + Contrato.TabelaTipo.NOME_DA_TABELA + " (" + Contrato.TabelaTipo.NOME_DA_COLUNA_DESCRICAO + ") VALUES ( Reuniao );";

    public Banco(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.v("Criar_Banco", SQL_CRIA_TABELA_TIPO);
        sqLiteDatabase.execSQL(SQL_CRIA_TABELA_TIPO);

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

        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_IDTIPO,c.getTipo());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_DESCRICAO,c.getComplemento());
        registro.put(Contrato.TabelaCompromisso.NOME_DA_COLUNA_HORA,c.getHora());
        Log.v("Valores", c.getTipo());
        Log.v("Valores", c.getComplemento());
        Log.v("Valores", c.getHora());

        return banco.insert(Contrato.TabelaCompromisso.NOME_DA_TABELA, null, registro);
    }
}
