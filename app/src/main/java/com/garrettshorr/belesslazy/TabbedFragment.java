package com.garrettshorr.belesslazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gshorr on 1/27/16.
 */
public class TabbedFragment extends Fragment {

    //These variables are used for the tab layout
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);

        //ViewPager Tabbed Layout Section
        viewPager = (ViewPager) rootView.findViewById(R.id.pager);


        //Create a list of the fragments you want in the tabs
        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new PlaceHolderFragment());
        listFragments.add(new PlaceHolderFragment2());
        listFragments.add(new PlaceHolderFragment3());


        //Create the ViewPager Adapter that will link the frags the tabs
        MyFragmentPagerAdapter pagerAdapter =
                new MyFragmentPagerAdapter(getFragmentManager(),listFragments);

        //set the pager's adapter
        viewPager.setAdapter(pagerAdapter);



        return rootView;
    }
}