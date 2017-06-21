package com.androiddeveloper.webprog26.app2017.dagger.modules;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.engine.twitter_app.TwitterApp;
import com.androiddeveloper.webprog26.app2017.engine.twitter_app.TwitterGetter;

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
    TwitterGetter provideTwitterGetter(){
        return new TwitterApp();
    }
}
