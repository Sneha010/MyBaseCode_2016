package com.tcs.basecode.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcs.basecode.R;
import com.tcs.basecode.activity.MainActivity;
import com.tcs.basecode.helpers.FragmentNavigationHelper;
import com.tcs.basecode.utilities.GeneralUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleScreenDemoMainFragment extends BaseFragment {



    public static SingleScreenDemoMainFragment newInstance() {
        SingleScreenDemoMainFragment fragment = new SingleScreenDemoMainFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.single_screen_demo_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpMyToolbar();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.clickMeBtn)
    public void navigateMeToNewFrag(){

        FragmentNavigationHelper.navigateToNextScreen(getActivity().getSupportFragmentManager() ,
                NavigatedFragment.newInstance());

    }


    private void setUpMyToolbar() {

        GeneralUtils.changeHamburgderIcon(getResources().getColor(R.color.white),
                ((MainActivity) getActivity()).getToolbar());

        GeneralUtils.setToolbarStyle(getActivity(), ((MainActivity) getActivity()).getMyActionBar(),
                R.color.colorPrimary, getTitle());
    }


    @Override
    public String getTitle() {
        return getResources().getString(R.string.single_screen_demo_title);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
