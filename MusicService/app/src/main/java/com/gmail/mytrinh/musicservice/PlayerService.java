package com.gmail.mytrinh.musicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class PlayerService extends Service {
    MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        //player = MediaPlayer.create(this, R.raw.abc);
        player.start();
        player.setLooping(true);
        return START_STICKY;
    }

    public void onDestroy(){
        player.stop();
        player.release();
        super.onDestroy();
    }

    public void onTaskRemoved(Intent rootIntent){
        player.stop();
        player.release();
        Intent broadcastIntent = new Intent(this, MusicBroadcastReceiver.class);
        sendBroadcast(broadcastIntent);
    }


}
