package com.androiddeveloper.webprog26.app2017.engine.listeners;

import com.androiddeveloper.webprog26.app2017.engine.view_pager_adapter.ViewPagerAdapter;

/**
 * Created by webpr on 22.06.2017.
 */

public class AppViewPagerListener extends ViewPagerListener {

    private final ViewPagerAdapter mViewPagerAdapter;

    public AppViewPagerListener(ViewPagerAdapter viewPagerAdapter) {
        this.mViewPagerAdapter = viewPagerAdapter;
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);

        if(position == 0){
            mViewPagerAdapter.changeControlsVisibility(true);
        } else {
            mViewPagerAdapter.changeControlsVisibility(false);
        }

        mViewPagerAdapter.notifyTitleChanged(position);
    }
}
