package com.example.ersan.agenda.model;

/**
 * Created by ersan on 10/11/16.
 */

public class Compromisso {

    private int id;
    private String Tipo;
    private String Complemento;
    private String hora;
    private String horaFim;
    private String data;

    public String getData() { return data; }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
}
