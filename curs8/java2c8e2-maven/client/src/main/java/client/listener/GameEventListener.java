package client.listener;

import lib.event.GameEvent;

public interface GameEventListener<EV extends GameEvent> {

    boolean isApplicable(Class<?> eventClass);

    void accept(EV event);
}
