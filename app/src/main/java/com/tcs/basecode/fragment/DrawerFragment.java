package com.tcs.basecode.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tcs.basecode.R;
import com.tcs.basecode.adapter.NavigationDrawerAdapter;
import com.tcs.basecode.model.NavigationItemBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DrawerFragment extends BaseFragment {


    @Bind(R.id.rlHeaderView)
    RelativeLayout mRlHeaderView;

    @Bind(R.id.drawerList)
    RecyclerView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter mAdapter;
    private View mNavigationDrawerView;
    private static String[] titles = null;
    private FragmentDrawerListener drawerListener;
    private int menuvalue = 0;

    public DrawerFragment() {

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public static List<NavigationItemBean> getNavigationItemList() {
        List<NavigationItemBean> itemList = new ArrayList<NavigationItemBean>();

        // preparing navigation drawer items
        for (int i = 0; i < titles.length; i++) {
            NavigationItemBean navItem = new NavigationItemBean();
            navItem.setTitle(titles[i]);
            itemList.add(navItem);
        }
        return itemList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // drawer labels
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, layout);

        prepareNavItemList();

        return layout;
    }

    private void prepareNavItemList() {
        mAdapter = new NavigationDrawerAdapter(getActivity(), getNavigationItemList());

        mDrawerList.setAdapter(mAdapter);
        mDrawerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDrawerList.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mDrawerList, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(position != 3){
                    drawerListener.onDrawerItemSelected(view, position);
                    mDrawerLayout.closeDrawer(mNavigationDrawerView);
                    updateItemPosition(position);
                }

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        mNavigationDrawerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //MainActivity.shouldGoInvisible=true;
                // Util.hideKeyboard(getActivity());
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //MainActivity.shouldGoInvisible=false;
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
                mDrawerList.smoothScrollToPosition(menuvalue);

            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
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

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }

    public void updateItemPosition(int position) {
        mAdapter.setPostion(position);
        mAdapter.notifyDataSetChanged();
        menuvalue = position;
    }

    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position);
    }
}