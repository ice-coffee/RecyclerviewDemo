package com.github.demo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.demo.R;
import com.github.demo.ui.adapter.AnimRecyclerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mzp on 2016/10/27.
 * Recyclerview 的删除操作并不需要什么特别的操作, 调用notifyItemRemoved(position);后自动动画
 */

public class AnimFragment extends Fragment
{
    public final static int TYPE_LINEAR_LAYOUT = 1;
    public final static int TYPE_GRID_LAYOUT = 2;

    private final static String TYPE = "type";

    private int defaultType = TYPE_LINEAR_LAYOUT;
    @Bind(R.id.rv_normal)
    RecyclerView rvNormal;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            defaultType = getArguments().getInt(TYPE);
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
        }else
        {
            rvNormal.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        rvNormal.setAdapter(new AnimRecyclerAdapter(getActivity()));
        rvNormal.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public static AnimFragment getInstance(int type)
    {
        AnimFragment fragment = new AnimFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragment.setArguments(bundle);

        return fragment;
    }
}
