package lib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game implements Serializable {

    private String id;

    private List<Player> players;

    private List<Question> questions;

    Game() {
    }

    public Game(String id, List<Question> questions) {
        this.id = id;
        this.players = new ArrayList<>();
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
