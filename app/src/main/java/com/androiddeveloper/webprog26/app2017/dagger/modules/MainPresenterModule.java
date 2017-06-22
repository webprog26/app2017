package com.androiddeveloper.webprog26.app2017.dagger.modules;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.androiddeveloper.webprog26.app2017.dagger.scopes.ActivityScope;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.MainPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations.MainPresenterImpl;
import com.androiddeveloper.webprog26.app2017.engine.view_pager_adapter.ViewPagerAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 21.06.2017.
 */
@Module
public class MainPresenterModule {

    private FragmentManager mFragmentManager;

    public MainPresenterModule(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Provides
    @NonNull
    @ActivityScope
    MainPresenter provideMainPresenter(){
        return new MainPresenterImpl();
    }

    @Provides
    @NonNull
    @ActivityScope
    ViewPagerAdapter provideViewPagerAdapter(){
        return new ViewPagerAdapter(getFragmentManager());
    }

    private FragmentManager getFragmentManager() {
        return mFragmentManager;
    }
}
