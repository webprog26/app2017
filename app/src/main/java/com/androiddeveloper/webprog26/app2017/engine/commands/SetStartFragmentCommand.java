package com.androiddeveloper.webprog26.app2017.engine.commands;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.androiddeveloper.webprog26.app2017.engine.fragments.StartFragment;

/**
 * Created by webpr on 21.06.2017.
 */

public class SetStartFragmentCommand extends SetFragmentCommand {

    private final static String START_FRAGMENT_TAG = "start_fragment_tag";

    public SetStartFragmentCommand(FragmentManager fragmentManager, int containerViewId) {
        super(fragmentManager, containerViewId);
    }

    @Override
    public void execute() {
        FragmentManager fragmentManager = getFragmentManager();

        StartFragment startFragment = (StartFragment) fragmentManager.findFragmentByTag(getTag());

        if(startFragment == null){

            fragmentManager.beginTransaction().add(getContainerViewId(), getFragment(), getTag()).commit();
        } else {
            fragmentManager.beginTransaction().replace(getContainerViewId(), getFragment(), getTag()).commit();
        }

    }

    @NonNull
    @Override
    protected String getTag() {
        return START_FRAGMENT_TAG;
    }

    @NonNull
    @Override
    protected Fragment getFragment() {
        return new StartFragment();
    }
}
