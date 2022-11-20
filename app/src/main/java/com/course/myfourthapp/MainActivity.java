package com.course.myfourthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyReceiver receiver;
    IntentFilter intentFilter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Android App:", "On Create");
        receiver = new MyReceiver();
        intentFilter = new IntentFilter("com.course.CUSTOM_INTENT");
    }

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.course.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiver);
    }


}