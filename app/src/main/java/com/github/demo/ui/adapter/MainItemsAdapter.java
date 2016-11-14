package com.github.demo.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.demo.R;
import com.github.demo.bean.ItemBean;
import com.github.demo.ui.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mzp on 2016/10/27.
 */

public class MainItemsAdapter extends RecyclerView.Adapter
{
    public Context context;

    private List<ItemBean> items = new ArrayList<>();

    private LayoutInflater mLayoutInflater;

    public MainItemsAdapter(Context context, List<ItemBean> items)
    {
        this.items = items;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false), this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (null != items && items.size() > 0)
        {
            ((NormalTextViewHolder)holder).myTv.setText(items.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount()
    {
        return items != null ? items.size() : 0;
    }


    class NormalTextViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.my_tv)
        TextView myTv;

        private MainItemsAdapter mAdapter;

        public NormalTextViewHolder(View itemView, MainItemsAdapter mAdapter)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.mAdapter = mAdapter;
        }

        /*item点击事件*/
        @OnClick(R.id.cv_item)
        void onItemsClick()
        {
            Intent intent = new Intent(this.mAdapter.context, DetailActivity.class);
            intent.putExtra("position", getLayoutPosition());
            this.mAdapter.context.startActivity(intent);
        }
    }
}
