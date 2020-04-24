package client.dispatcher;

import client.controller.GameController;
import lib.event.GameEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class DispatcherService {

    private static Map<String, DispatcherService> registry = new ConcurrentHashMap<>();

    private String gameId;

    private Set<GameEventListener> listeners = new CopyOnWriteArraySet<>();

    private ScheduledExecutorService eventExecutorService;

    private DispatcherService(String gameId) {
        this.gameId = gameId;
        this.eventExecutorService = Executors.newSingleThreadScheduledExecutor();

        eventExecutorService.scheduleWithFixedDelay(
                this::listenToEvents,
                0,
                1,
                TimeUnit.SECONDS
        );
    }

    public static synchronized DispatcherService get(String gameId) {
        return registry.computeIfAbsent(gameId, DispatcherService::new);
    }

    private void listenToEvents() {
        List<GameEvent> events = GameController.getInstance().getEvents(gameId);

        events.forEach(event -> {
            listeners.stream()
                    .filter(listener -> listener.getRequiredEventType().equals(event.getClass()))
                    .forEach(listener -> listener.onEvent(event));
        });
    }

    public void addListener(GameEventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(GameEventListener listener) {
        listeners.remove(listener);
    }
}
