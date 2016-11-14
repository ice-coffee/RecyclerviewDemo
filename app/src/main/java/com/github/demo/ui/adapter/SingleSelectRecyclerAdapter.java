package com.github.demo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.github.demo.R;
import com.github.demo.bean.ItemSelectBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mzp on 2016/10/27.
 */

public class SingleSelectRecyclerAdapter extends RecyclerView.Adapter
{
    private LayoutInflater layoutInflater;

    private List<ItemSelectBean> itemSelectBeens;

    private RecyclerView mRv;

    private int selectedPosition = -1;

    public SingleSelectRecyclerAdapter(Context context, List<ItemSelectBean> itemSelectBeens, RecyclerView mRv)
    {
        this.itemSelectBeens = itemSelectBeens;
        this.mRv  = mRv;
        layoutInflater = LayoutInflater.from(context);

        //记录默认选项
        if (itemSelectBeens != null && itemSelectBeens.size() > 0)
        for (int i = 0; i < itemSelectBeens.size(); i++)
        {
            if (itemSelectBeens.get(i).isSelect())
            {
                selectedPosition = i;
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new SingleSelectViewHolder(layoutInflater.inflate(R.layout.item_single_select, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)
    {
        if (null != itemSelectBeens && itemSelectBeens.size() > position)
        {
            ((SingleSelectViewHolder)holder).tv.setText(itemSelectBeens.get(position).getTitle());
            ((SingleSelectViewHolder)holder).rbSelect.setChecked(itemSelectBeens.get(position).isSelect());

            ((SingleSelectViewHolder)holder).cvItem.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    SingleSelectViewHolder hadSelectedVH = (SingleSelectViewHolder) mRv.findViewHolderForLayoutPosition(selectedPosition);

                    //若已选item未显示在当前屏幕中, hadSelectedVH的值为空
                    if (hadSelectedVH != null)
                    {
                        hadSelectedVH.rbSelect.setChecked(false);
                    }

                    if (selectedPosition >= 0)
                    {
                        //修改数据源
                        itemSelectBeens.get(selectedPosition).setSelect(false);
                    }

                    //修改item勾选状态
                    selectedPosition = position;
                    itemSelectBeens.get(selectedPosition).setSelect(true);
                    ((SingleSelectViewHolder)holder).rbSelect.setChecked(true);
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return itemSelectBeens != null ? itemSelectBeens.size() : 0;
    }

    class SingleSelectViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.cv_item)
        CardView cvItem;
        @Bind(R.id.my_tv)
        TextView tv;
        @Bind(R.id.rb_select)
        RadioButton rbSelect;

        public SingleSelectViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
