package co.edu.unimagdalena.cbenavides.eda.handlers;

import co.edu.unimagdalena.cbenavides.eda.listeners.Listener;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ListenerMethodHandle<T> implements Handler<T> {
    private final Class<T> clazz;
    private final Listener listener;
    private final EventPriority priority;
    private final Method method;

    public ListenerMethodHandle(Class<T> clazz, Listener listener, EventPriority priority, Method method) {
        this.clazz = clazz;
        this.listener = listener;
        this.priority = priority;
        this.method = method;
    }

    @Override
    public Class<T> getType() {
        return clazz;
    }

    @Override
    public void handle(T obj) {
        try {
            method.invoke(listener, obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("An error occurred while invoking the method: ", e);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred inside event listener: ", e);
        }
    }

    @Override
    public EventPriority getPriority() {
        return priority;
    }

    @Override
    public Listener getListener() {
        return listener;
    }
}
