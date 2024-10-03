package consoletest.listener;

import co.edu.unimagdalena.cbenavides.eda.handlers.EventHandler;
import co.edu.unimagdalena.cbenavides.eda.handlers.EventPriority;
import co.edu.unimagdalena.cbenavides.eda.listeners.Listener;
import consoletest.event.ConsoleExecuteCommandEvent;

public class CommandListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onCommandLowPrio(ConsoleExecuteCommandEvent event) {
        System.out.printf("(low-prio) Received command: %s%n", event.getCommand());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommandHighPrio(ConsoleExecuteCommandEvent event) {
        System.out.printf("(high-prio) Received command: %s%n", event.getCommand());
    }

    @EventHandler
    public void onCommand(ConsoleExecuteCommandEvent event) {
        System.out.printf("Received command: %s [Comando cambiado en prioridad normal] %n", event.getCommand());
        event.setCommand("cambiado");
    }
}
