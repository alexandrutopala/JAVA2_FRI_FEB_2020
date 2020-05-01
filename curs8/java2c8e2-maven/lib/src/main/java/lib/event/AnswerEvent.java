package lib.event;

import lib.model.Player;

public class AnswerEvent extends GameEvent {
    private Player player;

    private String gameId;

    AnswerEvent() {
        super(EventType.ANSWER);
    }

    public AnswerEvent(String gameId, Player player) {
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
