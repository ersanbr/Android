package com.example.ersan.forca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avell G1511 FIRE on 20/10/2016.
 */

public class ListaDePalavras {

    private static List<String> listaDePalavras = new ArrayList<String>(){
        {
            add("parecer");
            add("falar");
            add("ficar");
            add("ouvir");
            add("achar");
            add("deixar");
            add("sair");
            add("chegar");
            add("passar");
            add("pedir");
            add("ler");
            add("acabar");
            add("ser");
            add("dizer");
            add("ter");
            add("ir");
            add("estar");
            add("fazer");
            add("haver");
            add("poder");
            add("ver");
            add("dar");
            add("saber");
            add("vir");
            add("querer");
            add("coisa");
            add("casa");
            add("tempo");
            add("vez");
            add("olho");
            add("dia");
            add("homem");
            add("moço");
            add("senhor");
            add("ano");
            add("mão");
            add("palavra");
            add("filho");
            add("noite");
            add("carta");
            add("amigo");
            add("bem");
            add("rua");
            add("vida");
            add("hora");
            add("coração");
            add("pai");
            add("pessoa");
            add("mulher");
            add("amor");
            add("verdade");
            add("ideia");
            add("mãe");
            add("marido");
            add("espírito");
            add("viúvo");
            add("alma");
            add("fim");
            add("cabeça");
            add("nome");
            add("porta");
            add("pé");
            add("razão");
            add("parte");
            add("modo");
            add("bom");
            add("grande");
            add("melhor");
            add("próprio");
            add("velho");
            add("certo");
            add("último");
            add("longo");
            add("novo");
            add("único");
            add("antigo");
            add("belo");
            add("seguinte");
            add("preciso");
            add("meio");
            add("natural");
            add("maior");
            add("triste");
            add("bonito");
            add("só");
            add("simples");
            add("mau");
            add("verdadeiro");
            add("alegre");
            add("político");
            add("alto");
            add("público");
            add("grave");
            add("vivo");
            add("cheio");
            add("feliz");
            add("possível");
            add("raro");
            add("claro");
            add("necessário");
            add("pequeno");
            add("igual");
            add("fino");
            add("impossível");
            add("pobre");
        }
    };

    public static char[] retornarPalavra(int posicao){
        if(posicao >= 0 && posicao <= 104){
            return listaDePalavras.get(posicao).toCharArray();
        }
        return null;
    }

}
