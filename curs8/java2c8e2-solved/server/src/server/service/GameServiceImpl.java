package server.service;

import lib.event.AnswerEvent;
import lib.event.GameEvent;
import lib.event.JoinEvent;
import lib.model.Answer;
import lib.model.Game;
import lib.model.Player;
import lib.model.Question;
import lib.service.GameService;
import server.repository.GameRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class GameServiceImpl extends UnicastRemoteObject implements GameService {

    private Map<String, CyclicBarrier> monitors = new ConcurrentHashMap<>();

    private GameRepository gameRepository;

    private EventService eventService;

    public GameServiceImpl() throws RemoteException {
        this.gameRepository = new GameRepository();
        this.eventService = new EventService();
    }

    @Override
    public String createGame(List<Question> questions) {
        String gameId = gameRepository.createGame(questions);
        monitors.putIfAbsent(gameId, new CyclicBarrier(Integer.MAX_VALUE));

        return gameId;
    }

    @Override
    public Question joinGame(String playerName, String gameId) throws RemoteException {
        Game game = gameRepository.getById(gameId);

        Player player = new Player(playerName);

        synchronized (game) {
            if (game.getPlayers().contains(player)) {
                throw new IllegalArgumentException();
            } else {
                game.addPlayer(player);
            }
        }

        eventService.addEvent(
                new JoinEvent(player, gameId),
                gameId
        );

        waitForGame(game);

        return gameRepository.getCurrentQuestion(gameId);
    }

    private void waitForGame(Game game) throws RemoteException {
        try {
            monitors.get(game.getId()).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage());
        } catch (BrokenBarrierException e) {
        }
    }

    @Override
    public Question startGame(String gameId) throws RemoteException {
        Game game = gameRepository.getById(gameId);

        monitors.get(game.getId()).reset();

        return gameRepository.getCurrentQuestion(gameId);
    }


    @Override
    public Question answerAndGetNext(Answer answer) throws RemoteException {
        Game game = gameRepository.getById(answer.getGamedId());

        int points =
            game.getQuestions().stream()
                    .filter(question -> question.getNumber() == answer.getQuestionNumber())
                    .map(Question::getChoices)
                    .flatMap(choices -> choices.entrySet().stream())
                    .filter(choice -> choice.getKey().equals(answer.getContent()))
                    .filter(Map.Entry::getValue)
                    .mapToInt(choice -> 100)
                    .sum();

        game.getPlayers().stream()
                .filter(player -> player.equals(answer.getPlayer()))
                .forEach(player -> player.incrementScore(points));

        eventService.addEvent(
                new AnswerEvent(answer.getPlayer(), answer.getGamedId()),
                answer.getGamedId()
        );

        waitForGame(game);

        return gameRepository.getCurrentQuestion(answer.getGamedId());
    }

    @Override
    public Question nextQuestion(String gameId) throws RemoteException {
        Question next = gameRepository.nextQuestion(gameId);

        monitors.get(gameId).reset();

        return next;
    }

    @Override
    public int getScoreForPlayer(Player player, String gameId) throws RemoteException {
        Game game = gameRepository.getById(gameId);

        return game.getPlayers().stream()
                .filter(gamePlayer -> gamePlayer.equals(player))
                .mapToInt(Player::getScore)
                .findFirst()
                .getAsInt();
    }

    @Override
    public Game endGame(String gameId) throws RemoteException {
        return gameRepository.endGame(gameId);
    }

    @Override
    public List<GameEvent> getEvents(String gameId) throws RemoteException {
        return eventService.getEvents(gameId);
    }
}
