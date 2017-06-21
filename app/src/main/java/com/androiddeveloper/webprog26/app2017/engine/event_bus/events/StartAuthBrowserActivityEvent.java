package com.androiddeveloper.webprog26.app2017.engine.event_bus.events;

/**
 * Created by webpr on 21.06.2017.
 */

public class StartAuthBrowserActivityEvent {

    private final String authUrl;

    public StartAuthBrowserActivityEvent(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getAuthUrl() {
        return authUrl;
    }
}
