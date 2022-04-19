package com.apps.bultech.newdailytweets.detailActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.bultech.newdailytweets.R;
import com.apps.bultech.newdailytweets.adapters.textTweetsAdapter;
import com.apps.bultech.newdailytweets.data.databaseHelper;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import java.util.ArrayList;

public class textTweetsActivity extends AppCompatActivity {


    private SQLiteOpenHelper sqLiteOpenHelper = new databaseHelper(this);
    private  SQLiteDatabase sqLiteDatabase;
    private  Cursor cursor;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textweets);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.getSupportActionBar().setDisplayShowCustomEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String categoryName = intent.getExtras().getString("CATEGORYNAME");

        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.titleview, null);
        ((TextView)v.findViewById(R.id.title)).setText(categoryName);
        this.getSupportActionBar().setCustomView(v);

        ArrayList<String> textTweetsArrayList = new ArrayList<>();

        //cursor = sqLiteDatabase.query("TWEETS", new String[]{"TWEET", "CATEGORY"}, "CATEGORY=?", new String[]{categoryName}, null, null, null, null);
        sqLiteDatabase= sqLiteOpenHelper.getReadableDatabase();
        String query = "SELECT * FROM TWEETS WHERE CATEGORY= '" + categoryName + "' ";
        cursor = sqLiteDatabase.rawQuery(query, null);

        String tweetStr = "";
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No tweets", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                tweetStr = cursor.getString(1);
                textTweetsArrayList.add(tweetStr);
            }
        }


        cursor.close();
        sqLiteDatabase.close();

        RecyclerView tweetRecycler = findViewById(R.id.tweetRecycler);
        textTweetsAdapter textTweetsAdapter = new textTweetsAdapter(textTweetsArrayList);
        tweetRecycler.setAdapter(textTweetsAdapter);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        tweetRecycler.addItemDecoration(itemDecor);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        tweetRecycler.setLayoutManager(linearLayoutManager);

        adView = new AdView(this,  getResources().getString(R.string.fbbanner), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.ad_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}