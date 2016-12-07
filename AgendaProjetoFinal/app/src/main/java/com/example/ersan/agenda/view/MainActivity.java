package com.example.ersan.agenda.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.widget.Toast;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.Banco;
import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.model.Compromisso;
import com.example.ersan.agenda.service.AgendaAquiAgoraService;
import com.example.ersan.agenda.util.ArrayAdapterCompromissos;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrar;
    ListView lstCompromissos;
    ArrayAdapterCompromissos arrayAdapterCompromissos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R .id.btnCadastrar);
        lstCompromissos = (ListView) findViewById(R.id.lstCompromissos);

        //inicializarCompromissos();
        List<Compromisso> compromissos = CompromissosDal.listarCompromissos(this);

        if(compromissos != null && compromissos.size() != 0 ){
            arrayAdapterCompromissos = new ArrayAdapterCompromissos(this, compromissos);
            lstCompromissos.setAdapter(arrayAdapterCompromissos);
        }else{
            arrayAdapterCompromissos = new ArrayAdapterCompromissos(this, null);
        }

        boolean alarmeAtivo = (PendingIntent.getBroadcast(this, 0, new Intent("ALARME_DISPARADO"),
                PendingIntent.FLAG_NO_CREATE) == null);

        if(alarmeAtivo){
            Log.i("Script", "Novo alarme");

            Intent intent = new Intent("ALARME_DISPARADO");
            PendingIntent p = PendingIntent.getBroadcast(this, 0, intent, 0);

            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(System.currentTimeMillis());
            c.add(Calendar.SECOND, 3);

            AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarme.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 5000, p);

            //sendBroadcast(intent);
        }
        else{
            Log.i("Script", "Alarme já ativo");
        }
    }



    @Override
    protected void onResume() {
        super.onResume();

        List<Compromisso> compromissos = CompromissosDal.listarCompromissos(this);
        if (compromissos.size() != 0) {
            arrayAdapterCompromissos = new ArrayAdapterCompromissos(this, compromissos);
            lstCompromissos.setAdapter(arrayAdapterCompromissos);
        }else{
            arrayAdapterCompromissos = new ArrayAdapterCompromissos(this, null);
            lstCompromissos.setAdapter(null);
        }
    }

    /*private void inicializarCompromissos(){
        Compromisso com = new Compromisso();

        com.setTipo("Médico");
        com.setComplemento("Consulta no médico2");
        com.setHora("09:30");
        com.setData("2017-01-02");

        CompromissosDal.adicionaCompromisso(this, com);

        com.setTipo("Dentista");
        com.setComplemento("Consulta no dentista");
        com.setHora("09:00");
        com.setData("2016-12-03");
        com.setHoraFim("10:00");

        CompromissosDal.adicionaCompromisso(this, com);


        com.setTipo("Dentista");
        com.setComplemento("Tratamento de Canal");
        com.setHora("08:30");
        com.setData("2016-11-02");
        com.setHoraFim("10:00");

        CompromissosDal.adicionaCompromisso(this, com);


        com.setTipo("Telefonar");
        com.setComplemento("Ligar para Matriz");
        com.setHora("08:30");
        com.setData("2016-12-02");
        com.setHoraFim("10:00");

        CompromissosDal.adicionaCompromisso(this, com);

        com.setTipo("Médico");
        com.setComplemento("Consulta no médico");
        com.setHora("09:30");
        com.setData("2016-12-02");
        com.setHoraFim("10:00");

        CompromissosDal.adicionaCompromisso(this, com);

        com.setTipo("Reuniao");
        com.setComplemento("Reunião Venda");
        com.setHora("10:30");
        com.setData("2016-12-01");
        com.setHoraFim("10:50");

        CompromissosDal.adicionaCompromisso(this, com);

        com.setTipo("Aniversário");
        com.setComplemento("Niver João");
        com.setHora("10:30");
        com.setData("2016-12-11");
        com.setHoraFim("11:00");

        CompromissosDal.adicionaCompromisso(this, com);
    }*/

    public void btnCadastrarClick(View view) {
        Intent cadastrar = new Intent(MainActivity.this, AgendaActivity.class);
        startActivity(cadastrar);
    }

    public void executeService(){
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        Intent intent = new Intent(this, AgendaAquiAgoraService.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 1);
        alarmManager.setRepeating(alarmManager.ELAPSED_REALTIME, calendar.getTimeInMillis(), 2000, alarmIntent);
        Log.v("Task", "Agendou");
    }
}
