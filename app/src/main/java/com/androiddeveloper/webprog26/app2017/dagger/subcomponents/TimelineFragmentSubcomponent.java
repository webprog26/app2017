package com.androiddeveloper.webprog26.app2017.dagger.subcomponents;

import com.androiddeveloper.webprog26.app2017.dagger.modules.TimelinePresenterModule;
import com.androiddeveloper.webprog26.app2017.dagger.scopes.FragmentScope;
import com.androiddeveloper.webprog26.app2017.engine.fragments.view_pager_fragments.TimelineFragment;

import dagger.Subcomponent;

/**
 * Created by webpr on 22.06.2017.
 */
@Subcomponent(modules = {TimelinePresenterModule.class})
@FragmentScope
public interface TimelineFragmentSubcomponent {

    void inject(TimelineFragment target);
}
