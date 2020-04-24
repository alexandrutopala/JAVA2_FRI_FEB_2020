package client.dispatcher;

import lib.event.AnswerEvent;
import lib.event.GameEvent;

public interface AnswerEventListener extends GameEventListener<AnswerEvent> {

    @Override
    default Class<AnswerEvent> getRequiredEventType() {
        return AnswerEvent.class;
    }
}
