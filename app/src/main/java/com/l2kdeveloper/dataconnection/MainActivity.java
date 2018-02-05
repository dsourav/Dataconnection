package com.l2kdeveloper.dataconnection;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.l2kdeveloper.dataconnection.Connection.Data_connection;

public class MainActivity extends AppCompatActivity {

    private Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.registerReceiver(receiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.registerReceiver(receiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.unregisterReceiver(receiver);
    }

    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

          if (Data_connection.isconnected(ctx)){
            Intent intent1=new Intent(MainActivity.this,Main2Activity.class);
            ComponentName componentName=intent1.getComponent();//while going to the next activity this activity will be removed fromthr qeue
            Intent mintent= IntentCompat.makeRestartActivityTask(componentName);
            context.startActivity(mintent);
        }}
    };
}
