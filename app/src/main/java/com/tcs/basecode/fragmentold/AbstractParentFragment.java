package com.tcs.basecode.fragmentold;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcs.basecode.R;
import com.tcs.basecode.adapter.MyPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Sneha Khadatare : 587823
 * on 5/2/2016.
 */
public abstract class AbstractParentFragment extends BaseFragment{


    private ArrayList<Fragment> mFragmentList;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyPagerAdapter mAdapter;


    public ArrayList<Fragment> getFragmentList() {
        return mFragmentList;
    }

    public void setFragment_list(ArrayList<Fragment> fragmentList) {
        this.mFragmentList = fragmentList;
    }

    public TabLayout getTablayoutView(){
        return mTabLayout;
    }


    public ViewPager getViewPager(){
        return mViewPager;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeChildFragments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.parent_fragment_layout, container, false);

        setViewPager(view);

        return view;
    }

    public abstract void initializeChildFragments();


    public void setViewPager(View view){

        mAdapter = new MyPagerAdapter(getFragmentManager(),mFragmentList);
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(mFragmentList.size());
        mTabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewPager = null;
        mTabLayout = null;
        mAdapter = null;
    }


    @NonNull
    @Override
    public String getTitle() {
        return null;
    }
}
