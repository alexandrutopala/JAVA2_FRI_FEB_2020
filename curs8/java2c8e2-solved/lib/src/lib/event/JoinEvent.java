package lib.event;

import lib.model.Player;

public class JoinEvent implements GameEvent {

    private final Player player;

    private final String gameId;

    public JoinEvent(Player player, String gameId) {
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
