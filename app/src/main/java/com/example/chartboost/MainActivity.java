package com.example.chartboost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Privacy.model.CCPA;
import com.chartboost.sdk.Privacy.model.GDPR;

public class MainActivity extends AppCompatActivity {

    private String location = CBLocation.LOCATION_DEFAULT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chartboost.addDataUseConsent(this, new GDPR(GDPR.GDPR_CONSENT.BEHAVIORAL));
        Chartboost.addDataUseConsent(this, new CCPA(CCPA.CCPA_CONSENT.OPT_IN_SALE));

        Chartboost.startWithAppId( getApplicationContext() , getResources().getString(R.string.appId) , getResources().getString(R.string.appSignature));
    }

    public void cacheInterstitialAd(View view) {
        if (!Chartboost.hasInterstitial(location)) {
            Chartboost.cacheInterstitial(location);
        }
        generateInterstitialAd();
    }

    public void cacheRvAd(View view) {
        if (!Chartboost.hasRewardedVideo(location)) {
            Chartboost.cacheRewardedVideo(location);
        }
        generateRvAd();
    }

    public void generateInterstitialAd() {
        Chartboost.showInterstitial(location);
    }

    public void generateRvAd() {
        Chartboost.showRewardedVideo(location);
    }

}
