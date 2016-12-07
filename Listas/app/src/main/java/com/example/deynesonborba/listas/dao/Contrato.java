package com.example.deynesonborba.listas.dao;

import android.provider.BaseColumns;

public final class Contrato {

    public static abstract class TabelaMoto implements BaseColumns{
        public static final String NOME_DA_TABELA = "TabelaMoto";
        public static  final String NOME_DA_COLUNA_ID = "MotoId";
        public static  final String NOME_DA_COLUNA_MODELO = "MotoModelo";
        public static  final String NOME_DA_COLUNA_MARCA = "MotoMarca";
        public static  final String NOME_DA_COLUNA_ANO = "MotoAno";
    }
}
