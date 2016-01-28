package com.garrettshorr.belesslazy;

import java.util.Date;

/**
 * Created by gshorr on 1/17/16.
 */
public class RecurringToDoItem extends ToDoItem {
    private Date mStartDate;
    private int mRecurrenceFrequency;

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public int getRecurrenceFrequency() {
        return mRecurrenceFrequency;
    }

    public void setRecurrenceFrequency(int recurrenceFrequency) {
        mRecurrenceFrequency = recurrenceFrequency;
    }
}

