package com.tcs.basecode.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tcs.basecode.fragment.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Sneha Khadatare : 587823
 * on 5/2/2016.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragmentList;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ((BaseFragment)fragmentList.get(position)).getTitle();
    }
}
