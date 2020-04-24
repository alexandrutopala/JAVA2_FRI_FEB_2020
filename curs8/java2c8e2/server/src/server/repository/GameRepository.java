package server.repository;

import lib.model.Game;
import lib.model.Question;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GameRepository {
    private static AtomicInteger idGenerator = new AtomicInteger(0);

    private Map<String, Game> games = new ConcurrentHashMap<>();

    private Map<String, Integer> currentQuestion = new ConcurrentHashMap<>();

    public Game createGame(List<Question> questions) {
        int nextId = idGenerator.getAndIncrement();
        String id = String.valueOf(nextId);

        Game game = new Game(id, questions);

        games.put(id, game);
        currentQuestion.put(id, 0);

        return game;
    }

    public Game findById(String gameId) {
        return games.get(gameId);
    }

    public Question getNextQuestion(String gameId) {
        int questionIndex = currentQuestion.get(gameId);

        Game game = findById(gameId);

        try {
            Question nextQuestion = game.getQuestions().get(questionIndex);

            currentQuestion.put(gameId, ++questionIndex);

            return nextQuestion;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Question getCurrentQuestion(String gameId) {
        int questionIndex = currentQuestion.get(gameId);

        try {
            Game game = findById(gameId);

            return game.getQuestions().get(questionIndex);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
