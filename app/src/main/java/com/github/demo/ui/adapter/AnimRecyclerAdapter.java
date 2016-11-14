package com.github.demo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.demo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mzp on 2016/10/27.
 */

public class AnimRecyclerAdapter extends RecyclerView.Adapter
{
    private LayoutInflater layoutInflater;

    private ArrayList<String> itemlist = new ArrayList<>();

    public AnimRecyclerAdapter(Context context)
    {
        String[] items = context.getResources().getStringArray(R.array.titles);
        for (String item : items)
        {
            itemlist.add(item);
        }

        layoutInflater = LayoutInflater.from(context);
    }

    private void remove(int position)
    {
        itemlist.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new NormalTextViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false), this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (null != itemlist && itemlist.size() > position)
        {
            ((NormalTextViewHolder)holder).tv.setText(itemlist.get(position));
        }
    }

    @Override
    public int getItemCount()
    {
        return itemlist != null ? itemlist.size() : 0;
    }

    class NormalTextViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.my_tv)
        TextView tv;

        private AnimRecyclerAdapter mAdapter;

        public NormalTextViewHolder(View itemView, AnimRecyclerAdapter mAdapter)
        {
            super(itemView);
            this.mAdapter = mAdapter;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void onItemClick()
        {
            Log.e("anim_layoutPosition", getLayoutPosition() + "");
            Log.e("anim_adapterPosition", getAdapterPosition() + "");

            this.mAdapter.remove(getLayoutPosition());
        }
    }
}
