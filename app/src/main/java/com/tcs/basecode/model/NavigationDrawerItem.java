package com.tcs.basecode.model;

/**
 * Created by Sneha Khadatare : 587823
 * on 5/19/2016.
 */
public class NavigationDrawerItem {

    private int mTag;
    private String mName;
    private int mIconDrawableSelected;
    private int mIconDrawableUnselected;
    private boolean mShowSepLine;
    private boolean mShowPushNotification;

    public static NavigationDrawerItem newInstance(){
        return new NavigationDrawerItem();
    }

    public NavigationDrawerItem withTag(int tag){
        mTag = tag;
        return this;
    }

    public int getTag() {
        return mTag;
    }

    public String getName() {
        return mName;
    }

    public NavigationDrawerItem withName(String name) {
        mName = name;
        return this;
    }

    public int getIconDrawableSelected() {
        return mIconDrawableSelected;
    }

    public NavigationDrawerItem setIconDrawableSelected(int iconDrawableSelected) {
        mIconDrawableSelected = iconDrawableSelected;
        return this;
    }

    public int getIconDrawableUnselected() {
        return mIconDrawableUnselected;
    }

    public NavigationDrawerItem setIconDrawableUnselected(int iconDrawableUnselected) {
        mIconDrawableUnselected = iconDrawableUnselected;
        return this;
    }

    public boolean isShowSepLine() {
        return mShowSepLine;
    }

    public NavigationDrawerItem setShowSepLine(boolean showSepLine) {
        mShowSepLine = showSepLine;
        return this;
    }

    public boolean isShowPushNotification() {
        return mShowPushNotification;
    }

    public NavigationDrawerItem setShowPushNotification(boolean notification) {
        mShowPushNotification = notification;
        return this;
    }
}
