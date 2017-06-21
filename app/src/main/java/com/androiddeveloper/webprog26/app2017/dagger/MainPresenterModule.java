package com.androiddeveloper.webprog26.app2017.dagger;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.MainPresenter;
import com.androiddeveloper.webprog26.app2017.engine.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 21.06.2017.
 */
@Module
public class MainPresenterModule {

    @Provides
    @NonNull
    @ActivityScope
    MainPresenter provideMainPresenter(){
        return new MainPresenterImpl();
    }

}
