package com.tcs.basecode.utilities;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Sneha Khadatare : 587823
 * on 4/26/2016.
 */
public class GeneralUtils {

    public static void setToolbarStyle(Context context , ActionBar actionbar , int color , String title){

        actionbar.setTitle(title);
        actionbar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context , color)));

    }

    public static void changeHamburgderIcon(int color , Toolbar toolbar) {

        final PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        int count = toolbar.getChildCount();

        for (int i = 0; i <= toolbar.getChildCount(); i++) {
            final View v = toolbar.getChildAt(i);

            Log.d("", "View here @@ "+v);

            if (v instanceof ImageButton) {
                ((ImageButton) v).setColorFilter(colorFilter);
            }
        }
    }

}
