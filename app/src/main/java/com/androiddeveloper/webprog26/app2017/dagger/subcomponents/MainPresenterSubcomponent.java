package com.androiddeveloper.webprog26.app2017.dagger.subcomponents;

import com.androiddeveloper.webprog26.app2017.MainActivity;
import com.androiddeveloper.webprog26.app2017.dagger.modules.MainPresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by webpr on 21.06.2017.
 */
@Subcomponent(modules = {MainPresenterModule.class})
@ActivityScope
public interface MainPresenterSubcomponent {

    void inject(MainActivity target);
}
