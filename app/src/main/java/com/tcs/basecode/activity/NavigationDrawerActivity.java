package com.tcs.basecode.activity;

import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;

import com.tcs.basecode.fragment.CharityMainFragment;
import com.tcs.basecode.fragment.EventsMainFragment;
import com.tcs.basecode.fragment.ExpoMainFragment;
import com.tcs.basecode.fragment.HomeFragment;
import com.tcs.basecode.fragment.InfoMainFragment;
import com.tcs.basecode.fragment.NewsMainFragment;
import com.tcs.basecode.fragment.SocialMediaMainFragment;
import com.tcs.basecode.fragment.StatisticsMainFragment;
import com.tcs.basecode.fragment.TrackingMainFragment;
import com.tcs.basecode.fragment.WeatherMainFragment;
import com.tcs.basecode.helpers.FragmentNavigationHelper;

/**
 * Created by Sneha Khadatare : 587823
 * on 5/19/2016.
 */
public abstract class NavigationDrawerActivity extends BaseActivity{


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


    public void goToManu(@DrawerMenu int drawerMenuPosition){

        Fragment fragment = null;

        switch (drawerMenuPosition){
            case HOME :

                fragment = HomeFragment.newInstance();

                break;

            case EVENTS :

                fragment = EventsMainFragment.newInstance();

                break;

            case TRACKING_AND_RESULTS :

                fragment = TrackingMainFragment.newInstance();

                break;

            case STATISTICS :

                fragment = StatisticsMainFragment.newInstance();

                break;

            case CHARITY :

                fragment = CharityMainFragment.newInstance();

                break;

            case SOCIAL_MEDIA :

                fragment = SocialMediaMainFragment.newInstance();

                break;

            case NEWS :

                fragment = NewsMainFragment.newInstance();

                break;

            case WEATHER :

                fragment = WeatherMainFragment.newInstance();

                break;

            case EXPO :

                fragment = ExpoMainFragment.newInstance();

                break;

            case INFO :

                fragment = InfoMainFragment.newInstance();

                break;

        }

        if (drawerMenuPosition == HOME) {
            FragmentNavigationHelper.navigateToHome(getSupportFragmentManager(), fragment);
        } else {
            FragmentNavigationHelper.navigateToDrawerItem(getSupportFragmentManager(), fragment);

        }


    }

}
