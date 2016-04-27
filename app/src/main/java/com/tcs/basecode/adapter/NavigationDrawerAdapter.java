package com.tcs.basecode.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tcs.basecode.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {

    List<String> navItemList = new ArrayList<String>();

    private LayoutInflater inflater;
    private Activity context;
    private int itemNumber;

    public NavigationDrawerAdapter(Activity context, List<String> navItemList) {
        this.context = context;
        this.navItemList = navItemList;
        inflater = LayoutInflater.from(context);
    }


    public void delete(int position) {
        navItemList.remove(position);
        notifyItemRemoved(position);
    }

    public void setPosition(int itemNumber) {
        this.itemNumber = itemNumber;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String currentItem = navItemList.get(position);
        holder.mNavTitle.setText(currentItem);
        holder.mNavTitle.setTextColor(context.getResources().getColor(R.color.white));


        if (position == itemNumber) {
            holder.mRlItemRow.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            holder.mNavTitle.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.mRlItemRow.setBackgroundColor(context.getResources().getColor(R.color.transparent));
            holder.mNavTitle.setTextColor(context.getResources().getColor(R.color.grey));

        }

        switch (position) {

            case 0: {
                holder.mNavImg.setImageResource(R.drawable.ic_action_one);
                holder.mSepLine.setVisibility(View.GONE);

                break;
            }
            case 1: {
                holder.mNavImg.setImageResource(R.drawable.ic_action_two);
                holder.mSepLine.setVisibility(View.GONE);
                break;
            }
            case 2: {
                holder.mNavImg.setImageResource(R.drawable.ic_action_three);
                holder.mSepLine.setVisibility(View.GONE);
                break;
            }
            case 3: {
                holder.mNavImg.setImageResource(R.drawable.ic_action_one);
                holder.mSepLine.setVisibility(View.GONE);
                break;
            }
            case 4: {
                holder.mNavImg.setImageResource(R.drawable.ic_action_two);
                holder.mSepLine.setVisibility(View.GONE);
                break;
            }
            case 5: {
                holder.mNavImg.setImageResource(R.drawable.ic_action_two);
                holder.mSepLine.setVisibility(View.VISIBLE);
                break;
            }
            case 6: {
                holder.mNavImg.setImageResource(R.drawable.ic_action_two);
                holder.mSepLine.setVisibility(View.GONE);
                break;
            }


        }


    }


    @Override
    public int getItemCount() {
        return navItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.navImg)
        ImageView mNavImg;

        @Bind(R.id.navTitle)
        TextView mNavTitle;

        @Bind(R.id.rlItem)
        RelativeLayout mRlItemRow;

        @Bind(R.id.sepLine)
        View mSepLine;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

