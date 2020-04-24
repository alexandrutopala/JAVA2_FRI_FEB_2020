package client.dispatcher;

import lib.event.JoinEvent;

public interface JoinEventListener extends GameEventListener<JoinEvent> {

    @Override
    default Class<JoinEvent> getRequiredEventType() {
        return JoinEvent.class;
    }
}
