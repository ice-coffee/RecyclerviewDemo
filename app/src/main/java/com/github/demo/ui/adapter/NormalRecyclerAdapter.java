package com.github.demo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mzp on 2016/10/27.
 */

public class NormalRecyclerAdapter extends RecyclerView.Adapter
{
    private LayoutInflater layoutInflater;

    private String[] items;

    public NormalRecyclerAdapter(Context context)
    {
        items = context.getResources().getStringArray(R.array.titles);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new NormalTextViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (null != items && items.length > position)
        {
            ((NormalTextViewHolder)holder).tv.setText(items[position]);
        }
    }

    @Override
    public int getItemCount()
    {
        return items != null ? items.length : 0;
    }

    class NormalTextViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.my_tv)
        TextView tv;

        public NormalTextViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void onItemClick()
        {
            Log.e("normal_layoutPosition", getLayoutPosition() + "");
            Log.e("normal_adapterPosition", getAdapterPosition() + "");
        }
    }
}
