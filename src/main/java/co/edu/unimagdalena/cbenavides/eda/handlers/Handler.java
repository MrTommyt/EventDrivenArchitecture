package co.edu.unimagdalena.cbenavides.eda.handlers;

import co.edu.unimagdalena.cbenavides.eda.listeners.Listener;

import java.util.Comparator;

public interface Handler<T> extends Comparable<Handler<T>> {

    Comparator<Handler<?>> COMPARATOR = Comparator.comparing(Handler::getPriority);

    Class<T> getType();

    void handle(T obj);

    EventPriority getPriority();

    Listener getListener();

    @Override
    default int compareTo(Handler<T> o) {
        return COMPARATOR.compare(this, o);
    }
}
