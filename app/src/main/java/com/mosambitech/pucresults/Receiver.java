package com.mosambitech.pucresults;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParsePushBroadcastReceiver;
import com.parse.PushService;

public class Receiver extends ParsePushBroadcastReceiver {

    @Override
    public void onPushOpen(Context context, Intent intent) {
        Log.e("Push", "Clicked");
        Intent i = new Intent(context, NotificationActivity.class);
        i.putExtras(intent.getExtras());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}