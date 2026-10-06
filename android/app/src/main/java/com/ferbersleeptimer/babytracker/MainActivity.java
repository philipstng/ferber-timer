package com.ferbersleeptimer.babytracker;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.getcapacitor.BridgeActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends BridgeActivity {
    private AdView mAdView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Set custom layout containing ad view
        setContentView(R.layout.activity_main);

        // 2. Initialize Mobile Ads SDK
        MobileAds.initialize(this, initializationStatus -> {});

        // 3. Load Banner Ad
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}