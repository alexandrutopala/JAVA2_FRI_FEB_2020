package client.service;

import lib.event.GameEvent;
import lib.model.Answer;
import lib.model.Game;
import lib.model.Player;
import lib.model.Question;
import lib.service.GameService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Optional;

public class GameController {

    private GameService gameService;

    private final static class SingletonHolder {
        public static final GameController INSTANCE = new GameController();
    }

    private GameController() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4545);
            gameService = (GameService) registry.lookup("gameService");
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static GameController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String createGame(List<Question> questions) {
        try {
            return gameService.createGame(questions);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Question> nextQuestion(String gameId) {
        try {
            return Optional.ofNullable(
                    gameService.nextQuestion(gameId)
            );
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Question startGame(String gameId) {
        try {
            return gameService.startGame(gameId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Question joinGame(String gameId, Player player) {
        try {
            return gameService.joinGame(gameId, player);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Question> answer(Answer answer) {
        try {
            return Optional.ofNullable(
                    gameService.answer(answer)
            );
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public List<GameEvent> getEvents(String gameId) {
        try {
            return gameService.getEvents(gameId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
