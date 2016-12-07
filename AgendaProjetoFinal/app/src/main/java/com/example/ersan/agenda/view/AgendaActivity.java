package com.example.ersan.agenda.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.NotificationCompat;
import android.app.PendingIntent;
import android.app.NotificationManager;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.model.Compromisso;
import com.example.ersan.agenda.notification.Notification;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AgendaActivity extends AppCompatActivity {

    EditText edtCompromissoComplmento, edtCompromissoHora, edtCompromissoHoraFim, edtCompromissoData;
    Button btnGravar, btnEditar, btnEmail, btnApagar;
    Spinner spnTipoCompromisso;
    String idCompromisso;
    boolean edicao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        edtCompromissoData = (EditText) findViewById(R.id.edtCompromissoData);
        edtCompromissoComplmento = (EditText) findViewById(R.id.edtCompromissoComplmento);
        edtCompromissoHora = (EditText) findViewById(R.id.edtCompromissoHora);
        edtCompromissoHoraFim = (EditText) findViewById(R.id.edtCompromissoHoraFim);
        spnTipoCompromisso = (Spinner) findViewById(R.id.spnTipoCompromisso);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipoCompromissos_array,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnTipoCompromisso.setAdapter(adapter);

        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnApagar = (Button) findViewById(R.id.btnApagar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEmail = (Button) findViewById(R.id.btnEmail);

        String data = getIntent().getStringExtra("CompromissoData");
        idCompromisso = getIntent().getStringExtra("CompromissoId");
        String tipo = getIntent().getStringExtra("CompromissoTipo");
        String complemento = getIntent().getStringExtra("CompromissoComplmento");
        String hora = getIntent().getStringExtra("CompromissoHora");
        String horaFim = getIntent().getStringExtra("CompromissoHoraFim");

        if (tipo != null && complemento != null && hora != null && data != null){
            edtCompromissoData.setText(data);
            edtCompromissoData.setEnabled(false);
            spnTipoCompromisso.setSelection(adapter.getPosition(tipo));
            spnTipoCompromisso.setEnabled(false);
            edtCompromissoHora.setText(hora);
            edtCompromissoHora.setEnabled(false);
            edtCompromissoHoraFim.setText(horaFim);
            edtCompromissoHoraFim.setEnabled(false);
            edtCompromissoComplmento.setText(complemento);
            edtCompromissoComplmento.setEnabled(false);
            btnEditar.setVisibility(View.VISIBLE);
            btnApagar.setVisibility(View.VISIBLE);
        }
    }

    public void btnGravarClick(View view) {
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!spnTipoCompromisso.getSelectedItem().toString().equals("Escolha um tipo")){

                    if(!edtCompromissoData.getText().toString().equals("") &&
                            !edtCompromissoHora.getText().toString().equals("") &&
                            !edtCompromissoComplmento.getText().toString().equals("")) {

                        boolean horaValida = validarHora(edtCompromissoHora.getText().toString());
                        boolean dataValida =  validarData(edtCompromissoData.getText().toString());
                        Compromisso com = new Compromisso();
                        if(horaValida == true) {
                            if(dataValida == true) {
                                if (edicao == false) {
                                    DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    String inputDateStr = edtCompromissoData.getText().toString();
                                    Date date = new Date();
                                    try {
                                        date = inputFormat.parse(inputDateStr);
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    String outputDateStr = outputFormat.format(date);
                                    com.setData(outputDateStr);
                                    com.setTipo(spnTipoCompromisso.getSelectedItem().toString());
                                    com.setComplemento(edtCompromissoComplmento.getText().toString());
                                    com.setHora(edtCompromissoHora.getText().toString());
                                    com.setHoraFim(edtCompromissoHoraFim.getText().toString());
                                    CompromissosDal.adicionaCompromisso(AgendaActivity.this, com);
                                } else {
                                    DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    String inputDateStr = edtCompromissoData.getText().toString();
                                    Date date = null;
                                    try {
                                        date = inputFormat.parse(inputDateStr);
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    String outputDateStr = outputFormat.format(date);
                                    com.setData(outputDateStr);
                                    com.setTipo(spnTipoCompromisso.getSelectedItem().toString());
                                    com.setComplemento(edtCompromissoComplmento.getText().toString());
                                    com.setHora(edtCompromissoHora.getText().toString());
                                    com.setHoraFim(edtCompromissoHoraFim.getText().toString());
                                    com.setId(Integer.parseInt(idCompromisso));

                                    List<Compromisso> compromissos = CompromissosDal.listarCompromissos(AgendaActivity.this);
                                    CompromissosDal.editarCompromisso(AgendaActivity.this, com, compromissos);
                                }

                                Notification notification = new Notification();
                                notification.createNotification(AgendaActivity.this, com);

                                finish();
                            }else {
                                Toast.makeText(AgendaActivity.this, "Data inválida", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(AgendaActivity.this, "Hora inválida", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(AgendaActivity.this, "Favor preencher todos os campos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AgendaActivity.this, "Favor preencher o tipo de agendamento", Toast.LENGTH_LONG).show();
                    spnTipoCompromisso.setBackgroundColor(Color.parseColor("#479cf4"));
                }
            }
        },100);

    }

    private boolean validarHora(String hora){
        String[] valores = hora.split(":");
        boolean strValida = true, horaValida = true, minValido = true;
        if(valores.length != 2){
            strValida = false;
        }else{
            int h = Integer.parseInt(valores[0]);
            if(h > 24 || h < 0){
                horaValida = false;
            }
            int m = Integer.parseInt(valores[1]);
            if(m > 59 || m < 0){
                minValido = false;
            }
        }
        if(strValida == true && horaValida == true && minValido == true){
            return true;
        }else{
            return false;
        }
    }

    private boolean validarData(String data){
        if(data.length() != 10){
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        try {
            Date d = simpleDateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void btnApagarClick(View view) {
        CompromissosDal.apagarCompromisso(this, idCompromisso);
        finish();
    }

    public void btnEmailClick(View view) {
        String[] emails = new String[]{
                "deynesonborba@gmail.com"
        };

        String assunto = edtCompromissoComplmento.getText().toString();

        String conteudo = "Compromisso: " + edtCompromissoComplmento.getText().toString() +
                "\n Tipo: " + spnTipoCompromisso.getSelectedItem().toString() +
                "\n Hora: " + edtCompromissoHora.getText().toString() +
                "\n Hora Fim: " + edtCompromissoHoraFim.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, emails);
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
        intent.putExtra(Intent.EXTRA_TEXT, conteudo);
        startActivity(Intent.createChooser(intent, "Selecione o aplicativo"));
    }

    public void btnEditarClick(View view) {
        spnTipoCompromisso.setEnabled(true);
        edtCompromissoHora.setEnabled(true);
        edtCompromissoHoraFim.setEnabled(true);
        edtCompromissoComplmento.setEnabled(true);
        edtCompromissoData.setEnabled(true);
        edicao = true;
    }
}
