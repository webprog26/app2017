package com.androiddeveloper.webprog26.app2017.dagger.modules;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.dagger.scopes.ActivityScope;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.StartPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations.StartPresenterImpl;

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
