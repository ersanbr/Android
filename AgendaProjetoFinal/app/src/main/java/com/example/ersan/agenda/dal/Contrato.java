package com.example.ersan.agenda.dal;

import android.provider.BaseColumns;

/**
 * Created by ersan on 22/11/16.
 */

public final class Contrato {


    public static abstract  class TabelaCompromisso implements BaseColumns{
        public static final String NOME_DA_TABELA = "TableCompromisso";
        public static final String NOME_DA_COLUNA_ID = "CompromissoId";
        public static final String NOME_DA_COLUNA_TIPO = "CompromissoTipo";
        public static final String NOME_DA_COLUNA_DESCRICAO = "CompromissoDescricao";
        public static final String NOME_DA_COLUNA_HORA = "CompromissoHora";
        public static final String NOME_DA_COLUNA_HORA_FIM = "CompromissoHoraFim";
        public static final String NOME_DA_COLUNA_DATA = "CompromissoData";
    }
}
