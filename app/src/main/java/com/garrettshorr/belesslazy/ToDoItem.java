package com.garrettshorr.belesslazy;

import java.util.Date;

/**
 * Created by gshorr on 1/17/16.
 */
public class ToDoItem implements Comparable<ToDoItem> {
    protected String mTitle;
    protected String mDescription;
    protected Date mDueDate;
    protected int mPriority;

    public static final int NORMAL_PRIORITY = 0;
    public static final int HIGH_PRIORITY = 10;
    public static final int URGENT_PRIORITY = 100;
    public static final int IMMEDIATE_PRIORITY = 1000;
    public static final int LOW_PRIORITY = -10;
    public static final int VERY_LOW_PRIORITY = -100;


    public ToDoItem() {
        Date d = new Date();
        mTitle = "Item created on " + d.toString();
        mDescription = "Enter item description here.";
        mPriority = NORMAL_PRIORITY;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Date getDueDate() {
        return mDueDate;
    }

    public void setDueDate(Date dueDate) {
        mDueDate = dueDate;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public int compareTo(ToDoItem other)
    {
        if(this.mPriority == other.mPriority)
            return (int)(this.mDueDate.getTime() - other.mDueDate.getTime());
        return this.mPriority - other.mPriority;
    }
}
