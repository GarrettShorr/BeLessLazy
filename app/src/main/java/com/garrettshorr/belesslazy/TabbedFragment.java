package com.garrettshorr.belesslazy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gshorr on 1/27/16.
 */
public class TabbedFragment extends Fragment implements OnPageChangeListener, OnTabChangeListener {

    //These variables are used for the tab layout
    private ViewPager mViewPager;
    private TabHost mTabHost;
    private View mRootView; //instance variable so listener methods can access it

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_tabbed, container, false);


        //ViewPager Tabbed Layout Section
        mViewPager = (ViewPager) mRootView.findViewById(R.id.view_pager);


        //Create a list of the fragments you want in the tabs
        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new PlaceHolderFragment());
        listFragments.add(new PlaceHolderFragment2());
        listFragments.add(new PlaceHolderFragment3());


        //Create the ViewPager Adapter that will link the frags the tabs
        MyFragmentPagerAdapter pagerAdapter =
                new MyFragmentPagerAdapter(getFragmentManager(),listFragments);

        //set the pager's adapter
        mViewPager.setAdapter(pagerAdapter);
        //set the pager's listener
        mViewPager.setOnPageChangeListener(this);

        //TabHost Section
        mTabHost = (TabHost) mRootView.findViewById(R.id.tabHost);
        mTabHost.setup();

        //create that names for the tabs and apply them to the TabHost
        String[] tabNames = getResources().getStringArray(R.array.tab_names);
        for(int i = 0; i < tabNames.length; i++) {
            TabHost.TabSpec tabSpec;
            tabSpec = mTabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getActivity().getApplicationContext()));
            mTabHost.addTab(tabSpec);
        }
        //set the tabhost listener
        mTabHost.setOnTabChangedListener(this);


        return mRootView;
    }

    //************Listener Method Overrides ***********************//

    //TabHost Listener
    @Override
    public void onTabChanged(String tabId) {
        //figure out the current tab and set the pager to the appropriate item
        int selectedItem = mTabHost.getCurrentTab();
        mViewPager.setCurrentItem(selectedItem);

        //allow for the horizontal scrolling
        HorizontalScrollView hScrollView =
                (HorizontalScrollView) mRootView.findViewById(R.id.h_scroll_view);
        View tabView = mTabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft() -
                (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }

    //ViewPager Listener
    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        //switch the tab to match a page swipe
        mTabHost.setCurrentTab(selectedItem);

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    //Not sure exactly what this inner class does, but it's apparently needed for the tabhost
    public class FakeContent implements TabHost.TabContentFactory {

        Context context;

        public FakeContent(Context mContext) {
            context = mContext;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

}