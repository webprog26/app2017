package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations;

import android.net.Uri;

import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.StartPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.StartView;
import com.androiddeveloper.webprog26.app2017.engine.commands.SetHandlingIntentFragmentCommand;
import com.androiddeveloper.webprog26.app2017.engine.commands.SetStartFragmentCommand;

/**
 * Created by webpr on 21.06.2017.
 */

public class StartPresenterImpl implements StartPresenter {

    private StartView mStartView;

    @Override
    public void setView(StartView view) {
        this.mStartView = view;
    }

    @Override
    public void setStartFragment(final int containerViewId) {
        new SetStartFragmentCommand(getStartView()._getFragmentManager(), containerViewId).execute();
    }

    @Override
    public void setHandlingIntentFragment(final int containerViewId, final Uri receivedUri) {
        new SetHandlingIntentFragmentCommand(getStartView()._getFragmentManager(), containerViewId, receivedUri).execute();
    }

    private StartView getStartView() {
        return mStartView;
    }
}
