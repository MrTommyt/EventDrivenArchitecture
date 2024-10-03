package base.event;

import co.edu.unimagdalena.cbenavides.eda.events.Event;

public class EventA extends Event {
    private int i;

    public EventA(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
