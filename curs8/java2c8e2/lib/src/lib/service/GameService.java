package lib.service;

import lib.event.GameEvent;
import lib.model.Answer;
import lib.model.Player;
import lib.model.Question;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GameService extends Remote {

    String createGame(List<Question> questions) throws RemoteException;

    // pentru game-owner
    Question startGame(String gameId) throws RemoteException;

    // pentru game-owner
    Question nextQuestion(String gameId) throws RemoteException;

    // pentru player
    Question joinGame(String gameId, Player player) throws RemoteException;

    // pentru player
    Question answer(Answer answer) throws RemoteException;

    List<GameEvent> getEvents(String gameId) throws RemoteException;
}
