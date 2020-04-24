package client.controller;

import lib.event.GameEvent;
import lib.model.Answer;
import lib.model.Game;
import lib.model.Question;
import lib.service.GameService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class GameController {



    private static final class SingletonHolder {
        public static final GameController INSTANCE = new GameController();
    }

    private GameService gameService;

    private GameController() {
        try {
            Registry registry = LocateRegistry.getRegistry("86.127.126.174", 4544);
            gameService = (GameService) registry.lookup("gameService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static GameController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public List<GameEvent> getEvents(String gameId) {
        try {
            return gameService.getEvents(gameId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String createGame(List<Question> questions) {
        try {
            return gameService.createGame(questions);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Question joinGame(String playerName, String gameId) {
        try {
            return gameService.joinGame(playerName, gameId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Question startGame(String gameId) {
        try {
            return gameService.startGame(gameId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Question nextQuestion(String gameId) {
        try {
            return gameService.nextQuestion(gameId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Question answerAndGetNext(Answer answer) {
        try {
            return gameService.answerAndGetNext(answer);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Game endGame(String gameId) {
        try {
            return gameService.endGame(gameId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
