package com.apps.bultech.newdailytweets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.bultech.newdailytweets.PopupAds.PopUpsImagesCat;
import com.apps.bultech.newdailytweets.R;
import com.apps.bultech.newdailytweets.tweetclasses.imageCategory;

import java.util.ArrayList;

public class ImagesCategoryListAdapter extends RecyclerView.Adapter<ImagesCategoryListAdapter.ViewHolder> {

    private ArrayList<imageCategory> imageCategoryArrayList;
    private Context mContext;

    public ImagesCategoryListAdapter(Context mContext,ArrayList<imageCategory> imageCategories){
        this.mContext=mContext;
        this.imageCategoryArrayList= imageCategories;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView= (CardView) itemView;
            final TextView categoryTitle= cardView.findViewById(R.id.categoryTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Intent intent= new Intent(mContext, ImageTweetsActivity.class);
                   // intent.putExtra("CATEGORYTITLE", categoryTitle.getText().toString());
                    //mContext.startActivity(intent);
                    PopUpsImagesCat.ShowInterstitialAds(mContext,categoryTitle.getText().toString());

                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CardView cardView= holder.cardView;
        TextView categoryTitle= cardView.findViewById(R.id.categoryTitle);
        categoryTitle.setText(imageCategoryArrayList.get(position).getCategoryTitle());
        ImageView catLayout= cardView.findViewById(R.id.categoryLayout);
        catLayout.setBackground(imageCategoryArrayList.get(position).getImageSrc());


    }

    @Override
    public int getItemCount() {
        return imageCategoryArrayList.size();
    }


}
