package com.tcs.basecode.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tcs.basecode.R;
import com.tcs.basecode.model.NavigationItemBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {

    ArrayList<NavigationItemBean> data = new ArrayList<NavigationItemBean>();
    private LayoutInflater inflater;
    private Activity context;
    private int itemNumber;

    public NavigationDrawerAdapter(Activity context, ArrayList<NavigationItemBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }


    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void setPostion(int itemNumber) {
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
        NavigationItemBean current = data.get(position);
        holder.title.setText(current.getTitle());
        holder.title.setTextColor(context.getResources().getColor(R.color.white));


        if (position == itemNumber) {
            if (position != 14 && position != 15) {
                holder.rl_itemrow.setBackgroundColor(context.getResources().getColor(R.color.transGrey));
                holder.title.setTextColor(context.getResources().getColor(R.color.white));
            }
        } else {
            holder.rl_itemrow.setBackgroundColor(context.getResources().getColor(R.color.transparent));
            holder.title.setTextColor(context.getResources().getColor(R.color.white));

        }

        switch (position) {

            }


            }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.navTitle)
        TextView title;

        RelativeLayout rl_itemrow;
        ImageView imageView;
        ImageView switchPush;
        ProgressBar progPush;
        View line;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);

        }
    }
}

