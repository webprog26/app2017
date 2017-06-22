package com.androiddeveloper.webprog26.app2017.engine.view_pager_adapter;

import com.androiddeveloper.webprog26.app2017.engine.mvp.views.MainView;

/**
 * Created by webpr on 22.06.2017.
 */

public interface TitleSubscriber {

    void subscribe(MainView mainView);
    void notifyTitleChanged(int position);
}
