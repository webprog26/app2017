package com.androiddeveloper.webprog26.app2017.engine.mvp.presenters.interfaces;

import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;

/**
 * Created by webpr on 21.06.2017.
 */

public interface MainPresenter {

    void setView(MainView mainView);
    void askLogout();
}
