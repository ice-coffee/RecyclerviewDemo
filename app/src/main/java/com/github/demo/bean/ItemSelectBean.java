package com.github.demo.bean;

/**
 * Created by mzp on 2016/10/27.
 */

public class ItemSelectBean
{
    private int id;
    private String title;
    private boolean isSelect;

    public ItemSelectBean(int id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public int getId()
    {
        return id;
    }

    public ItemSelectBean setId(int id)
    {
        this.id = id;
        return this;
    }

    public String getTitle()
    {
        return title;
    }

    public ItemSelectBean setTitle(String title)
    {
        this.title = title;
        return this;
    }

    public boolean isSelect()
    {
        return isSelect;
    }

    public ItemSelectBean setSelect(boolean select)
    {
        isSelect = select;
        return this;
    }
}
