package lib.event;

import lib.model.Player;

public class AnswerEvent implements GameEvent {
    private final Player player;

    private final String gameId;

    public AnswerEvent(Player player, String gameId) {
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
