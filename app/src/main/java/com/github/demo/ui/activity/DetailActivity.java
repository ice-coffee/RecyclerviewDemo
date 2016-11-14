package com.github.demo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.demo.R;
import com.github.demo.ui.fragment.AnimFragment;
import com.github.demo.ui.fragment.MultipleFragment;
import com.github.demo.ui.fragment.MutipleHeadlerAndFooterFragment;
import com.github.demo.ui.fragment.NormalFragment;
import com.github.demo.ui.fragment.SingleSelectFragment;

/**
 * Created by mzp on 2016/10/27.
 */

public class DetailActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null)
        {
            int type = getIntent().getIntExtra("position", 0);

            upateFragment(type);
        }
    }

    private void upateFragment(int type)
    {
        if (type == 0)
        {
            updateNormalFragment(NormalFragment.TYPE_LINEAR_LAYOUT);
        } else if (type == 1)
        {
            updateNormalFragment(NormalFragment.TYPE_GRID_LAYOUT);
        } else if (type == 2)
        {
            updateNormalFragment(NormalFragment.TYPE_STAG_LAYOUT);
        }else if (type == 3)
        {
            updateMultipleFragment(MultipleFragment.TYPE_LINEAR_LAYOUT);
        } else if (type == 4)
        {
            updateMultipleFragment(MultipleFragment.TYPE_GRID_LAYOUT);
        }else if (type == 5)
        {
            updateMultipleHeaderFragment(MutipleHeadlerAndFooterFragment.TYPE_LINEAR_LAYOUT);
        }else if (type == 6)
        {
            updateAnimFragment(AnimFragment.TYPE_LINEAR_LAYOUT);
        }else if (type == 7)
        {
            updateAnimFragment(AnimFragment.TYPE_GRID_LAYOUT);
        } else if (type == 8)
        {
            updateSingleSelectFragment(SingleSelectFragment.TYPE_LINEAR_LAYOUT);
        }
    }

    private void updateNormalFragment(int type)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, NormalFragment.getInstance(type))
                .commit();
    }

    private void updateMultipleFragment(int type)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MultipleFragment.getInstance(type))
                .commit();
    }

    private void updateMultipleHeaderFragment(int type)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MutipleHeadlerAndFooterFragment.getInstance(type))
                .commit();
    }

    private void updateAnimFragment(int type)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, AnimFragment.getInstance(type))
                .commit();
    }

    private void updateSingleSelectFragment(int type)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, SingleSelectFragment.getInstance(type))
                .commit();
    }
}
