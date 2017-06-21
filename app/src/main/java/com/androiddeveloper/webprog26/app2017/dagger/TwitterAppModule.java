package com.androiddeveloper.webprog26.app2017.dagger;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.TwitterApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by webpr on 21.06.2017.
 */
@Module
public class TwitterAppModule {

    @Provides
    @NonNull
    @Singleton
    TwitterApp provideTwitterApp(){
        return new TwitterApp();
    }
}
