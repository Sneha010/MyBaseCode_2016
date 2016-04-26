package com.tcs.basecode.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcs.basecode.R;
import com.tcs.basecode.activity.MainActivity;
import com.tcs.basecode.utilities.GeneralUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment {

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GeneralUtils.setToolbarStyle(getActivity() , ((MainActivity) getActivity()).getMyActionBar() ,
                R.color.transparent , getTitle());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onResume() {
        super.onResume();
        GeneralUtils.changeHamburgderIcon(getResources().getColor(R.color.colorAccent) ,
                ((MainActivity)getActivity()).getToolbar());

    }


    @Override
    public String getTitle() {
        return "";
    }

}
