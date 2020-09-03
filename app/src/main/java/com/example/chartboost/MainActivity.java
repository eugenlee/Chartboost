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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chartboost.addDataUseConsent(this, new GDPR(GDPR.GDPR_CONSENT.BEHAVIORAL));
        Chartboost.addDataUseConsent(this, new CCPA(CCPA.CCPA_CONSENT.OPT_IN_SALE));

        Chartboost.startWithAppId( getApplicationContext() , getResources().getString(R.string.appId) , getResources().getString(R.string.appSignature));
//      Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
    }

    public void generateInterstitialAd(View view) {
        Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
    }

    public void generateRvAd(View view) {
        Chartboost.showRewardedVideo(CBLocation.LOCATION_DEFAULT);
    }

}
