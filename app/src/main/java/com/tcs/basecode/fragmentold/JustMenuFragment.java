package com.tcs.basecode.fragmentold;

import android.content.Context;
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
public class JustMenuFragment extends BaseFragment{

    public static final String SCREEN_NAME = "Just Menu";

    public static JustMenuFragment newInstance() {
        JustMenuFragment fragment = new JustMenuFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.just_menu_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("@@@@", "context "+context);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        Log.d("@@@@", "onCreateOptionsMenu: JustMenu");
        menu.clear();
        inflater.inflate(R.menu.justmenu , menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @NonNull
    @Override
    public String getTitle() {
        return SCREEN_NAME;
    }
}
