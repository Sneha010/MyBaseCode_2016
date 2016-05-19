package com.tcs.basecode.helpers;

import android.content.Context;
import android.support.annotation.IntDef;

import com.tcs.basecode.R;
import com.tcs.basecode.model.NavigationDrawerItem;

import java.util.ArrayList;

/**
 * Created by Sneha Khadatare : 587823
 * on 5/19/2016.
 */
public class NavigationItemsBuilder {


    public static final int HOME = 0;
    public static final int EVENTS = 1;
    public static final int TRACKING_AND_RESULTS = 2;
    public static final int STATISTICS = 3;
    public static final int CHARITY = 4;
    public static final int SOCIAL_MEDIA = 5;
    public static final int NEWS = 6;
    public static final int WEATHER = 7;
    public static final int EXPO = 8;
    public static final int INFO = 9;

    @IntDef({HOME , EVENTS , TRACKING_AND_RESULTS, STATISTICS , CHARITY , SOCIAL_MEDIA ,
            NEWS , WEATHER , EXPO , INFO})

    public @interface DrawerMenu{
    }

    public static ArrayList<NavigationDrawerItem> buildDrawerItems(Context context){

        ArrayList<NavigationDrawerItem> itemList = new ArrayList<>();

        NavigationDrawerItem item = NavigationDrawerItem.newInstance()
                                                        .withTag(HOME)
                                                        .withName("")
                                                        .setIconDrawableSelected(R.drawable.drawer_home_icon)
                                                        .setIconDrawableUnselected(R.drawable.drawer_home_icon)
                                                        .setShowSepLine(false)
                                                        .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(EVENTS)
                .withName(context.getResources().getString(R.string.h_events))
                .setIconDrawableSelected(R.drawable.drawer_home_icon)
                .setIconDrawableUnselected(R.drawable.drawer_home_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(TRACKING_AND_RESULTS)
                .withName(context.getResources().getString(R.string.h_tracking_and_results))
                .setIconDrawableSelected(R.drawable.drawer_tracking_icon)
                .setIconDrawableUnselected(R.drawable.drawer_tracking_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(STATISTICS)
                .withName(context.getResources().getString(R.string.h_statistics))
                .setIconDrawableSelected(R.drawable.drawer_statistics_icon)
                .setIconDrawableUnselected(R.drawable.drawer_statistics_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(CHARITY)
                .withName(context.getResources().getString(R.string.h_charity))
                .setIconDrawableSelected(R.drawable.drawer_charity_icon)
                .setIconDrawableUnselected(R.drawable.drawer_charity_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(SOCIAL_MEDIA)
                .withName(context.getResources().getString(R.string.h_social_madia))
                .setIconDrawableSelected(R.drawable.drawer_social_icon)
                .setIconDrawableUnselected(R.drawable.drawer_social_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(NEWS)
                .withName(context.getResources().getString(R.string.h_news))
                .setIconDrawableSelected(R.drawable.drawer_news_icon)
                .setIconDrawableUnselected(R.drawable.drawer_news_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(WEATHER)
                .withName(context.getResources().getString(R.string.h_weather))
                .setIconDrawableSelected(R.drawable.drawer_weather_icon)
                .setIconDrawableUnselected(R.drawable.drawer_weather_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(EXPO)
                .withName(context.getResources().getString(R.string.h_expo))
                .setIconDrawableSelected(R.drawable.drawer_expo_icon)
                .setIconDrawableUnselected(R.drawable.drawer_expo_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        item = NavigationDrawerItem.newInstance()
                .withTag(INFO)
                .withName(context.getResources().getString(R.string.h_info))
                .setIconDrawableSelected(R.drawable.drawer_info_icon)
                .setIconDrawableUnselected(R.drawable.drawer_info_icon)
                .setShowSepLine(false)
                .setShowPushNotification(false);

        itemList.add(item);

        return itemList;
    }
}
