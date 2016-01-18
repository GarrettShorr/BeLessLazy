package com.garrettshorr.belesslazy;

import java.util.Date;

/**
 * Created by gshorr on 1/17/16.
 */
public class ToDoItem {
    protected String mTitle;
    protected String mDescription;
    protected Date mDueDate;
    protected int mPriority;

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
}
