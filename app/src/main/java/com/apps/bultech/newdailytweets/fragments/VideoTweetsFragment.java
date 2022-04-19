package com.apps.bultech.newdailytweets.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.apps.bultech.newdailytweets.R;


import com.apps.bultech.newdailytweets.adapters.VideoTweetsAdapter;
import com.apps.bultech.newdailytweets.tweetclasses.videoTweet;



public class VideoTweetsFragment extends Fragment {

    RecyclerView videoRecycler;
    FirebaseDatabase database;
    DatabaseReference reference;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video_tweets, container, false);

        videoRecycler= view.findViewById(R.id.videoRecycler);
        videoRecycler.setHasFixedSize(true);
        videoRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        videoRecycler.addItemDecoration(itemDecor);

        database= FirebaseDatabase.getInstance();
        reference= database.getReference("Videos");



        return view;


    }
    private void dothething(){
        FirebaseRecyclerAdapter<videoTweet,VideoTweetsAdapter> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<videoTweet, VideoTweetsAdapter>(videoTweet.class, R.layout.video_item,VideoTweetsAdapter.class,reference) {
                    @Override
                    protected void populateViewHolder(VideoTweetsAdapter videoTweetsAdapter, videoTweet videoTweet, int i) {
                        videoTweetsAdapter.setVideo(getActivity(),videoTweet.getTitle(),videoTweet.getUrl());
                    }

                };

        videoRecycler.setAdapter(firebaseRecyclerAdapter);


    }

    @Override
    public void onStart() {
        super.onStart();
        dothething();


    }
}