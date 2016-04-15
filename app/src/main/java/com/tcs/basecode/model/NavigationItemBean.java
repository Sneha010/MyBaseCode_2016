package com.tcs.basecode.model;

/**
 * Created by 587823 on 4/13/2016.
 */
public class NavigationItemBean {

    private String title;
    private boolean showNotify;
    private boolean isSelected;
    private boolean showSepLine;
    private int selectedImageResId;
    private int unSelectedImageResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUnSelectedImageResId() {
        return unSelectedImageResId;
    }

    public void setUnSelectedImageResId(int unSelectedImageResId) {
        this.unSelectedImageResId = unSelectedImageResId;
    }

    public int getSelectedImageResId() {
        return selectedImageResId;
    }

    public void setSelectedImageResId(int selectedImageResId) {
        this.selectedImageResId = selectedImageResId;
    }

    public boolean isShowSepLine() {
        return showSepLine;
    }

    public void setShowSepLine(boolean showSepLine) {
        this.showSepLine = showSepLine;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }
}
