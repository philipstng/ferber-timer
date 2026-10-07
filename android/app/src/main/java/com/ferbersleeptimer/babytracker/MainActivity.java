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

// Added in new branch version 5
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdSize;

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
        if (webviewContainer != null) {
            webviewContainer.addView(webView, new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
            ));
        }

        // Add modified view hierarchy back to root
        rootView.addView(layoutView);

        // 3. Load Banner Ad dynamically into container
        mAdContainerView = layoutView.findViewById(R.id.ad_view_container);
        if (mAdContainerView != null) {
            // Post to queue to ensure container dimensions are calculated before loading
            mAdContainerView.post(this::loadBanner);
        }   
    }


    // --- LOAD DYNAMIC BANNER ---

    private void loadBanner() {
        // Create new AdView instance
        mAdView = new AdView(this);
        
        // Replace with your real production Ad Unit ID when ready
        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        // Clear container and attach AdView
        mAdContainerView.removeAllViews();
        mAdContainerView.addView(mAdView);

        // Calculate maximum adaptive size fitting available screen width
        AdSize adSize = getAdSize();
        mAdView.setAdSize(adSize);

        // Request and load ad
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Determine current screen display width in dp
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;
        float adWidthPixels = mAdContainerView.getWidth();

        // Fallback to full screen width if layout pass isn't complete
        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }

        int adWidth = (int) (adWidthPixels / density);

        // Option A: Large Anchored Adaptive (Scales up to ~20% height for maximum eCPM)
        return AdSize.getLargeAnchoredAdaptiveBannerAdSize(this, adWidth);

        // Option B: Standard Anchored Adaptive (Caps height strictly at ~15% or 90dp)
        // return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
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