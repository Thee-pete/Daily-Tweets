package com.apps.bultech.newdailytweets.detailActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.apps.bultech.newdailytweets.R;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FullScreenImageActivity extends AppCompatActivity {
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        Intent intent=getIntent();
        final String url= intent.getExtras().getString("url");


        ImageView imageView= findViewById(R.id.fullScreenImage);
        Picasso.with(FullScreenImageActivity.this).load(url).placeholder(R.drawable.placeholdertwo).fit().centerInside().into(imageView);

        ImageView sharefullBtn= findViewById(R.id.sharefullBtn);
        sharefullBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(FullScreenImageActivity.this).load(url).into(new Target() {
                    @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("image/*");
                        i.putExtra(Intent.EXTRA_STREAM,getLocalBitmapUri(bitmap, FullScreenImageActivity.this));
                        startActivity(Intent.createChooser(i, "Share Image"));
                    }
                    @Override public void onBitmapFailed(Drawable errorDrawable) { }
                    @Override public void onPrepareLoad(Drawable placeHolderDrawable) { }
                });

            }
            public Uri getLocalBitmapUri(Bitmap bmp, Context context) {
                Uri bmpUri = null;
                try {
                    File file =  new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
                    FileOutputStream out = new FileOutputStream(file);
                    bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
                    out.close();
                    bmpUri = Uri.fromFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bmpUri;


            }
        });
        ImageView tweetfullBtn= findViewById(R.id.tweetfullBtn);
        tweetfullBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(FullScreenImageActivity.this).load(url).into(new Target() {
                    @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        try {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("image/*");
                            i.setPackage("com.twitter.android");
                            i.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(bitmap, FullScreenImageActivity.this));
                            startActivity(Intent.createChooser(i, "Share Image"));
                        }catch (Exception e){
                            Toast.makeText(FullScreenImageActivity.this,"Twitter app not installed",Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override public void onBitmapFailed(Drawable errorDrawable) { }
                    @Override public void onPrepareLoad(Drawable placeHolderDrawable) { }
                });

            }
            public Uri getLocalBitmapUri(Bitmap bmp, Context context) {
                Uri bmpUri = null;
                try {
                    File file =  new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
                    FileOutputStream out = new FileOutputStream(file);
                    bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
                    out.close();
                    bmpUri = Uri.fromFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bmpUri;
            }
        });

        adView = new AdView(this,  getResources().getString(R.string.fbbanner), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.ful_ad_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}