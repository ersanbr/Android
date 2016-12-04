package com.example.ersan.agenda.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.model.Compromisso;
import com.example.ersan.agenda.view.AgendaActivity;

/**
 * Created by deynesonborba on 12/2/16.
 */

public class Notification {

    public void createNotification(Context context, Compromisso com){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("Novo compromisso adicionado");
        builder.setContentText("Compromisso adicionado: " + com.getComplemento());

        Intent notificationIntent = new Intent(context, AgendaActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        builder.setColor(Color.RED);
        builder.setFullScreenIntent(pendingIntent, false);
        builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
