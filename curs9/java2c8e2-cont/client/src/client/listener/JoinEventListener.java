package client.listener;

import lib.event.JoinEvent;

public interface JoinEventListener extends GameEventListener<JoinEvent> {

    @Override
    default boolean isApplicable(Class<?> eventClass) {
        return JoinEvent.class.equals(eventClass);
    }
}
