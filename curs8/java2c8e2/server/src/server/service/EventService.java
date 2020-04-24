package server.service;

import lib.event.AnswerEvent;
import lib.event.GameEvent;
import lib.event.JoinEvent;
import lib.model.Answer;
import lib.model.Player;
import lib.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

public class EventService {

    private Map<String, Queue<GameEvent>> eventQueues = new ConcurrentHashMap<>();

    private Map<String, CyclicBarrier> monitors = new ConcurrentHashMap<>();

    public void createEventQueue(String id) {
        eventQueues.put(id, new LinkedBlockingQueue<>());
        monitors.put(id, new CyclicBarrier(Integer.MAX_VALUE));
    }

    public void addJoinEvent(String gameId, Player player) {
        JoinEvent joinEvent = new JoinEvent(gameId, player);

        Queue<GameEvent> queue = eventQueues.get(gameId);

        queue.add(joinEvent);

        notifyForEvents(gameId);
    }

    public List<GameEvent> getEvents(String gameId) {
        Queue<GameEvent> queue = eventQueues.get(gameId);

        // TODO: bloc atomic
        if (queue.isEmpty()) {
            waitForEvents(gameId);
        }

        List<GameEvent> events = new ArrayList<>(queue);

        queue.clear();

        return events;
    }

    private void waitForEvents(String gameId) {
        CyclicBarrier monitor = monitors.get(gameId);

        try {
            monitor.await();
        } catch (InterruptedException | BrokenBarrierException e) {
        }
    }

    private void notifyForEvents(String gameId) {
        CyclicBarrier monitor = monitors.get(gameId);

        monitor.reset();
    }

    public void addAnswerEvent(Answer answer) {
        GameEvent event = new AnswerEvent(answer.getGameId(), answer.getPlayer(), answer);

        Queue<GameEvent> queue = eventQueues.get(answer.getGameId());

        queue.add(event);

        notifyForEvents(answer.getGameId());
    }


}
