package com.apps.bultech.newdailytweets.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.bultech.newdailytweets.R;
import com.apps.bultech.newdailytweets.adapters.ImagesCategoryListAdapter;
import com.apps.bultech.newdailytweets.tweetclasses.imageCategory;

import java.util.ArrayList;

public class ImageTweetsFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image_tweets, container, false);
        RecyclerView imageCategoryRecycler= view.findViewById(R.id.imageCategoryRecycler);
        ArrayList<imageCategory> imageCategoryArrayList= new ArrayList<>();


        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Abstract),getResources().getDrawable(R.drawable.abstractcover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Art),getResources().getDrawable(R.drawable.artcover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Cities),getResources().getDrawable(R.drawable.citiescover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.ClassicCars),getResources().getDrawable(R.drawable.classiccarscover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Cute),getResources().getDrawable(R.drawable.cutecover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.FamousMusicians),getResources().getDrawable(R.drawable.famousmusicians)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.FamousPaintings),getResources().getDrawable(R.drawable.famouspaintings)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.FamousSitcomJokes),getResources().getDrawable(R.drawable.famoussitcomcover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Memes),getResources().getDrawable(R.drawable.memecover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Nature),getResources().getDrawable(R.drawable.naturecover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.PopularBands),getResources().getDrawable(R.drawable.famousbandscoverr)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.PopularCartoons),getResources().getDrawable(R.drawable.popularcartoons)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.PopularVinyls),getResources().getDrawable(R.drawable.famousvinyls)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Str90sBands),getResources().getDrawable(R.drawable.ninetiesbandscover)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Superheroes),getResources().getDrawable(R.drawable.sups)));
        imageCategoryArrayList.add(new imageCategory(getResources().getString(R.string.Wildlife),getResources().getDrawable(R.drawable.wildlifecover)));

        ImagesCategoryListAdapter imagesCategoryListAdapter= new ImagesCategoryListAdapter(getActivity(),imageCategoryArrayList);
        imageCategoryRecycler.setAdapter(imagesCategoryListAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        imageCategoryRecycler.setLayoutManager(gridLayoutManager);


        return  view;

    }

}