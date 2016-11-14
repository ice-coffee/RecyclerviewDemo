package com.github.demo.ui.adapter;

import android.content.Context;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.demo.R;
import com.github.demo.ui.fragment.MultipleFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mzp on 2016/10/27.
 */

public class MultipleRecyclerAdapter extends RecyclerView.Adapter
{
    public enum ITEM_TYPE
    {
        ITEM_TYPE_TEXT,
        ITEM_TYPE_IMAGE
    }

    private LayoutInflater layoutInflater;

    private String[] items;

    public MultipleRecyclerAdapter(Context context)
    {
        items = context.getResources().getStringArray(R.array.titles);

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() == viewType)
        {
            return new MyImageViewHolder(layoutInflater.inflate(R.layout.item_image, parent, false), this);
        }else
        {
            return new MyTextViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof MyTextViewHolder)
        {
            ((MyTextViewHolder) holder).tv.setText(items[position]);
        }else
        {
            ((MyImageViewHolder) holder).tv.setText(items[position]);
        }
    }

    @Override
    public int getItemViewType(int position)
    {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    @Override
    public int getItemCount()
    {
        return items != null ? items.length : 0;
    }

    class MyTextViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.my_tv)
        TextView tv;

        public MyTextViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MyImageViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.text_view)
        TextView tv;

        @Bind(R.id.image_view)
        ImageView iv;

        private MultipleRecyclerAdapter mAdapter;

        public MyImageViewHolder(View itemView, MultipleRecyclerAdapter mAdapter)
        {
            super(itemView);
            this.mAdapter = mAdapter;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void onItemClick()
        {
            Log.e("multip_layoutPosition", getLayoutPosition() + "");
            Log.e("multip_adapterPosition", getAdapterPosition() + "");
        }
    }
}
