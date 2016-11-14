package com.github.demo.ui.adapter;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mzp on 2016/10/27.
 */

public class MultipleHeaderAndFooterRecyclerAdapter extends RecyclerView.Adapter
{
    public enum ITEM_TYPE
    {
        ITEM_TYPE_TEXT,
        ITEM_TYPE_HANDLER,
        ITEM_TYPE_FOOTER
    }

    private LayoutInflater layoutInflater;

    private String[] items;

    public MultipleHeaderAndFooterRecyclerAdapter(Context context)
    {
        items = context.getResources().getStringArray(R.array.titles);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (ITEM_TYPE.ITEM_TYPE_HANDLER.ordinal() == viewType)
        {
            return new MyHeaderViewHolder(layoutInflater.inflate(R.layout.item_header, parent, false));
        } else if (ITEM_TYPE.ITEM_TYPE_FOOTER.ordinal() == viewType)
        {
            return new MyFooterViewHolder(layoutInflater.inflate(R.layout.item_footer, parent, false));
        } else
        {
            return new MyTextViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof MyHeaderViewHolder)
        {
            ((MyHeaderViewHolder) holder).tv.setText(items[position]);
        } else if (holder instanceof MyFooterViewHolder)
        {
            ((MyFooterViewHolder) holder).tv.setText(items[position]);
        } else
        {
            ((MyTextViewHolder) holder).tv.setText(items[position]);
        }
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == 0)
        {
            return ITEM_TYPE.ITEM_TYPE_HANDLER.ordinal();
        } else if (items.length - 1 == position)
        {
            return ITEM_TYPE.ITEM_TYPE_FOOTER.ordinal();
        } else
        {
            return ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
        }
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

    class MyHeaderViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.my_tv)
        TextView tv;

        public MyHeaderViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MyFooterViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.my_tv)
        TextView tv;

        public MyFooterViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
