package com.apps.bultech.newdailytweets.tweetclasses;

import android.graphics.drawable.Drawable;

public class imageCategory {

    private  String categoryTitle;
    private  Drawable imageSrc;
    public  imageCategory(String categoryTitle, Drawable imageSrc){
        this.categoryTitle= categoryTitle;
        this.imageSrc=imageSrc;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setImageSrc(Drawable imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Drawable getImageSrc() {
        return imageSrc;
    }
}
