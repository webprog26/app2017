package com.androiddeveloper.webprog26.app2017.dagger.subcomponents;

import com.androiddeveloper.webprog26.app2017.dagger.modules.StartFragmentPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.scopes.FragmentScope;
import com.androiddeveloper.webprog26.app2017.engine.fragments.StartFragment;

import dagger.Subcomponent;

/**
 * Created by webpr on 21.06.2017.
 */
@Subcomponent(modules = {StartFragmentPresenterModule.class})
@FragmentScope
public interface StartFragmentPresenterSubcomponent {

    void inject(StartFragment target);
//    void inject(StartFragmentPresenterImpl target);
}
