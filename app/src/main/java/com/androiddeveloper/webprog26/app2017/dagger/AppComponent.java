package com.androiddeveloper.webprog26.app2017.dagger;

import com.androiddeveloper.webprog26.app2017.dagger.modules.AppModule;
import com.androiddeveloper.webprog26.app2017.dagger.modules.HandlingIntentPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.modules.MainPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.modules.StartFragmentPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.modules.StartPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.modules.TwitterAppModule;
import com.androiddeveloper.webprog26.app2017.dagger.subcomponents.HandlingIntentFragmentPresenterSubcomponent;
import com.androiddeveloper.webprog26.app2017.dagger.subcomponents.MainPresenterSubcomponent;
import com.androiddeveloper.webprog26.app2017.dagger.subcomponents.StartFragmentPresenterSubcomponent;
import com.androiddeveloper.webprog26.app2017.dagger.subcomponents.StartPresenterSubcomponent;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations.HandlingIntentFragmentPresenterImpl;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations.StartFragmentPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by webpr on 21.06.2017.
 */
@Component(modules = {AppModule.class, TwitterAppModule.class})
@Singleton
public interface AppComponent {

    StartPresenterSubcomponent plus(StartPresenterModule module);

    MainPresenterSubcomponent plus(MainPresenterModule module);

    StartFragmentPresenterSubcomponent plus(StartFragmentPresenterModule module);
    HandlingIntentFragmentPresenterSubcomponent plus(HandlingIntentPresenterModule module);

    void inject(StartFragmentPresenterImpl target);
    void inject(HandlingIntentFragmentPresenterImpl target);
}
