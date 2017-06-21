package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations;

import android.support.annotation.NonNull;

import com.androiddeveloper.webprog26.app2017.dagger.App;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.StartFragmentPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.StartFragmentView;
import com.androiddeveloper.webprog26.app2017.engine.twitter_app.TwitterGetter;
import com.androiddeveloper.webprog26.app2017.engine.commands.GetRequestTokenCommand;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.EventsHandler;
import com.androiddeveloper.webprog26.app2017.engine.event_bus.events_handlers.StartFragmentEventsHandler;

import javax.inject.Inject;

/**
 * Created by webpr on 21.06.2017.
 */

public class StartFragmentPresenterImpl implements StartFragmentPresenter {

    private static final String TAG = "StartFragmentPresenter";

    private StartFragmentView startFragmentView;

    @Inject
    TwitterGetter mTwitterGetter;

    public StartFragmentPresenterImpl() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void setView(StartFragmentView startFragmentView) {
        this.startFragmentView = startFragmentView;
    }

    @Override
    public void askOauth() {
        new GetRequestTokenCommand(mTwitterGetter.getTwitter()).execute();
    }

    @NonNull
    @Override
    public EventsHandler getEventsHandler() {
        return new StartFragmentEventsHandler(this);
    }

    @NonNull
    @Override
    public TwitterGetter getTwitterGetter() {
        return mTwitterGetter;
    }

    @Override
    public void startAuthBrowserActivity(String authUrl) {
        getStartFragmentView().startAuthBrowserActivity(authUrl);
    }

    private StartFragmentView getStartFragmentView() {
        return startFragmentView;
    }
}
