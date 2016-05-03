package com.mosambitech.pucresults;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.parse.ParseAnalytics;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class NotificationActivity extends ActionBarActivity {
    TextView tv, tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        tv = (TextView) findViewById(R.id.pep_content);
        tv1 = (TextView) findViewById(R.id.pp_content);

        AdView adview = (AdView) this.findViewById(R.id.adview);
        AdRequest adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);
        try {
            ParseAnalytics.trackAppOpened(getIntent());
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            String jsonData = extras.getString("com.parse.Data");

            JSONObject jObj = new JSONObject(jsonData);
            String text = jObj.getString("alert");
            tv.setText(text);
        } catch (Exception e) {
            Log.e("parse", "barlilla");

        }
        String timeStamp = new SimpleDateFormat("HH:mm  dd-MM-yyyy ").format(Calendar.getInstance().getTime());
        tv1.setText(timeStamp);
    }

    @Override
    public void onBackPressed() {


        Intent i = new Intent(NotificationActivity.this, LaunchActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
