package com.tcs.basecode.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tcs.basecode.R;

/**
 * Created by Sneha Khadatare : 587823
 * on 4/27/2016.
 */
public class MenuWithItemsFragment extends BaseFragment{

    public static final String SCREEN_NAME = "Menu with Items";

    public static MenuWithItemsFragment newInstance(){
        MenuWithItemsFragment fragment = new MenuWithItemsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_with_item_layout , container , false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_with_item , menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){

            case R.id.item1:
                Log.d("@@@@", "2015");
                break;

            case R.id.item2:
                Log.d("@@@@", "2014");
                break;

            case R.id.item3:
                Log.d("@@@@", "2013");
                break;

            case R.id.item4:
                Log.d("@@@@", "2012");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public String getTitle() {
        return SCREEN_NAME;
    }
}
