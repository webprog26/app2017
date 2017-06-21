package com.androiddeveloper.webprog26.app2017.engine;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

/**
 * Created by webpr on 21.06.2017.
 */

public interface StartView {

    @NonNull
    FragmentManager _getFragmentManager();

    int getContainerViewId();

    boolean isApprovingIntentReceived();
}
