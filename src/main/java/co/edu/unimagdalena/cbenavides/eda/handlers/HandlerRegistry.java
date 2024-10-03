package co.edu.unimagdalena.cbenavides.eda.handlers;

import co.edu.unimagdalena.cbenavides.eda.events.Event;
import co.edu.unimagdalena.cbenavides.eda.listeners.Listener;

import java.util.HashMap;
import java.util.Map;

public class HandlerRegistry {

    private final Map<Class<?>, HandlerList<?>> handlerMap = new HashMap<>();
    private static final HandlerRegistry instance = new HandlerRegistry();

    private HandlerRegistry() {
    }

    public static HandlerRegistry get() {
        return instance;
    }

    public void registerHandler(Class<?> type, Handler<?> handler) {
        HandlerList<?> handlerList = handlerMap.computeIfAbsent(type, c -> new HandlerList<>());
        handlerList.addHandler(handler);
    }

    public void unregisterListener(Listener listener) {
        handlerMap.forEach((k, list) -> list.removeListener(listener));
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> HandlerList<T> getHandlerList(Class<T> type) {
        return (HandlerList<T>) handlerMap.get(type);
    }

    public Map<Class<?>, HandlerList<?>> getHandlerMap() {
        return handlerMap;
    }

}
