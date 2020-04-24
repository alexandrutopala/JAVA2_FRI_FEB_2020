package client.listener;

import client.service.GameController;
import lib.event.GameEvent;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class DispatcherService {
    private ScheduledExecutorService executor;

    private static Map<String, DispatcherService> registry = new ConcurrentHashMap<>();

    private List<GameEventListener> listeners = new CopyOnWriteArrayList<>();

    private String gameId;

    private DispatcherService(String gameId) {
        this.gameId = gameId;
        executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleWithFixedDelay(
                () -> GameController.getInstance().getEvents(gameId)
                      .forEach(this::notifyListeners),
                0,
                1,
                TimeUnit.SECONDS
        );
    }

    public static DispatcherService getInstance(String gameId) {
        registry.putIfAbsent(gameId, new DispatcherService(gameId));

        return registry.get(gameId);
    }

    public void addListener(GameEventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(GameEventListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(GameEvent event) {
        listeners.stream()
                .filter(listener -> listener.isApplicable(event.getClass()))
                .forEach(listener -> listener.accept(event));
    }
}
