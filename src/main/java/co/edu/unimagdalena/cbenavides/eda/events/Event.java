package co.edu.unimagdalena.cbenavides.eda.events;

import co.edu.unimagdalena.cbenavides.eda.handlers.HandlerList;
import co.edu.unimagdalena.cbenavides.eda.handlers.HandlerRegistry;

public class Event {
    @SuppressWarnings("unchecked")
    public void callEvent() {
        HandlerList<Event> h_list = (HandlerList<Event>) HandlerRegistry.get()
            .getHandlerList(this.getClass());
        h_list.handle(this);
    }
}
