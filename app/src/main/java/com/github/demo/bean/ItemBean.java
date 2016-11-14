package com.github.demo.bean;

/**
 * Created by mzp on 2016/10/27.
 */

public class ItemBean
{
    private int id;
    private String title;

    public ItemBean(int id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public int getId()
    {
        return id;
    }

    public ItemBean setId(int id)
    {
        this.id = id;
        return this;
    }

    public String getTitle()
    {
        return title;
    }

    public ItemBean setTitle(String title)
    {
        this.title = title;
        return this;
    }
}
