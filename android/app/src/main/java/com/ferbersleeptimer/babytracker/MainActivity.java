package com.ferbersleeptimer.babytracker;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Plugin;
import com.community.admob.AdMob; // <-- Import AdMob Plugin

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Explicitly register AdMob plugin with the Capacitor Bridge
        registerPlugin(AdMob.class);
    }
}