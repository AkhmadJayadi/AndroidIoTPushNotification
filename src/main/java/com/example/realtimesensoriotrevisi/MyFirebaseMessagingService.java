package com.example.realtimesensoriotrevisi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService{
    //private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    /**
     * Create and show a push notification when app is in foreground, otherwise (when in background) firebase automatically generates notification
     *
     * @param messageTitle FCM message title received.
     * @param messageBody  FCM message body received.
     */
    //private void sendNotification(String messageTitle, String messageBody) {
    private void sendNotification(Context context, Intent intent, String messageTitle, String messageBody) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent ResultIntent = new Intent(this, MainActivity.class);
        //PendingIntent pi = PendingIntent.getActivity(this, 1 /* Request code */, ResultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pi = PendingIntent.getActivity(this,1, ResultIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        int idNotifikasi = 0;
        String channelID = "channelTest";
        String channelName = "Test IoT";

        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mchannel = new NotificationChannel(channelID,channelName,importance);
            notificationManager.createNotificationChannel(mchannel);
        }

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, channelID)
                        .setContentTitle(messageTitle)
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(messageBody))
                        .setPriority(Notification.PRIORITY_MAX)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pi);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(intent);
        notificationManager.notify(idNotifikasi++ /* ID of notification */, notificationBuilder.build());


//
//        Log.i(TAG, "sendNotification: ");
//        //'MainActivity' is the target activity. When notification will be clicked, 'MainActivity' will be triggered
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder =
//                new NotificationCompat.Builder(this, "m")
//                        .setContentTitle(messageTitle)
//                        .setContentText(messageBody)
//                        .setAutoCancel(true)
//                        .setSound(defaultSoundUri)
//                        .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        // Since android Oreo notification channel is needed.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel("m",
//                    "Channel human readable title",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//            notificationManager.createNotificationChannel(channel);
//        }
//
//        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String title = "";
        String message = "";

        // Check if message contains a notification payload.

        if (remoteMessage.getNotification() != null) {
            try {
                title = remoteMessage.getNotification().getTitle();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                message = remoteMessage.getNotification().getBody();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        sendNotification(getApplicationContext(), new Intent(),title, message);

    }
//
//    @Override
//    public void onNewToken(String s) {
//        super.onNewToken(s);
//        sendTokenToServer(s);
//    }
//
//    //update your server token with new one
//    private void sendTokenToServer(String newToken) {
//        Log.i(TAG, "sendTokenToServer: " + newToken);
//    }
}
