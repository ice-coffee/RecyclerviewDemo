package com.github.demo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.demo.R;
import com.github.demo.ui.adapter.MultipleHeaderAndFooterRecyclerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mzp on 2016/10/28.
 */

public class MutipleHeadlerAndFooterFragment extends Fragment
{
    public final static int TYPE_LINEAR_LAYOUT = 1;
    public final static int TYPE_GRID_LAYOUT = 2;
    public final static int TYPE_STAG_LAYOUT = 3;

    private final static String TYPE = "type";

    private int defaultType = TYPE_LINEAR_LAYOUT;

    @Bind(R.id.rv_normal)
    RecyclerView rvNormal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            defaultType = getArguments().getInt(TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
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

        rvNormal.setAdapter(new MultipleHeaderAndFooterRecyclerAdapter(getActivity()));
    }

    public static MutipleHeadlerAndFooterFragment getInstance(int type)
    {
        MutipleHeadlerAndFooterFragment fragment = new MutipleHeadlerAndFooterFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
