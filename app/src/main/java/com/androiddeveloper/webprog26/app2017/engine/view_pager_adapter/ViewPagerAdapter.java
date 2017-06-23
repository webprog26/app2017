package com.androiddeveloper.webprog26.app2017.engine.view_pager_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.androiddeveloper.webprog26.app2017.engine.fragments.BaseFragment;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;

import java.util.ArrayList;

/**
 * Created by webpr on 22.06.2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter implements FragmentsAppender, TitleSubscriber, ControlsVisibilityChanger{

    private final ArrayList<BaseFragment> fragments = new ArrayList<>();
    private final ArrayList<String> fragmentsTitles = new ArrayList<>();

    private MainView mainView;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void append(BaseFragment fragment, String title) {
        fragments.add(fragment);
        fragmentsTitles.add(title);
    }

    @Override
    public void subscribe(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void notifyTitleChanged(int position) {

        if(isMainViewExists()){
            mainView.setTitle(fragmentsTitles.get(position));
        }
    }

    @Override
    public void changeControlsVisibility(boolean state) {
        if(isMainViewExists()){
            mainView.setControls(state);
        }
    }

    private boolean isMainViewExists(){
        return mainView != null;
    }
}
