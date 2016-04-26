package com.tcs.basecode.fragment;

import android.support.v4.app.Fragment;

import butterknife.ButterKnife;

/**
 * Created by Sneha Khadatare : 587823
 * on 4/25/2016.
 */
public abstract class BaseFragment extends Fragment{

    @Override
    public void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    public abstract String getTitle();
}
