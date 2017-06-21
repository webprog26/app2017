package com.androiddeveloper.webprog26.app2017.dagger.subcomponents;

import com.androiddeveloper.webprog26.app2017.StartActivity;
import com.androiddeveloper.webprog26.app2017.dagger.modules.StartPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by webpr on 21.06.2017.
 */
@Subcomponent(modules = {StartPresenterModule.class})
@ActivityScope
public interface StartPresenterSubcomponent {

    void inject(StartActivity target);
}
