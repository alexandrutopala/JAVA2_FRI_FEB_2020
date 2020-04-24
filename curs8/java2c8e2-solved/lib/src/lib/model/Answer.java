package lib.model;

import java.io.Serializable;

public class Answer implements Serializable {

    private final int questionNumber;

    private final String content;

    private final String gamedId;

    private final Player player;

    public Answer(int questionNumber, String content, String gamedId, Player player) {
        this.questionNumber = questionNumber;
        this.content = content;
        this.gamedId = gamedId;
        this.player = player;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getContent() {
        return content;
    }

    public String getGamedId() {
        return gamedId;
    }

    public Player getPlayer() {
        return player;
    }
}
