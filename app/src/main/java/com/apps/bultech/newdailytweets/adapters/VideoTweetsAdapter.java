package com.apps.bultech.newdailytweets.adapters;


import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;

import android.os.Build;
import android.os.Environment;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.apps.bultech.newdailytweets.R;

public class VideoTweetsAdapter extends RecyclerView.ViewHolder {

    View mview;
    public static int REQUEST_CODE = 1;


    public VideoTweetsAdapter(@NonNull View itemView) {
        super(itemView);
        this.mview = itemView;


    }

    public void setVideo(final FragmentActivity ctx, final String title, final String url) {

        TextView textView = mview.findViewById(R.id.titlevideo);
        textView.setText(title);

        final VideoView videoView = mview.findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(url));
        videoView.seekTo(100);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(final MediaPlayer mediaPlayer) {
                final ImageView playBtn = mview.findViewById(R.id.playBtn);
                playBtn.setVisibility(View.VISIBLE);
                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.start();
                        playBtn.setVisibility(View.INVISIBLE);
                    }

                });


            }


        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                ImageView playBtn = mview.findViewById(R.id.playBtn);
                playBtn.setVisibility(View.VISIBLE);
            }
        });

        FrameLayout videoContainer = mview.findViewById(R.id.videoContainer);
        videoContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (videoView != null) {
                    ImageView playBtn = mview.findViewById(R.id.playBtn);
                    videoView.pause();
                    playBtn.setVisibility(View.VISIBLE);
                }

            }

        });

        ImageView shareVid = mview.findViewById(R.id.shareVid);
        shareVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, String.valueOf(url));
                ctx.startActivity(Intent.createChooser(i, "Share Video"));
            }
        });
        ImageView tweetVid = mview.findViewById(R.id.tweetVid);
        tweetVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.setPackage("com.twitter.android");
                    i.putExtra(Intent.EXTRA_TEXT, String.valueOf(url));
                    ctx.startActivity(Intent.createChooser(i, "Share Video"));
                }catch (Exception e){
                    Toast.makeText(ctx,"Twitter app not installed",Toast.LENGTH_LONG).show();
                }
            }
        });
        ImageView downloadBtn = mview.findViewById(R.id.downloadVid);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int permissionCheck = ContextCompat.checkSelfPermission(ctx,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.setDescription("Daily Tweets");
                    request.setTitle("" + title);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    }
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "" + title + ".mp4");


                    DownloadManager manager = (DownloadManager) ctx.getSystemService(Context.DOWNLOAD_SERVICE);
                    manager.enqueue(request);
                } else {
                    ActivityCompat.requestPermissions(ctx,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
                }
            }

        });


    }


}



