package com.apps.bultech.newdailytweets.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.apps.bultech.newdailytweets.R;
import com.apps.bultech.newdailytweets.tweetclasses.textTweet;

import java.util.ArrayList;

public class databaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="DailyTweetsDB";
    private static final int DB_VERSION= 1;
    Context context;

    public databaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query=("CREATE TABLE TWEETS(_id INTEGER PRIMARY KEY AUTOINCREMENT ,"+"TWEET TEXT,"+"CATEGORY TEXT);");
        sqLiteDatabase.execSQL(query);

        ArrayList<textTweet> textTweetsArrayListDb = new ArrayList<>();
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingtwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingsix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingeight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryAmazing), context.getResources().getString(R.string.amazingten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativeone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativetwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativethree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativefour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativefive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativesix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativeseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativeeight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativenine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCreative), context.getResources().getString(R.string.creativeten)));


        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushtwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushsix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crusheight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryCrush),context.getResources().getString(R.string.crushten)));


        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionaltwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalsix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionaleight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryEmotional),context.getResources().getString(R.string.emotionalten)));


        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricsone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricstwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricsthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricsfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricsfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricssix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricsseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricseight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricsnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousLyrics),context.getResources().getString(R.string.lyricsten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotesone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotestwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotesthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotesfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotesfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotessix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotesseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquoteseight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotesnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFamousQuotes),context.getResources().getString(R.string.famousquotesten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshiptwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipsix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipeiiht)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFriendship),context.getResources().getString(R.string.friendshipten)));


        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnyone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnytwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnythree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnyfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnyfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnysix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnyseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnyeight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnynine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryFunny),context.getResources().getString(R.string.funnyten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationaltwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalsix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationaleight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryInspirational),context.getResources().getString(R.string.inspirationalten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokeone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.joketwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokethree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokefour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokefive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokesix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokeseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokeeight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.jokenine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryJoke),context.getResources().getString(R.string.joketen)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happyone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happytwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happythree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happyfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happyfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happysix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happyseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happyeight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happynine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHappy),context.getResources().getString(R.string.happyten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidayone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidaytwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidaythree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidayfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidayfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidaysix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidayseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidayeight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidaynine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryHoliday),context.getResources().getString(R.string.holidayten)));


        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotesone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotestwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotesthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotesfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotesfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotessix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotesseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequoteseight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotesnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeQuotes),context.getResources().getString(R.string.lifequotesten)));


        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipsone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipstwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipsthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipsfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipsfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipssix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipsseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipseight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipsnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLifeTips),context.getResources().getString(R.string.lifetipsten)));


        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionsone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionstwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionsthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionsfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionsfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionssix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionsseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionseight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionsnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryLogicQuestions),context.getResources().getString(R.string.logicquestionsten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationaltwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalsix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationaleight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryMotivational),context.getResources().getString(R.string.motivationalten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punsone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punstwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punsthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punsfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punsfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punssix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punsseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punseight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punsnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryPuns),context.getResources().getString(R.string.punsten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionsone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionstwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionsthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionsfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionsfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionssix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionsseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionseight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionsnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryRhetoricQuestions),context.getResources().getString(R.string.rhetoricquestionsten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smarttwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartthree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartfour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartfive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartsix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smarteight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartnine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categorySmart),context.getResources().getString(R.string.smartten)));

        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wiseone)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wisetwo)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wisethree)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wisefour)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wisefive)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wisesix)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wiseseven)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wiseeight)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wisenine)));
        textTweetsArrayListDb.add(new textTweet(context.getResources().getString(R.string.categoryWise),context.getResources().getString(R.string.wiseten)));


        for (textTweet tweet : textTweetsArrayListDb) {

            ContentValues tweetValues = new ContentValues();
            tweetValues.put("TWEET", tweet.getTweet());
            tweetValues.put("CATEGORY", tweet.getCategoryName());
            sqLiteDatabase.insert("TWEETS", null, tweetValues);

        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Cursor reafAllTweets(){
        String query="SELECT * FROM TWEETS";
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();

        Cursor cursor= null;
        if (sqLiteDatabase!= null){
            cursor=  sqLiteDatabase.rawQuery(query,null);
        }
        return cursor;
    }
}
