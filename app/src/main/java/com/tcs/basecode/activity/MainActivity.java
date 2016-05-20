package com.tcs.basecode.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.tcs.basecode.R;
import com.tcs.basecode.fragmentold.DrawerFragment;
import com.tcs.basecode.fragmentold.HomeFragment;
import com.tcs.basecode.fragmentold.MenuDemoMainFragment;
import com.tcs.basecode.fragmentold.MixedMainFragment;
import com.tcs.basecode.fragmentold.SingleScreenDemoMainFragment;
import com.tcs.basecode.fragmentold.WebviewMultipleTabsDemoMainFragment;
import com.tcs.basecode.fragmentold.WebviewSingleScreenDemoFragment;
import com.tcs.basecode.helpers.FragmentNavigationHelper;
import com.tcs.basecode.utilities.GeneralUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends NavigationDrawerActivity implements DrawerFragment.FragmentDrawerListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.main_container)
    FrameLayout contentBody;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Bind(R.id.navigationDrawerFragment)
    View navigationDrawerFragment;

    public ActionBar getMyActionBar() {
        return getSupportActionBar();
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    private DrawerFragment mDrawerFragment;
    private String[] mNavigationItemNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        setUpDrawer();

        displayItemContent(0);

        addFragmentBackstackListener();

    }


    private void setUpDrawer() {

        mNavigationItemNames = getResources().getStringArray(R.array.nav_drawer_labels);

        mDrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigationDrawerFragment);
        mDrawerFragment.initialiseNavigationItems(getNavigationItemList());
        mDrawerFragment.setUpDrawerToggle(navigationDrawerFragment, drawerLayout, toolbar);

        mDrawerFragment.setDrawerListener(this);

    }

    private List<String> getNavigationItemList() {
        List<String> itemList = new ArrayList<String>();

        // preparing navigation drawer items
        for (int i = 0; i < mNavigationItemNames.length; i++) {

            itemList.add(mNavigationItemNames[i]);
        }
        return itemList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                onBackPressed();


                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayItemContent(int currentItemPosition) {

        Fragment fragment = null;

        String title = getString(R.string.app_name);

       /* Util.displayCustomToast(this, position + "");*/
        switch (currentItemPosition) {

            case 0:

                fragment = HomeFragment.newInstance();
                //goToManu(currentItemPosition);

                break;

            case 1:

                fragment = MenuDemoMainFragment.newInstance();

                break;

            case 2:

                fragment = SingleScreenDemoMainFragment.newInstance();

                break;

            case 3:

                fragment = WebviewMultipleTabsDemoMainFragment.newInstance();

                break;

            case 4:

                fragment = WebviewSingleScreenDemoFragment.newInstance();

                break;

            case 5:

                fragment = MixedMainFragment.newInstance();

                break;
        }

        mDrawerFragment.updateItemPosition(currentItemPosition);

        if (currentItemPosition == 0) {
            FragmentNavigationHelper.navigateToHome(getSupportFragmentManager(), fragment);
        } else {
            FragmentNavigationHelper.navigateToDrawerItem(getSupportFragmentManager(), fragment);

        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayItemContent(position);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(navigationDrawerFragment);

        } else {

            int count = getSupportFragmentManager().getBackStackEntryCount();
            Log.d("", "@@!! Count" + count);
            if (count > 1) {
                if (count == 2) {

                    mDrawerFragment.updateItemPosition(0);
                    getSupportFragmentManager().popBackStackImmediate();
                    GeneralUtils.setToolbarStyle(MainActivity.this, getSupportActionBar(),
                            R.color.transparent, "");

                } else {
                    getSupportFragmentManager().popBackStack();
                }

            } else {
                Log.d("", "@@!! Count Inside Super call" + count);
                finish();

            }
        }

    }
    private void addFragmentBackstackListener() {
       getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
           @Override
           public void onBackStackChanged() {
               int count = getSupportFragmentManager().getBackStackEntryCount();

               if (count <= 2) {

                   //Show hamburger  : order of following method is vital
                   getMyActionBar().setDisplayHomeAsUpEnabled(false);
                   mDrawerFragment.enableDrawerHamburger(true);
               }else{
                   // show back button  : order of following method is vital
                   mDrawerFragment.enableDrawerHamburger(false);
                   getMyActionBar().setDisplayHomeAsUpEnabled(true);
               }
           }
       });

        setBackNavigationListener();


    }

    private void setBackNavigationListener() {
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });
    }


    @SuppressWarnings("unused")
    @OnClick(R.id.main_container)
    public void clickMe() {


    }
}
