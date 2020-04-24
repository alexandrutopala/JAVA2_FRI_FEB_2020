package server.service;

import lib.event.GameEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;

public class EventService {

    private Map<String, Queue<GameEvent>> events = new ConcurrentHashMap<>();
    private Map<String, CyclicBarrier> monitors = new ConcurrentHashMap<>();

    public void addEvent(GameEvent event, String gameId) {
        var eventQueue = events.computeIfAbsent(gameId, id -> new LinkedBlockingQueue<>());

        eventQueue.add(event);

        CyclicBarrier monitor = monitors.computeIfAbsent(gameId, id -> new CyclicBarrier(Integer.MAX_VALUE));

        monitor.reset();
    }

    public List<GameEvent> getEvents(String gameId) {
        var eventQueue = events.computeIfAbsent(gameId, id -> new LinkedBlockingQueue<>());

        waitForEvents(eventQueue, gameId);

        List<GameEvent> gameEvents = new ArrayList<>(eventQueue);

        eventQueue.clear();

        return gameEvents;
    }

    private void waitForEvents(Queue<GameEvent> eventQueue, String gameId) {
        if (eventQueue.isEmpty()) {
            try {
                CyclicBarrier monitor = monitors.computeIfAbsent(gameId, id -> new CyclicBarrier(Integer.MAX_VALUE));

                monitor.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
            }
        }
    }
}
