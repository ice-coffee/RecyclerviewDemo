package com.github.demo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.demo.R;
import com.github.demo.bean.ItemSelectBean;
import com.github.demo.ui.adapter.NormalRecyclerAdapter;
import com.github.demo.ui.adapter.SingleSelectRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mzp on 2016/10/27.
 */

public class SingleSelectFragment extends Fragment
{
    public final static int TYPE_LINEAR_LAYOUT = 1;
    public final static int TYPE_GRID_LAYOUT = 2;
    public final static int TYPE_STAG_LAYOUT = 3;

    private final static String TYPE = "type";

    private int defaultType = TYPE_LINEAR_LAYOUT;
    @Bind(R.id.rv_normal)
    RecyclerView rvNormal;

    private List<ItemSelectBean> itemSelectBeens;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            defaultType = getArguments().getInt(TYPE);
        }

        //初始化数据源, 默认单选为第一项
        itemSelectBeens = new ArrayList<>();
        String[] items = getActivity().getResources().getStringArray(R.array.titles);

        int position = 0;
        for (String item : items)
        {
            ItemSelectBean itemSelectBean = new ItemSelectBean(position, item);
            if (position == 0)
            {
                itemSelectBean.setSelect(true);
            }
            else
            {
                itemSelectBean.setSelect(false);
            }

            itemSelectBeens.add(itemSelectBean);

            position++;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        if (TYPE_GRID_LAYOUT == defaultType)
        {
            rvNormal.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else if (TYPE_STAG_LAYOUT == defaultType)
        {
            rvNormal.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        } else
        {
            rvNormal.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        rvNormal.setAdapter(new SingleSelectRecyclerAdapter(getActivity(), itemSelectBeens, rvNormal));
        rvNormal.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public static SingleSelectFragment getInstance(int type)
    {
        SingleSelectFragment fragment = new SingleSelectFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragment.setArguments(bundle);

        return fragment;
    }
}
