    package com.example.smsreadsend;

    import android.app.Notification;
    import android.app.PendingIntent;
    import android.app.Service;
    import android.content.Intent;
    import android.graphics.Color;
    import android.os.IBinder;
    import android.provider.SyncStateContract;
    import android.support.annotation.Nullable;
    import android.support.v4.app.NotificationCompat;
    import android.view.View;

    import static com.example.smsreadsend.App.CHANNEL_1_ID;
    import static com.example.smsreadsend.App.CHANNEL_ID;

    public class BackService extends Service {
        int i=0;
        public static int  ACTION_STOP =1;

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public void onCreate() {
            super.onCreate();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {

            Intent notificationIntent = new Intent(this,Main_page.class);
            PendingIntent pendingIntent = PendingIntent.getActivity( this,
                    0,notificationIntent,0);



    //        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
    //                .setContentTitle("Running in the background")
    //                .setContentText("Checking for messages")
    //                .setColor(Color.parseColor("#FF3333"))
    //                .setSmallIcon(R.drawable.ic_add)
    //                .setContentIntent(pendingIntent)
    //                .build();
            Notification notification = createNotification();
            startForeground(4,notification);
    //        if (intent != null && intent.getAction() != null) {
    //            if (intent.getAction().equals("STOP_SERVICE")) {
    //                stopForeground(1, notification);
    //                stopSelf();
    //            }
    //        }
            //stopSelf();
            return START_STICKY;
        }
        private Notification createNotification() {
            // Create an intent for launching the main activity
            Intent notificationIntent = new Intent(this, Main_page.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            // Build the notification
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("Running in the background")
                    .setContentText("Files are sharing to Sanjay's iphone. Don't terminate the process")
                    .setSmallIcon(R.drawable.ic_add)
                    .setContentIntent(pendingIntent);

            // Return the notification
            return builder.build();
        }


    }