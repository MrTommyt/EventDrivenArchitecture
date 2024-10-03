package co.edu.unimagdalena.cbenavides.eda.listeners;

import co.edu.unimagdalena.cbenavides.eda.handlers.EventHandler;
import co.edu.unimagdalena.cbenavides.eda.handlers.EventPriority;
import co.edu.unimagdalena.cbenavides.eda.handlers.HandlerRegistry;
import co.edu.unimagdalena.cbenavides.eda.handlers.ListenerMethodHandle;

import java.lang.reflect.Method;

public class ListenerRegistry {
    public static void registerListener(Listener listener) {
        Method[] methods = listener.getClass().getMethods();
        for (Method method : methods) {
            if (!method.isAnnotationPresent(EventHandler.class)) {
                continue;
            }

            EventHandler eventHandler = method.getAnnotation(EventHandler.class);
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1) {
                continue;
            }

            Class<?> eventType = parameterTypes[0];
            EventPriority prio = eventHandler.priority();

            ListenerMethodHandle<?> lmh = new ListenerMethodHandle<>(eventType, listener, prio, method);
            HandlerRegistry.get().registerHandler(eventType, lmh);
        }
    }

    public static void unregisterListener(Listener listener) {
        HandlerRegistry.get().unregisterListener(listener);
    }
}
