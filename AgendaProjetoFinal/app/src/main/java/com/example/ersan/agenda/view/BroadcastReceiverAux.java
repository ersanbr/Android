package com.example.ersan.agenda.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.model.Compromisso;
import com.example.ersan.agenda.service.AgendaAquiAgoraService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class BroadcastReceiverAux extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("Script", "-> Alarme");

        List<Compromisso> compromissos = CompromissosDal.listarCompromissos(context);

        Log.v("Compromisso List Size", String.valueOf(compromissos.size()));

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormat = simpleDateFormat.format(calendar.getTime());

        //Toast.makeText(context, "Test BroadcastReceiver", Toast.LENGTH_SHORT).show();

        int i = 0;
        for(Compromisso c : compromissos){
            Log.v("Compromisso", "Position: " + i + ", " + c.getComplemento().toString() + " Data: " + c.getData().toString());
            Log.v("DataFormat", dataFormat);
            if(c.getData().toString().equals(dataFormat)){
                Log.v("Notification", "Notificou");
                Toast.makeText(context, "Copromisso se aproximando", Toast.LENGTH_SHORT).show();
                gerarNotificacao(context, new Intent(context, MainActivity.class),
                        "Nova mensagem", "Compromisso se aproximando", c.getComplemento().toString());
            }
            i++;
        }

        //gerarNotificacao(context, new Intent(context, MainActivity.class), "Nova mensagem", "Título", "Descrição nova mensagem");
    }


    public void gerarNotificacao(Context context, Intent intent, CharSequence ticker, CharSequence titulo, CharSequence descricao){
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(context, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker(ticker);
        builder.setContentTitle(titulo);
        builder.setContentText(descricao);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher));
        builder.setContentIntent(p);

        Notification n = builder.build();
        n.vibrate = new long[]{150, 300, 150, 600};
        n.flags = Notification.FLAG_AUTO_CANCEL;
        nm.notify(R.drawable.ic_launcher, n);

        try{
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(context, som);
            toque.play();
        }
        catch(Exception e){}
    }
}

