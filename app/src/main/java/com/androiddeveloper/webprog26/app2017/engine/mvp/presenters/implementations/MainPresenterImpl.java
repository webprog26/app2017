package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.implementations;

import android.content.SharedPreferences;

import com.androiddeveloper.webprog26.app2017.constants.Constants;
import com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces.MainPresenter;
import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;

/**
 * Created by webpr on 21.06.2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    @Override
    public void setView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void askLogout() {
        SharedPreferences sharedPreferences = getMainView().getSharedPreferences();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(Constants.PREF_KEY_TOKEN);
        editor.remove(Constants.PREF_KEY_SECRET);
        editor.remove(Constants.IS_LOGGED_IN);

        editor.apply();

        getMainView().backToStartActivity();
    }

    private MainView getMainView() {
        return mainView;
    }
}
