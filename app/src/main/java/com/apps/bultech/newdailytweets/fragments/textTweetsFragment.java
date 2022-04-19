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

import com.apps.bultech.newdailytweets.R;
import com.apps.bultech.newdailytweets.adapters.textCategoryAdapter;
import com.apps.bultech.newdailytweets.tweetclasses.textCategory;

import java.util.ArrayList;

public class textTweetsFragment extends Fragment  {


    RecyclerView categoryRecycler;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text_tweets, container, false);

        categoryRecycler = view.findViewById(R.id.textCategoryRecycler);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        categoryRecycler.addItemDecoration(itemDecor);




        ArrayList<textCategory> categoryArrayList= new ArrayList<>();

        textCategory amazingTweets = new textCategory(getResources().getString(R.string.categoryAmazing));
        textCategory creativeTweets = new textCategory(getResources().getString(R.string.categoryCreative));
        textCategory crushTweets = new textCategory(getResources().getString(R.string.categoryCrush));
        textCategory emotionalTweets = new textCategory(getResources().getString(R.string.categoryEmotional));
        textCategory famousLyricsTweets = new textCategory(getResources().getString(R.string.categoryFamousLyrics));
        textCategory famousQuotesTweets = new textCategory(getResources().getString(R.string.categoryFamousQuotes));
        textCategory friendshipTweets = new textCategory(getResources().getString(R.string.categoryFriendship));
        textCategory funnyTweets = new textCategory(getResources().getString(R.string.categoryFunny));
        textCategory happyTweets = new textCategory(getResources().getString(R.string.categoryHappy));
        textCategory holidayTweets = new textCategory(getResources().getString(R.string.categoryHoliday));
        textCategory inspirationalTweets = new textCategory(getResources().getString(R.string.categoryInspirational));
        textCategory jokeTweets = new textCategory(getResources().getString(R.string.categoryJoke));
        textCategory lifeQuotesTweets = new textCategory(getResources().getString(R.string.categoryLifeQuotes));
        textCategory lifeTipsTweets = new textCategory(getResources().getString(R.string.categoryLifeTips));
        textCategory logicQuestionsTweets = new textCategory(getResources().getString(R.string.categoryLogicQuestions));
        textCategory motivationalTweets = new textCategory(getResources().getString(R.string.categoryMotivational));
        textCategory punsTweets = new textCategory(getResources().getString(R.string.categoryPuns));
        textCategory rhetoricQuestionsTweets = new textCategory(getResources().getString(R.string.categoryRhetoricQuestions));
        textCategory smartTweets = new textCategory(getResources().getString(R.string.categorySmart));
        textCategory wiseTweets = new textCategory(getResources().getString(R.string.categoryWise));


        categoryArrayList.add(amazingTweets);
        categoryArrayList.add(creativeTweets);
        categoryArrayList.add(crushTweets);
        categoryArrayList.add(emotionalTweets);
        categoryArrayList.add(famousLyricsTweets);
        categoryArrayList.add(famousQuotesTweets);
        categoryArrayList.add(friendshipTweets);
        categoryArrayList.add(funnyTweets);
        categoryArrayList.add(happyTweets);
        categoryArrayList.add(holidayTweets);
        categoryArrayList.add(inspirationalTweets);
        categoryArrayList.add(jokeTweets);
        categoryArrayList.add(lifeQuotesTweets);
        categoryArrayList.add(lifeTipsTweets);
        categoryArrayList.add(logicQuestionsTweets);
        categoryArrayList.add(motivationalTweets);
        categoryArrayList.add(punsTweets);
        categoryArrayList.add(rhetoricQuestionsTweets);
        categoryArrayList.add(smartTweets);
        categoryArrayList.add(wiseTweets);

        categoryRecycler.setAdapter(new textCategoryAdapter(getActivity(),categoryArrayList));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        categoryRecycler.setLayoutManager(linearLayoutManager);




        return view;




    }



}