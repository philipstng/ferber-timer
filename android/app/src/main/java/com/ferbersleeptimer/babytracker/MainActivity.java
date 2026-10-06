package com.ferbersleeptimer.babytracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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

        // DO NOT call setContentView(R.layout.activity_main) here!
        
        // 1. Initialize Mobile Ads SDK
        MobileAds.initialize(this, initializationStatus -> {});

        // 2. Setup Native Ad Layout around Capacitor's WebView
        setupAdLayout();
    }

    private void setupAdLayout() {
        // Get Capacitor's root view
        ViewGroup rootView = findViewById(android.R.id.content);
        if (rootView == null || rootView.getChildCount() == 0) return;

        // Get Capacitor's WebView (the first child created by BridgeActivity)
        View webView = rootView.getChildAt(0);

        // Inflate your activity_main.xml layout
        LayoutInflater inflater = LayoutInflater.from(this);
        View layoutView = inflater.inflate(R.layout.activity_main, rootView, false);

        // Remove the webview from rootView and attach it into your webview_container
        rootView.removeView(webView);
        FrameLayout webviewContainer = layoutView.findViewById(R.id.webview_container);
        webviewContainer.addView(webView, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        ));

        // Add the custom layout containing the webview and the ad back to root
        rootView.addView(layoutView);

        // 3. Load Banner Ad
        mAdView = layoutView.findViewById(R.id.adView);
        if (mAdView != null) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
    }
}