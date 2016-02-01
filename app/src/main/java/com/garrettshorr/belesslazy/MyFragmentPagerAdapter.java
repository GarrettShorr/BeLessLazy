package com.garrettshorr.belesslazy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by gshorr on 1/31/16.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragments;  //list to hold the fragments for the tabs

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> listFragments) {
        super(fm); //call to super must be first in constructor

        this.listFragments = listFragments; //initalize instance variable

    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);  //returns the fragment at position in the list
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
