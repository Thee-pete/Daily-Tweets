package com.apps.bultech.newdailytweets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.bultech.newdailytweets.PopupAds.PopUpAds;
import com.apps.bultech.newdailytweets.R;

import com.apps.bultech.newdailytweets.tweetclasses.textCategory;

import java.util.ArrayList;

public class textCategoryAdapter extends RecyclerView.Adapter<textCategoryAdapter.ViewHolder> {




    private ArrayList<textCategory> textCategoryArrayList;

    private Context mContext;


    public textCategoryAdapter(Context mContext,ArrayList<textCategory> textCategoryArrayList)
    {
        this.textCategoryArrayList= textCategoryArrayList;

        this.mContext=mContext;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView categoryCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.categoryCard = (CardView) itemView;
            final TextView categoryName = categoryCard.findViewById(R.id.categoryName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(mContext, textTweetsActivity.class);
                   // intent.putExtra("CATEGORYNAME", categoryName.getText().toString());
                    //mContext.startActivity(intent);
                    PopUpAds.ShowInterstitialAds(mContext,categoryName.getText().toString());

                }
            });
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView caterogyCard= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_text_category,parent,false);

        return new ViewHolder(caterogyCard);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        CardView categoryCard= holder.categoryCard;
        final TextView categoryName= categoryCard.findViewById(R.id.categoryName);
        categoryName.setText(textCategoryArrayList.get(position).getCategoryName());




    }

    @Override
    public int getItemCount() {
        return textCategoryArrayList.size();
    }




}
