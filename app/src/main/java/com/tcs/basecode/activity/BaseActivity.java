package com.tcs.basecode.activity;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by 587823 on 4/12/2016.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
