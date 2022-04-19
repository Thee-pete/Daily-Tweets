package com.apps.bultech.newdailytweets.PopupAds;

import android.content.Context;
import android.content.Intent;
import android.util.Log;


import com.apps.bultech.newdailytweets.R;
import com.apps.bultech.newdailytweets.detailActivities.textTweetsActivity;

import com.facebook.ads.*;
public class PopUpAds {


    public static int AD_COUNT;
    public static final int AD_SHOW_COUNT=2;



    public static void ShowInterstitialAds(final Context mContext, final String category){
        AD_COUNT++;
        if (AD_COUNT==AD_SHOW_COUNT){
            AD_COUNT=0;
            final InterstitialAd interstitialAd = new InterstitialAd(mContext,mContext.getResources().getString(R.string.fbinter));

            final String TAG = PopUpAds.class.getSimpleName();
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    // Interstitial ad displayed callback
                    Log.e(TAG, "Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    Log.d(TAG, "Interstitial ad clicked!");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Intent intent = new Intent(mContext, textTweetsActivity.class);
                    intent.putExtra("CATEGORYNAME", category);
                    mContext.startActivity(intent);
                }

                @Override
                public void onAdLoaded(Ad ad) {

                    interstitialAd.show();
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                    Log.d(TAG, "Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // Ad impression logged callback
                    Log.d(TAG, "Interstitial ad impression logged!");
                }
            };
            interstitialAd.loadAd(
                    interstitialAd.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());



        }
        else {
        Intent intent = new Intent(mContext, textTweetsActivity.class);
        intent.putExtra("CATEGORYNAME", category);
        mContext.startActivity(intent);

        }




    }


}
