package consoletest;

import co.edu.unimagdalena.cbenavides.eda.listeners.ListenerRegistry;
import consoletest.listener.CommandListener;

public class MainConsoleTest {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Console console = new Console();
        console.start();

        //register listener
        CommandListener cl = new CommandListener();
        ListenerRegistry.registerListener(cl);

        while (true) {
            try {
                Thread.sleep(1000);
//                System.out.println("Hi, I'm still alive");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
