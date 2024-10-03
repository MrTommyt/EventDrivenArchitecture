package consoletest.event;

import co.edu.unimagdalena.cbenavides.eda.events.Event;

public class ConsoleExecuteCommandEvent extends Event {
    private String command;

    public ConsoleExecuteCommandEvent(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
