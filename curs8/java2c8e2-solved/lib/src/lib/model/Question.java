package lib.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Question implements Serializable {

    private final int number;

    private final String content;

    private final Map<String, Boolean> choices;

    public Question(int number, String content, Map<String, Boolean> choices) {
        this.number = number;
        this.content = content;
        this.choices = Map.copyOf(choices);
    }

    public int getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    public Map<String, Boolean> getChoices() {
        return choices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return number == question.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
