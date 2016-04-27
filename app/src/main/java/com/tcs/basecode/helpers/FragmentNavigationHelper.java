package com.tcs.basecode.helpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.tcs.basecode.R;
import com.tcs.basecode.utilities.Constants;

/**
 * Created by Sneha Khadatare : 587823
 * on 4/25/2016.
 */
public class FragmentNavigationHelper {

    public static void navigateToHome(FragmentManager fragmentManager , Fragment fragment ){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentManager.popBackStack(Constants.HOME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentTransaction.add(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(Constants.HOME);
        fragmentTransaction.commit();
    }

    public static void navigateToDrawerItem(FragmentManager fragmentManager , Fragment fragment){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentManager.popBackStack(Constants.HOME , 0);
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void navigateToNextScreen(FragmentManager fragmentManager , Fragment fragment){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}
