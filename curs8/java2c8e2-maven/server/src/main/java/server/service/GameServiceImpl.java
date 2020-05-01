package server.service;

import lib.event.GameEvent;
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

    private GameRepository gameRepository;

    private EventService eventService;

    private Map<String, CyclicBarrier> monitors = new ConcurrentHashMap<>();

    public GameServiceImpl(GameRepository gameRepository, EventService eventService) throws RemoteException {
        this.gameRepository = gameRepository;
        this.eventService = eventService;
    }

    @Override
    public String createGame(List<Question> questions) throws RemoteException {
        Game game = gameRepository.createGame(questions);

        monitors.put(game.getId(), new CyclicBarrier(Integer.MAX_VALUE));

        eventService.createEventQueue(game.getId());

        return game.getId();
    }

    @Override
    public Question startGame(String gameId) throws RemoteException {
        notifyForGame(gameId);

        return gameRepository.getCurrentQuestion(gameId);
    }

    @Override
    public Question nextQuestion(String gameId) throws RemoteException {
        Question nextQuestion = gameRepository.getNextQuestion(gameId);

        notifyForGame(gameId);

        return nextQuestion;
    }

    @Override
    public Question joinGame(String gameId, Player player) throws RemoteException {
        Game game = gameRepository.findById(gameId);

        synchronized (game) {
            boolean exists =
                    game.getPlayers().stream()
                        .anyMatch(p -> p.equals(player));

            if (exists) {
                throw new IllegalArgumentException("numele exista");
            } else {
                game.addPlayer(player);
            }
        }

        eventService.addJoinEvent(gameId, player);

        waitForGame(gameId);

        return gameRepository.getCurrentQuestion(gameId);
    }

    private void waitForGame(String gameId) {
        CyclicBarrier monitor = monitors.get(gameId);

        try {
            monitor.await();
        } catch (InterruptedException | BrokenBarrierException e) {
        }
    }

    private void notifyForGame(String gameId) {
        CyclicBarrier monitor = monitors.get(gameId);

        monitor.reset();
    }

    @Override
    public Question answer(Answer answer) throws RemoteException {
        // TODO: validarea raspunsului

        eventService.addAnswerEvent(answer);

        waitForGame(answer.getGameId());

        return gameRepository.getCurrentQuestion(answer.getGameId());
    }

    @Override
    public List<GameEvent> getEvents(String gameId) throws RemoteException {
        return eventService.getEvents(gameId);
    }
}
