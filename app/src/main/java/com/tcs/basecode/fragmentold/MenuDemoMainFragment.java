package com.tcs.basecode.fragmentold;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.tcs.basecode.R;
import com.tcs.basecode.activity.MainActivity;
import com.tcs.basecode.utilities.GeneralUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuDemoMainFragment extends AbstractParentFragment {


    public static MenuDemoMainFragment newInstance() {
        MenuDemoMainFragment fragment = new MenuDemoMainFragment();
        return fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpMyToolbar();
    }

    protected void setUpMyToolbar() {

        GeneralUtils.changeHamburgderIcon(getResources().getColor(R.color.white) ,
                ((MainActivity)getActivity()).getToolbar());

        GeneralUtils.setToolbarStyle(getActivity() , ((MainActivity) getActivity()).getMyActionBar() ,
                R.color.colorPrimary , getTitle());
    }


    @Override
    public void initializeChildFragments() {

        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

        fragmentList.add(JustMenuFragment.newInstance());
        fragmentList.add(PlaneFragment.newInstance());
        fragmentList.add(MenuWithItemsFragment.newInstance());


        setFragment_list(fragmentList);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        Log.d("@@@@", "onCreateOptionsMenu: MenuDemoMainFragment");
    }

    @Override
    public String getTitle() {
        return getResources().getString(R.string.frag_with_menu_demo_title);
    }


}
