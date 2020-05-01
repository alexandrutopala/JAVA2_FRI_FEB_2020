package lib.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// obiect DTO : data transfer object
public class Game implements Serializable {

    private final String id;

    private final List<Question> questions;

    private final Set<Player> players;

    public Game(String id, List<Question> questions) {
        this.id = id;
        this.questions = List.copyOf(questions);
        this.players = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Set<Player> getPlayers() {
        return Set.copyOf(players);
    }

    public void addPlayer(Player p) {
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
