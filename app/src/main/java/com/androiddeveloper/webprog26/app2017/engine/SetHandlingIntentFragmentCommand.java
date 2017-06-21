package com.androiddeveloper.webprog26.app2017.engine;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by webpr on 21.06.2017.
 */

public class SetHandlingIntentFragmentCommand extends SetFragmentCommand {

    private static final String HANDLING_INTENT_FRAGMENT_TAG = "handling_intent_fragment_tag";

    private final Uri receivedUri;

    public SetHandlingIntentFragmentCommand(FragmentManager fragmentManager, int containerViewId, final Uri receivedUri) {
        super(fragmentManager, containerViewId);
        this.receivedUri = receivedUri;
    }

    @Override
    public void execute() {
        FragmentManager fragmentManager = getFragmentManager();

        HandlingIntentFragment handlingIntentFragment = (HandlingIntentFragment) fragmentManager.findFragmentByTag(getTag());

        if(handlingIntentFragment == null){
            fragmentManager.beginTransaction().add(getContainerViewId(), getFragment(), getTag()).commit();
        } else {
            fragmentManager.beginTransaction().replace(getContainerViewId(), getFragment(), getTag()).commit();
        }

    }

    @NonNull
    @Override
    protected Fragment getFragment() {
        return HandlingIntentFragment.newInstance(getReceivedUri());
    }

    @NonNull
    @Override
    protected String getTag() {
        return HANDLING_INTENT_FRAGMENT_TAG;
    }

    private Uri getReceivedUri() {
        return receivedUri;
    }
}
