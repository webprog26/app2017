package com.androiddeveloper.webprog26.app2017.dagger.subcomponents;

import com.androiddeveloper.webprog26.app2017.dagger.modules.HandlingIntentPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.scopes.FragmentScope;
import com.androiddeveloper.webprog26.app2017.engine.fragments.HandlingIntentFragment;

import dagger.Subcomponent;

/**
 * Created by webpr on 21.06.2017.
 */
@Subcomponent(modules = {HandlingIntentPresenterModule.class})
@FragmentScope
public interface HandlingIntentFragmentPresenterSubcomponent {

    void inject(HandlingIntentFragment target);
}
