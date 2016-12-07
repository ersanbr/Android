package com.example.ersan.arqsoftsmallbi;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.os.AsyncTask;

public class AsyncTaskMensagemCliente extends AsyncTask<String, String, String> {


    private Cliente cliente;

	@Override
	protected String doInBackground(String... params) {
		try {
			JSONObject jsonobj = new JSONObject();
//			jsonobj.put("id", cliente.getId());

            jsonobj.put("nome", cliente.getNome());
            jsonobj.put("rg", cliente.getRg());
            jsonobj.put("cpf", cliente.getCpf());
			jsonobj.put("telefone",cliente.getTelefone());


			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppostreq = new HttpPost("http://smallbi.whelastic.net/rest/smallbi/clientes/create");

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
