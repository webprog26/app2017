package com.androiddeveloper.webprog26.app2017.engine.commands;

import com.androiddeveloper.webprog26.app2017.engine.event_bus.events.GetTwitterTimelineEvent;

import org.greenrobot.eventbus.EventBus;

import twitter4j.Twitter;

/**
 * Created by webpr on 22.06.2017.
 */

public class GetTwitterTimelineCommand implements Command {

    private final Twitter mTwitter;

    public GetTwitterTimelineCommand(Twitter twitter) {
        this.mTwitter = twitter;
    }

    @Override
    public void execute() {
        EventBus.getDefault().post(new GetTwitterTimelineEvent(getTwitter()));
    }

    private Twitter getTwitter() {
        return mTwitter;
    }
}
