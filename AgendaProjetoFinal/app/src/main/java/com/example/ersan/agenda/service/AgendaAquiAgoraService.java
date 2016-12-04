package com.example.ersan.agenda.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.WorkerThread;
import android.util.Log;
import android.widget.Toast;
import android.content.ComponentName;

import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.model.Compromisso;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AgendaAquiAgoraService extends Service {

    private boolean running;
    private static final int MYJOBID = 1;
    JobScheduler jobScheduler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("Servico", "AgendaAquiAgoraService.onCreate() - Servico Criado");
        Toast.makeText(this, "AgendaAquiAgoraService.onCreate() - Servico Criado", Toast.LENGTH_SHORT).show();

        List<Compromisso> compromissos = CompromissosDal.listarCompromissos(AgendaAquiAgoraService.this);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormat = simpleDateFormat.format(calendar.getTime());

        Toast.makeText(AgendaAquiAgoraService.this, "Test", Toast.LENGTH_SHORT).show();

        for(Compromisso c : compromissos){
            if(c.getData().equals(dataFormat)){

            }
        }
    }

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public boolean onStartJob(JobParameters params) {
//
//        Toast.makeText(this,"MyJobService.onStartJob()",Toast.LENGTH_SHORT).show();
//        return false;
//    }
//
//    public boolean onStopJob(JobParameters params) {
//        Toast.makeText(this, "MyJobService.onStopJob()", Toast.LENGTH_SHORT).show();
//        return false;
//    }



//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.v("Servico", "AgendaAquiAgoraService.onStartCommand() - Servico Iniciado" + startId);
//        running = true;
//        new WorkerThread().start();
//        Log.v("Task", "Startou");
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    class WorkerThread extends Thread{
//        public void run(){
//            try {
//                Log.v("Task", "Entrou na task");
//                List<Compromisso> compromissos = CompromissosDal.listarCompromissos(AgendaAquiAgoraService.this);
//
//                Calendar calendar = Calendar.getInstance();
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                String dataFormat = simpleDateFormat.format(calendar.getTime());
//
//                Toast.makeText(AgendaAquiAgoraService.this, "Test", Toast.LENGTH_SHORT).show();
//
//                for(Compromisso c : compromissos){
//                    if(c.getData().equals(dataFormat)){
//
//                    }
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
}
