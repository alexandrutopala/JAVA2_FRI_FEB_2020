package lib.model;

import java.io.Serializable;
import java.util.Map;

public class Question implements Serializable {

    private final int number;

    private final String content;

    private final Map<String, Boolean> choices;

    public Question(int number, String content, Map<String, Boolean> choices) {
        this.number = number;
        this.content = content;
        this.choices = Map.copyOf(choices);
    }

    public String getContent() {
        return content;
    }

    public Map<String, Boolean> getChoices() {
        return choices;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + ") " + content; // 1) Ce este o...
    }
}
