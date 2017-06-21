package com.androiddeveloper.webprog26.app2017.engine;

import android.net.Uri;

/**
 * Created by webpr on 21.06.2017.
 */

public interface StartPresenter {

    void setView(StartView view);
    void setStartFragment(final int containerViewId);
    void setHandlingIntentFragment(final int containerViewId, final Uri receivedUri);


}
