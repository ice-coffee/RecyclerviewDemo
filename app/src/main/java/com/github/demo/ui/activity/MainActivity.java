package com.github.demo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.demo.bean.ItemBean;
import com.github.demo.ui.adapter.MainItemsAdapter;
import com.github.demo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mzp on 2016/10/26.
 */

public class MainActivity extends AppCompatActivity
{
    @Bind(R.id.my_rec_view)
    RecyclerView myRecView;

    private List<ItemBean> itemBeanList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        myRecView.setLayoutManager(linearLayoutManager);
        myRecView.setAdapter(new MainItemsAdapter(this, itemBeanList));
    }

    /**
     * 获取数据源
     */
    private void initData()
    {
        List<String> items = Arrays.asList(getResources().getStringArray(R.array.items));
        int position = 0;
        for (String str : items)
        {
            itemBeanList.add(new ItemBean(position, str));
            position++;
        }
    }
}
