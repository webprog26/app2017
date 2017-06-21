package com.androiddeveloper.webprog26.app2017.dagger;

import com.androiddeveloper.webprog26.app2017.MainActivity;

import dagger.Subcomponent;

/**
 * Created by webpr on 21.06.2017.
 */
@Subcomponent(modules = {MainPresenterModule.class})
@ActivityScope
public interface MainPresenterSubcomponent {

    void inject(MainActivity target);
}
