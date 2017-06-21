package com.androiddeveloper.webprog26.app2017.dagger;

import android.app.Application;

/**
 * Created by webpr on 21.06.2017.
 */

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildAppComponent();
    }

    @SuppressWarnings("deprecation")
    protected AppComponent buildAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }
}
