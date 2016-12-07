package com.example.ersan.arqsoftsmallbi;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class AsyncTaskMensagemPlano extends AsyncTask<String, String, String> {


    private Plano plano;

    @Override
    protected String doInBackground(String... params) {
        try {
            JSONObject jsonobj = new JSONObject();
//			jsonobj.put("id", cliente.getId());

            jsonobj.put("nome", plano.getNome());
            jsonobj.put("descricao", plano.getDescricao());
            jsonobj.put("valor", plano.getValor());


            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppostreq = new HttpPost("http://smallbi.whelastic.net/rest/smallbi/planos/create");

            StringEntity se = new StringEntity(jsonobj.toString());
            se.setContentType("application/json;charset=UTF-8");

            httppostreq.setEntity(se);

            HttpResponse httpresponse =
                    httpclient.execute(httppostreq);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }



    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
