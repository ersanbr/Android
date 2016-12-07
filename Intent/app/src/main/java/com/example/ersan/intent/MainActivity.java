package com.example.ersan.intent;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    EditText edtUm,  edtDois, edtTres;
    Button btnEmail, btnMapa, btnAlarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUm = (EditText) findViewById(R.id.edtUm);
        edtDois = (EditText) findViewById(R.id.edtDois);
        edtTres = (EditText) findViewById(R.id.edtTres);

        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnMapa = (Button) findViewById(R.id.btnMapa);
        btnAlarme = (Button) findViewById(R.id.btnAlarme);
    }

    public void btnEmailClick(View view) {
        String[] email = new String[]{
                edtUm.getText().toString()
        };
        Intent enviarEmail = new Intent(Intent.ACTION_SENDTO);
        enviarEmail.setType("text/plain");
        enviarEmail.setData(Uri.parse("mailto:"));

        enviarEmail.putExtra(Intent.EXTRA_EMAIL, email);
        enviarEmail.putExtra(Intent.EXTRA_SUBJECT, edtDois.getText().toString());
        enviarEmail.putExtra(Intent.EXTRA_TEXT, edtTres.getText().toString());

        startActivity(Intent.createChooser(enviarEmail, "Selecione um aplicativo"));



    }

    public void btnMapaClick(View view) {

        Uri localizacao = Uri.parse("geo:" + edtUm.getText().toString() + "," + edtDois.getText().toString());
        Intent abreMapa = new Intent(Intent.ACTION_VIEW);
        abreMapa.setData(localizacao);
        abreMapa.setPackage("com.google.android.apps.maps");
        startActivity(abreMapa);

    }

    public void btnAlarmeClick(View view) {
        Intent chamaAlarme = new Intent(AlarmClock.ACTION_SET_ALARM);
        chamaAlarme.putExtra(AlarmClock.EXTRA_MESSAGE, edtUm.getText().toString());
        chamaAlarme.putExtra(AlarmClock.EXTRA_HOUR, parseInt(edtDois.getText().toString()));
        chamaAlarme.putExtra(AlarmClock.EXTRA_MINUTES, parseInt(edtTres.getText().toString()));
        startActivity(chamaAlarme);
    }
}
