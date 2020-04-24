package client.dispatcher;

import lib.event.GameEvent;

interface GameEventListener<ET extends GameEvent> {

    Class<ET> getRequiredEventType();

    void onEvent(ET event);
}
