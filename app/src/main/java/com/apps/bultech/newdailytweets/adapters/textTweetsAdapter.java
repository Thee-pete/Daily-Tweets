package com.apps.bultech.newdailytweets.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.bultech.newdailytweets.R;

import java.util.ArrayList;

public class textTweetsAdapter extends RecyclerView.Adapter<textTweetsAdapter.ViewHolder> {

    ArrayList<String> textTweetsArrayList;


    public textTweetsAdapter(ArrayList<String> textTweetsArrayList) {
        this.textTweetsArrayList = textTweetsArrayList;


    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout tweetCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tweetCard = (RelativeLayout) itemView;
        }
    }


    @NonNull
    @Override
    public textTweetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelativeLayout tweetCard = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_text_tweets, parent, false);
        return new ViewHolder(tweetCard);
    }

    @Override
    public void onBindViewHolder(@NonNull textTweetsAdapter.ViewHolder holder, int position) {

        RelativeLayout tweetCard = holder.tweetCard;
        final Context mContext = tweetCard.getContext();
        final TextView tweet = tweetCard.findViewById(R.id.tweet);
        tweet.setText(textTweetsArrayList.get(position));
        ImageView copyButton = tweetCard.findViewById(R.id.copyButton);
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboardManager = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Tweet", tweet.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(mContext, "Copied to clipboard", Toast.LENGTH_LONG).show();

            }
        });
        ImageView shareButton = tweetCard.findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                String shareBody = tweet.getText().toString();
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, mContext.getResources().getString(R.string.app_name));
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                mContext.startActivity(Intent.createChooser(intent, "Share using"));

            }
        });
        ImageView tweetButton = tweetCard.findViewById(R.id.tweetButton);
        tweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent tweetIntent = new Intent(Intent.ACTION_SEND);
                    tweetIntent.putExtra(Intent.EXTRA_TEXT, tweet.getText().toString());
                    tweetIntent.setType("text/plain");
                    tweetIntent.setPackage("com.twitter.android");
                    mContext.startActivity(tweetIntent);
                } catch (Exception e) {
                    Toast.makeText(mContext,"Twitter app not installed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return textTweetsArrayList.size();
    }
}
