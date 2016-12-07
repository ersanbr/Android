package com.example.deynesonborba.listas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.deynesonborba.listas.model.Motocicleta;

import java.util.ArrayList;
import java.util.List;

public class Banco extends SQLiteOpenHelper{

    public static final String NOME_DO_BANCO = "MotoDb.db";
    public static final int VERSAO_DO_BANCO = 1;

    public static final String TIPO_TEXT = " TEXT";
    public static final String TIPO_INTEGER = " INTEGER";
    public static final String VIRGULA = ",";
    public static final String SQL_CRIAR_TABELAS = "CREATE TABLE IF NOT EXISTS " +
            Contrato.TabelaMoto.NOME_DA_TABELA + " (" +
                Contrato.TabelaMoto.NOME_DA_COLUNA_ID + TIPO_INTEGER + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                Contrato.TabelaMoto.NOME_DA_COLUNA_MARCA + TIPO_TEXT + VIRGULA +
                Contrato.TabelaMoto.NOME_DA_COLUNA_MODELO + TIPO_TEXT + VIRGULA +
                Contrato.TabelaMoto.NOME_DA_COLUNA_ANO + TIPO_INTEGER + ");";

    public static final String SQL_DELETAR_TABELAS = "DROP TABLE IF EXISTS " + Contrato.TabelaMoto.NOME_DA_TABELA;

    public Banco(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.v("Criar Banco", SQL_CRIAR_TABELAS);
        sqLiteDatabase.execSQL(SQL_CRIAR_TABELAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.v("Atualizar Banco: ", SQL_DELETAR_TABELAS);
        sqLiteDatabase.execSQL(SQL_DELETAR_TABELAS);
    }

    public long inserirMoto(Motocicleta m){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contrato.TabelaMoto.NOME_DA_COLUNA_MARCA, m.getMarca());
        contentValues.put(Contrato.TabelaMoto.NOME_DA_COLUNA_MODELO, m.getModelo());
        contentValues.put(Contrato.TabelaMoto.NOME_DA_COLUNA_ANO, m.getAno());

        return sqLiteDatabase.insert(Contrato.TabelaMoto.NOME_DA_TABELA, null, contentValues);
    }

    public List<Motocicleta> listMotos(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        List<Motocicleta> motocicletas = new ArrayList<Motocicleta>();

        String[] colunas = new String[]{
                Contrato.TabelaMoto.NOME_DA_COLUNA_ID,
                Contrato.TabelaMoto.NOME_DA_COLUNA_MARCA,
                Contrato.TabelaMoto.NOME_DA_COLUNA_MODELO,
                Contrato.TabelaMoto.NOME_DA_COLUNA_ANO
        };

        Cursor cursor = sqLiteDatabase.query(Contrato.TabelaMoto.NOME_DA_TABELA, colunas, null,null,null,null,null);
        cursor.moveToFirst();
        do {
            Motocicleta motocicleta = new Motocicleta();

            motocicleta.setId(cursor.getInt(0));
            motocicleta.setMarca(cursor.getString(1));
            motocicleta.setModelo(cursor.getString(2));
            motocicleta.setAno(cursor.getInt(3));

            motocicletas.add(motocicleta);
        }while (cursor.moveToNext());
        return motocicletas;
    }

    public long update(Motocicleta motocicleta){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contrato.TabelaMoto.NOME_DA_COLUNA_ID, motocicleta.getId());
        contentValues.put(Contrato.TabelaMoto.NOME_DA_COLUNA_MARCA, motocicleta.getMarca());
        contentValues.put(Contrato.TabelaMoto.NOME_DA_COLUNA_MODELO, motocicleta.getModelo());
        contentValues.put(Contrato.TabelaMoto.NOME_DA_COLUNA_ANO, motocicleta.getAno());

        String selection = Contrato.TabelaMoto.NOME_DA_COLUNA_ID + " LIKE ?";
        String[] selectionArgs = { Contrato.TabelaMoto.NOME_DA_COLUNA_ID};

        return sqLiteDatabase.update(Contrato.TabelaMoto.NOME_DA_TABELA, contentValues, null, null);
    }
}
