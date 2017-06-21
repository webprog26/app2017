package com.androiddeveloper.webprog26.app2017.dagger;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.StartPresenter;
import com.androiddeveloper.webprog26.app2017.engine.StartPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 21.06.2017.
 */
@Module
public class StartPresenterModule {

    @Provides
    @NonNull
    @ActivityScope
    StartPresenter provideStartPresenter(){
        return new StartPresenterImpl();
    }

}
