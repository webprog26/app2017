package com.androiddeveloper.webprog26.app2017.engine;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by webpr on 21.06.2017.
 */

public abstract class EventsHandler {

    public void register(){
        EventBus.getDefault().register(this);
    }

    public void unregister(){
        EventBus.getDefault().unregister(this);
    }
}
