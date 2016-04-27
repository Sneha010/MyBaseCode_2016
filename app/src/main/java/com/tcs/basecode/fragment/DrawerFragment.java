package com.tcs.basecode.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tcs.basecode.R;
import com.tcs.basecode.adapter.NavigationDrawerAdapter;
import com.tcs.basecode.widget.RecyclerViewItemTouchListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DrawerFragment extends Fragment {


    @Bind(R.id.rlHeaderView)
    RelativeLayout mRlHeaderView;

    @Bind(R.id.drawerList)
    RecyclerView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter mAdapter;
    private View mNavigationDrawerView;

    private FragmentDrawerListener drawerListener;
    private int menuvalue = 0;
    private int mLastSelectedPosition = 0;

    public DrawerFragment() {

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, layout);

        return layout;
    }

    public void initialiseNavigationItems(List<String> itemList) {
        mAdapter = new NavigationDrawerAdapter(getActivity(), itemList);

        mDrawerList.setAdapter(mAdapter);
        mDrawerList.setLayoutManager(new LinearLayoutManager(getActivity()));

        mDrawerList.addOnItemTouchListener(new RecyclerViewItemTouchListener(getActivity(), new RecyclerViewItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position != 4) {

                    if (position != mLastSelectedPosition) {
                        drawerListener.onDrawerItemSelected(view, position);
                        updateItemPosition(position);
                    }
                    mDrawerLayout.closeDrawer(mNavigationDrawerView);

                }
                mLastSelectedPosition = position;
            }
        }));


    }

    public void setUpDrawerToggle(View navigationView, DrawerLayout drawerLayout, final Toolbar toolbar) {
        mNavigationDrawerView = navigationView;
        mDrawerLayout = drawerLayout;

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
                mDrawerList.smoothScrollToPosition(menuvalue);

            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    public void updateItemPosition(int position) {
        mAdapter.setPosition(position);
        mAdapter.notifyDataSetChanged();
        menuvalue = position;
    }


    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }
}