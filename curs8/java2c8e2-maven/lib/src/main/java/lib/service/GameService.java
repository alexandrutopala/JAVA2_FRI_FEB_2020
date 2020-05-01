package lib.service;

import lib.event.GameEvent;
import lib.model.Answer;
import lib.model.Game;
import lib.model.Player;
import lib.model.Question;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GameService extends Remote {

    String createGame(List<Question> questions) throws RemoteException;

    // pentru player
    Question joinGame(String playerName, String gameId) throws RemoteException;

    // pentru game owner
    Question startGame(String gameId) throws RemoteException;

    Question nextQuestion(String gameId) throws RemoteException;

    Question answerAndGetNext(Answer answer) throws RemoteException;

    int getScoreForPlayer(Player player, String gameId) throws RemoteException;

    Game endGame(String gameId) throws RemoteException;

    List<GameEvent> getEvents(String gameId) throws RemoteException;
}
