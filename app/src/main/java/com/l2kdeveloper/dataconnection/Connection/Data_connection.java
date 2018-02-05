package com.l2kdeveloper.dataconnection.Connection;

import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sourav on 2/5/18.
 */

public class Data_connection extends ContextWrapper {

    public Data_connection(Context base) {
        super(base);
    }
    public static boolean isconnected(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isConnected()){
            return true;
        }
        return false;
    }
}
