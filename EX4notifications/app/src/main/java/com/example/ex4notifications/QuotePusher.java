package com.example.ex4notifications;

/**
 * Created by Michael Segal on 22/11/2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Random;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Random;

public class QuotePusher extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ArrayList<String> quotes = new ArrayList<>();
        quotes.add("I'm pickle Rick!!! - Rick");
        quotes.add("Weddings are basically funerals with cake - Rick");
        quotes.add("School is not a place for smart people - Rick");
        quotes.add("Wubba lubba dub dub - Rick");
        quotes.add("Let's get riggiti wrecked - Rick");
        quotes.add("Pluto.. is a planet! - Jerry");
        quotes.add("I'm tiny Rick!!! - Rick");

        String quote = getRandomQuote(quotes);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "M_CH_ID");

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Rick and Morty quotes")
                .setContentText(quote);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }

    private String getRandomQuote (ArrayList<String> quotes) {
        Random rand = new Random();
        String randomQuote = quotes.get(rand.nextInt(quotes.size()));
        return randomQuote;
    }
}
