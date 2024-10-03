package consoletest;

import consoletest.event.ConsoleExecuteCommandEvent;

import java.util.Scanner;

public class Console extends Thread {
    private final Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while (true) {
            String command = scanner.nextLine();
            if (command == null || command.isBlank()) {
                continue;
            }

            ConsoleExecuteCommandEvent cecm = new ConsoleExecuteCommandEvent(command);
            cecm.callEvent();
        }
    }
}
