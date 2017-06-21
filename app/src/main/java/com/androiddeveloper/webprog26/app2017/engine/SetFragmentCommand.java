package com.androiddeveloper.webprog26.app2017.engine;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by webpr on 21.06.2017.
 */

public abstract class SetFragmentCommand implements Command {

    private final FragmentManager fragmentManager;
    private final int containerViewId;

    public SetFragmentCommand(FragmentManager fragmentManager, int containerViewId) {
        this.fragmentManager = fragmentManager;
        this.containerViewId = containerViewId;
    }

    @NonNull
    protected FragmentManager getFragmentManager() {
        return fragmentManager;
    }


    public int getContainerViewId() {
        return containerViewId;
    }

    @NonNull
    protected abstract Fragment getFragment();

    @NonNull
    protected abstract String getTag();

}
