package com.androiddeveloper.webprog26.app2017.dagger;

import com.androiddeveloper.webprog26.app2017.engine.HandlingIntentFragmentPresenterImpl;
import com.androiddeveloper.webprog26.app2017.engine.StartFragment;
import com.androiddeveloper.webprog26.app2017.engine.StartFragmentEventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.StartFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.StartFragmentPresenterImpl;

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
