package com.tcs.basecode.fragmentold;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcs.basecode.R;

/**
 * Created by Sneha Khadatare : 587823
 * on 4/27/2016.
 */
public class PlaneFragment extends BaseFragment{

    public static final String SCREEN_NAME = "Plane bhcgchgcfcfcfc";

    public static PlaneFragment newInstance(){
        PlaneFragment fragment = new PlaneFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.plane_frag_layout , container , false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();

        super.onCreateOptionsMenu(menu, inflater);

        Log.d("@@@@", "onCreateOptionsMenu: PlaneFragment");
    }

    @NonNull
    @Override
    public String getTitle() {
        return SCREEN_NAME;
    }
}
