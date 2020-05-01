package lib.event;

import lib.model.Player;

public class JoinEvent extends GameEvent {

    private Player player;

    private String gameId;

    JoinEvent() {
        super(EventType.JOIN);
    }

    public JoinEvent(String gameId, Player player) {
        this();
        this.player = player;
        this.gameId = gameId;
    }

    public Player getPlayer() {
        return player;
    }

    public String getGameId() {
        return gameId;
    }
}
