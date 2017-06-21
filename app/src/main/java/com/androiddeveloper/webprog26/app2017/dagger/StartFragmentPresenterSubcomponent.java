package com.androiddeveloper.webprog26.app2017.dagger;

import com.androiddeveloper.webprog26.app2017.engine.StartFragment;
import com.androiddeveloper.webprog26.app2017.engine.StartFragmentEventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.StartFragmentPresenterImpl;

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
