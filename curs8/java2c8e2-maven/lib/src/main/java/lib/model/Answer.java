package lib.model;

import java.io.Serializable;

public class Answer implements Serializable {

    private int questionNumber;

    private String content;

    private String gamedId;

    private Player player;

    Answer() {
    }

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
