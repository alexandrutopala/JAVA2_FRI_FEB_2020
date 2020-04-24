package lib.model;

import java.io.Serializable;

public class Answer implements Serializable {

    private final String gameId;

    private final int questionNumber;

    private final Player player;

    private final String choice;

    public Answer(String gameId, int questionNumber, Player player, String choice) {
        this.gameId = gameId;
        this.questionNumber = questionNumber;
        this.player = player;
        this.choice = choice;
    }

    public String getGameId() {
        return gameId;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public String getChoice() {
        return choice;
    }
}
