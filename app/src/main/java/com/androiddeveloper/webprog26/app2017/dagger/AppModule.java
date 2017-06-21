package com.androiddeveloper.webprog26.app2017.dagger;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 21.06.2017.
 */
@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @NonNull
    @Singleton
    Context provideAppContext(){
        return appContext;
    }


}
