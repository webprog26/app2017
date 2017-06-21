package com.androiddeveloper.webprog26.app2017.dagger;

import com.androiddeveloper.webprog26.app2017.engine.HandlingIntentFragment;

import dagger.Subcomponent;

/**
 * Created by webpr on 21.06.2017.
 */
@Subcomponent(modules = {HandlingIntentPresenterModule.class})
@FragmentScope
public interface HandlingIntentFragmentPresenterSubcomponent {

    void inject(HandlingIntentFragment target);
}
