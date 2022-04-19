package com.apps.bultech.newdailytweets.adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.bultech.newdailytweets.R;
import com.apps.bultech.newdailytweets.detailActivities.FullScreenImageActivity;
import com.apps.bultech.newdailytweets.tweetclasses.Upload;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class ImageTweetsAdapter extends RecyclerView.Adapter<ImageTweetsAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<Upload> mUploads;

    public ImageTweetsAdapter(Context context, ArrayList<Upload> uploads) {
        this.mContext = context;
        this.mUploads = uploads;
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView= (CardView) itemView;
        }
    }


    @NonNull
    @Override
    public ImageTweetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageTweetsAdapter.ViewHolder holder, final int position) {

        CardView cardView= holder.cardView;
        ImageView imageView= cardView.findViewById(R.id.image_view_upload);
        Picasso.with(mContext).load(mUploads.get(position).getmImageUri()).placeholder(R.drawable.placeholdertwo).fit().centerCrop().into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(mContext, FullScreenImageActivity.class);
                intent.putExtra("url",mUploads.get(position).getmImageUri());
                mContext.startActivity(intent);
            }
        });


        final ImageView shareBtn = cardView.findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Picasso.with(mContext).load(mUploads.get(position).getmImageUri()).into(new Target() {
                    @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("image/*");
                        i.putExtra(Intent.EXTRA_STREAM,getLocalBitmapUri(bitmap, mContext));
                        mContext.startActivity(Intent.createChooser(i, "Share Image"));
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
        final ImageView tweetBtn = cardView.findViewById(R.id.tweetBtn);
        tweetBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Picasso.with(mContext).load(mUploads.get(position).getmImageUri()).into(new Target() {
                    @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        try {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("image/*");
                            i.setPackage("com.twitter.android");
                            i.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(bitmap, mContext));
                            mContext.startActivity(Intent.createChooser(i, "Share Image"));
                        }catch (Exception e){
                            Toast.makeText(mContext,"Twitter app not installed",Toast.LENGTH_LONG).show();
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

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }
}
