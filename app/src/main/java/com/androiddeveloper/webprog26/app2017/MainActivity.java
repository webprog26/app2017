package com.androiddeveloper.webprog26.app2017;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.dagger.modules.MainPresenterModule;
import com.androiddeveloper.webprog26.app2017.engine.fragments.view_pager_fragments.AndroidFragment;
import com.androiddeveloper.webprog26.app2017.engine.fragments.view_pager_fragments.MapFragment;
import com.androiddeveloper.webprog26.app2017.engine.fragments.view_pager_fragments.ProfileFragment;
import com.androiddeveloper.webprog26.app2017.engine.fragments.view_pager_fragments.TimelineFragment;
import com.androiddeveloper.webprog26.app2017.engine.listeners.AppViewPagerListener;
import com.androiddeveloper.webprog26.app2017.engine.listeners.TimelineModeClickListener;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.MainPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;
import com.androiddeveloper.webprog26.app2017.engine.view_pager_adapter.ViewPagerAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView{

    private static final String TAG = "MainActivity_TAG";

    private final int[] tabsIconsDrawablesIndices = new int[]{
        R.drawable.ic_list_white_24dp,
        R.drawable.ic_person_white_24dp,
        R.drawable.ic_place_white_24dp,
        R.drawable.ic_android_white_24dp
    };

    private final int[] pagesTitlesIndices = new int[]{
            R.string.timeline,
            R.string.profile,
            R.string.map,
            R.string.android
    };

    @Inject
    MainPresenter mainPresenter;

    @Inject
    ViewPagerAdapter mViewPagerAdapter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.tv_page_title)
    TextView mTvPageTitle;

    @BindView(R.id.ib_timeline_mode)
    ImageButton mIbTimelineMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter.setView(this);

        setupViewPager();

        getViewPager().addOnPageChangeListener(new AppViewPagerListener(getViewPagerAdapter()));

        getTabLayout().setupWithViewPager(getViewPager(), true);

        setSupportActionBar(getToolbar());

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initTabLayoutWithTabs();

        mViewPagerAdapter.notifyTitleChanged(getTabLayout().getSelectedTabPosition());

        getIbTimelineMode().setOnClickListener(new TimelineModeClickListener(mainPresenter, getResources()));
    }

    @Override
    protected void setupActivityComponent() {
        App.getAppComponent().plus(new MainPresenterModule(getSupportFragmentManager())).inject(this);
    }

    @NonNull
    @Override
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }


    @Override
    public void backToStartActivity() {
        startActivity(new Intent(MainActivity.this, StartActivity.class));
        finish();
    }

    @Override
    public void setControls(boolean state) {
        getIbTimelineMode().setVisibility(state ? View.VISIBLE: View.GONE);
    }

    @Override
    public void setTitle(String title) {
        
        getTvPageTitle().setText(title);
    }

    private Toolbar getToolbar() {
        return mToolbar;
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    private void setupViewPager(){
        ViewPagerAdapter adapter = getViewPagerAdapter();

        adapter.subscribe(this);

        adapter.append(new TimelineFragment(), getString(pagesTitlesIndices[0]));
        adapter.append(new ProfileFragment(), getString(pagesTitlesIndices[1]));
        adapter.append(new MapFragment(), getString(pagesTitlesIndices[2]));
        adapter.append(new AndroidFragment(), getString(pagesTitlesIndices[3]));

        getViewPager().setAdapter(adapter);
    }

    private void initTabLayoutWithTabs(){
        TabLayout tabLayout = getTabLayout();

        tabLayout.getTabAt(0).setIcon(tabsIconsDrawablesIndices[0]);
        tabLayout.getTabAt(1).setIcon(tabsIconsDrawablesIndices[1]);
        tabLayout.getTabAt(2).setIcon(tabsIconsDrawablesIndices[2]);
        tabLayout.getTabAt(3).setIcon(tabsIconsDrawablesIndices[3]);
    }

    private ViewPagerAdapter getViewPagerAdapter() {
        return mViewPagerAdapter;
    }

    private TextView getTvPageTitle() {
        return mTvPageTitle;
    }

    private ImageButton getIbTimelineMode() {
        return mIbTimelineMode;
    }
}
