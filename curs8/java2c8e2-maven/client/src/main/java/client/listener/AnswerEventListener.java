package client.listener;

import lib.event.AnswerEvent;

public interface AnswerEventListener extends GameEventListener<AnswerEvent> {

    @Override
    default boolean isApplicable(Class<?> eventClass) {
        return AnswerEvent.class.equals(eventClass);
    }
}
