package lib.event;

import lib.model.Answer;
import lib.model.Player;

public class AnswerEvent implements GameEvent {

    private final String gameId;

    private final Player player;

    private final Answer answer;

    public AnswerEvent(String gameId, Player player, Answer answer) {
        this.gameId = gameId;
        this.player = player;
        this.answer = answer;
    }

    public String getGameId() {
        return gameId;
    }

    public Player getPlayer() {
        return player;
    }

    public Answer getAnswer() {
        return answer;
    }
}
