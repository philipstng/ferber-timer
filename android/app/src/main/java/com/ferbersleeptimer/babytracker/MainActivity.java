package com.ferbersleeptimer.babytracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        // 1. Initialize Mobile Ads SDK
        MobileAds.initialize(this, initializationStatus -> {});

        // 2. Setup Native Ad Layout around Capacitor's WebView
        setupAdLayout();
    }

    private void setupAdLayout() {
        ViewGroup rootView = findViewById(android.R.id.content);
        if (rootView == null || rootView.getChildCount() == 0) return;

        // Get Capacitor's WebView
        View webView = rootView.getChildAt(0);

        // Inflate custom layout
        LayoutInflater inflater = LayoutInflater.from(this);
        View layoutView = inflater.inflate(R.layout.activity_main, rootView, false);

        // Re-parent WebView inside webview_container
        rootView.removeView(webView);
        FrameLayout webviewContainer = layoutView.findViewById(R.id.webview_container);
        webviewContainer.addView(webView, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        ));

        // Add modified view hierarchy back to root
        rootView.addView(layoutView);

        // 3. Load Banner Ad
        mAdView = layoutView.findViewById(R.id.adView);
        if (mAdView != null) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
    }

    // --- AdView Lifecycle Callbacks ---

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause(); // Pauses ad auto-refreshing & animations
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume(); // Resumes ad timer & animations
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy(); // Cleans up resources & prevents memory leaks
        }
        super.onDestroy();
    }
}