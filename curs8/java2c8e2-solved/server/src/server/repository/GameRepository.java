package server.repository;

import lib.model.Game;
import lib.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GameRepository {

    private static AtomicInteger gameId = new AtomicInteger(0);
    private Map<String, Game> games = new ConcurrentHashMap<>();
    private Map<String, Integer> currentQuestion = new ConcurrentHashMap<>();

    public String createGame(List<Question> questions) {
        Game game = new Game(
                String.valueOf(gameId.getAndIncrement()),
                new ArrayList<>(),
                questions
        );

        games.put(game.getId(), game);
        currentQuestion.put(game.getId(), 0);

        return game.getId();
    }

    public Game getById(String gameId) {
        return Optional.ofNullable(games.get(gameId))
                .orElseThrow(IllegalArgumentException::new);
    }

    public Question getCurrentQuestion(String gameId) {
        int questionIndex = currentQuestion.get(gameId);

        Game game = games.get(gameId);

        try {
            return game.getQuestions().get(questionIndex);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Question nextQuestion(String gameId) {
        int questionIndex = currentQuestion.get(gameId);
        currentQuestion.replace(gameId, ++questionIndex);

        return getCurrentQuestion(gameId);
    }

    public Game endGame(String gameId) {
        currentQuestion.remove(gameId);

        Game game = games.get(gameId);

        games.remove(gameId);

        return game;
    }
}
