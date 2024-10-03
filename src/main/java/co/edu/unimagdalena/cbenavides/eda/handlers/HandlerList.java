package co.edu.unimagdalena.cbenavides.eda.handlers;

import co.edu.unimagdalena.cbenavides.eda.events.Event;
import co.edu.unimagdalena.cbenavides.eda.listeners.Listener;

import java.util.*;

public class HandlerList<T extends Event> {
    private final SortedSet<Handler<T>> handlerList = new TreeSet<>();

    public HandlerList() {
    }

    @SuppressWarnings("unchecked")
    public void addHandler(Handler<?> handler) {
        handlerList.add((Handler<T>) handler);
    }

    public SortedSet<Handler<T>> getHandlerList() {
        return handlerList;
    }

    public void handle(T event) {
        try {
            handlerList.forEach(h -> h.handle(event));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeListener(Listener listener) {
        handlerList.removeIf(h -> h.getListener() == listener);
    }
}
