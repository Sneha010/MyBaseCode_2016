package com.tcs.basecode.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcs.basecode.R;
import com.tcs.basecode.activity.MainActivity;
import com.tcs.basecode.utilities.GeneralUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends BaseFragment {


    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GeneralUtils.changeHamburgderIcon(getResources().getColor(R.color.white) ,
                ((MainActivity)getActivity()).getToolbar());

        GeneralUtils.setToolbarStyle(getActivity() , ((MainActivity) getActivity()).getMyActionBar() ,
                R.color.colorPrimary , getTitle());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_layout, container, false);
    }

    @Override
    public String getTitle() {
        return getResources().getString(R.string.second_frag_title);
    }
}
