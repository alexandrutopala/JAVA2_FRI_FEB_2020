package lib.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Game implements Serializable {

    private final String id;

    private final List<Player> players;

    private final List<Question> questions;

    public Game(String id, List<Player> players, List<Question> questions) {
        this.id = id;
        this.players = players;
        this.questions = List.copyOf(questions);
    }

    public String getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public synchronized void addPlayer(Player p) {
        players.add(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
